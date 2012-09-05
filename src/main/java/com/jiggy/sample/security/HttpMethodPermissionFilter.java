package com.jiggy.sample.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiggy.sample.framework.searchengine.DefaultSearchCriteria;
import com.jiggy.sample.framework.searchengine.FilterExpression.FilterTerm;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

/**
 * Filter to handle permission.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class HttpMethodPermissionFilter extends org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter {
	private final static String FIND_ALL_ID = "-1";
	private final static String FIND_PATH = "/find";
	private final static String BASE_PATH = "/sample/service/";
	private final static Logger logger = LoggerFactory.getLogger(HttpMethodPermissionFilter.class);
	
	//private PermissionService permissionService;
	//private UserProfileService userProfileService;

	
	@Override
	protected String getHttpMethodAction(ServletRequest request) {
		String method = ((HttpServletRequest) request).getMethod();
		String requestURI = ((HttpServletRequest) request).getRequestURI();
		String requestURISuffix = this.getRequestURISuffix(requestURI);
		String restMethodAction = super.getHttpMethodAction(method);
		String id = this.getId(request, requestURI, restMethodAction, requestURISuffix);
		String methodAction = getHttpMethodAction(id, restMethodAction, requestURI, requestURISuffix);

		if (!StringUtils.isBlank(id))
			methodAction += ":" + id;

		return methodAction;
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {

		String requestURI = ((HttpServletRequest) request).getRequestURI();
		String resourseName = this.getResourseName(requestURI);

		String[] perms = new String[] { resourseName };

		refreshPermissionsIfNeeded();
		boolean result = super.isAccessAllowed(request, response, perms);
		logger.debug(
				"isAccessAllowed(): service={}, perms={}, mappedValue={}, RequestURI={} result={}",
				new Object[] { resourseName, perms, mappedValue, requestURI,
						Boolean.valueOf(result) });
		return result;
	}
	
	private void refreshPermissionsIfNeeded() {
		if (SessionUtil.isPermissionRefreshNeeded()) {
			SessionUtil.clearPermissionRefreshNeeded();
			//this.userProfileServiceProvider.get().refreshPermissions(SessionUtil.getProfile().getRole());
		}
	}

	@Override
	protected void postHandle(ServletRequest request, ServletResponse response)
			throws Exception {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String method = httpServletRequest.getMethod();
		String requestURI = httpServletRequest.getRequestURI();
		String resourseName = this.getResourseName(requestURI);
		String restMethodAction = getHttpMethodAction(method);

		if (shouldRefresh(resourseName, restMethodAction)) {
			SessionUtil.setPermissionRefreshNeeded();
		}
	}

	private boolean shouldRefresh(String resource, String action) {
		return resource.equals("master") && !"read".equals(action);
	}

	private String getHttpMethodAction(String id, String restMethodAction,
			String requestURI, String requestURISuffix) {

		String resourseName = this.getResourseName(requestURI);
		String operationName = resourseName;

		if (StringUtils.isBlank(id) || FIND_ALL_ID.equals(id)) {
			if (!StringUtils.isBlank(requestURISuffix)
					&& !requestURISuffix.contains(FIND_PATH.substring(1)))
				operationName = requestURISuffix;
		} else {
			if (StringUtils.isBlank(requestURISuffix)
					|| !requestURISuffix.contains(FIND_PATH.substring(1)))
				operationName = this.getRequestURISuffix(requestURI.substring(
						0, requestURI.length() - (id.length() + 1)));
		}

		if (resourseName.equals(operationName))
			operationName = restMethodAction;
		else {
			SearchCriteria searchCriteria = new DefaultSearchCriteria();
			searchCriteria.addFilter(new FilterTerm(
					"resourceOperation.resource", resourseName));
			searchCriteria.addFilter(new FilterTerm(
					"resourceOperation.operation", operationName));
			List<Permission> permissions = null; //this.permissionService.get().find(searchCriteria);

			if (permissions == null || permissions.isEmpty())
				operationName = restMethodAction;
		}
		return operationName;
	}

	private String getResourseName(String requestURI) {
		String resourseName;
		int startIndx = BASE_PATH.length();
		int finishIndx = requestURI.indexOf('/', startIndx);

		if (finishIndx == -1)
			resourseName = requestURI.substring(startIndx);
		else
			resourseName = requestURI.substring(startIndx, finishIndx);

		return resourseName;
	}

	/**
	 * @param request
	 * @return
	 */
	private String getId(ServletRequest request, String requestURI,
			String methodAction, String requestURISuffix) {
		String id = null;

		if (!"create".equalsIgnoreCase(methodAction))
			id = requestURISuffix;

		if (!StringUtils.isBlank(id)) {
			try {
				Long.valueOf(id); // Check if this is an id.
			} catch (NumberFormatException nfe) {
				id = null;

				if ("read".equalsIgnoreCase(methodAction)) {
					StringBuilder builder = new StringBuilder(BASE_PATH)
							.append(this.getResourseName(requestURI));
					String findURL = builder.toString() + FIND_PATH;

					if (builder.toString().equals(requestURI)
							|| (requestURI.indexOf(findURL) != -1 && requestURI
									.indexOf(findURL + "/") == -1)) {
						id = FIND_ALL_ID;
					}
				}
			}
		}

		return id;
	}

	/**
	 * @param request
	 * @return
	 */
	private String getRequestURISuffix(String requestURI) {
		return requestURI.substring(requestURI.lastIndexOf('/') + 1);
	}
}