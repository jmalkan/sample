package com.jiggy.sample.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extension of the basic forms authentication filter which supports: -forcing redirect to change password screen if user is marked as such -default
 * start pages per user role
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class UserFormAuthenticationFilter extends FormAuthenticationFilter {
  private static final Logger logger = LoggerFactory.getLogger(UserFormAuthenticationFilter.class);
  
//  private String loginFormUrl;
//  
//  public UserFormAuthenticationFilter() {
//    this.loginFormUrl = "/login.html";
//    setLoginUrl("/login");
//  }
//  
//  public String getLoginFormUrl() {
//    return this.loginFormUrl;
//  }
//  
//  public void setLoginFormUrl(String loginFormUrl) {
//    this.loginFormUrl = loginFormUrl;
//  }
  
  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    logger.info("onLoginSuccess");
    return super.onLoginSuccess(token, subject, request, response);
  }
  
  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    logger.info("onLoginFailure");
//    try {
//      Map<String, String> params = new HashMap<String, String>();
//      params.put("error", "true");
//      WebUtils.issueRedirect(request, response, loginFormUrl, params);
//      return false;
//    } catch (IOException ex) {
      return super.onLoginFailure(token, e, request, response);
//    }
  }
  
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    logger.info("onAccessDenied WebUtils.toHttp(request).getRequestURL()= {}", WebUtils.toHttp(request).getRequestURL());
//    if (!isLoginRequest(request, response) && !isLoginSubmission(request, response)) {
//      WebUtils.toHttp(response).setStatus(Status.UNAUTHORIZED.getStatusCode());
//      return false;
//    }
    
    return super.onAccessDenied(request, response);
  }
  
  @Override
  protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
    logger.info("setFailureAttribute");
    String message = ae.getMessage();
    request.setAttribute("error", "true");
    request.setAttribute(getFailureKeyAttribute(), message);
  }
}