package com.jiggy.sample.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
  
  @Autowired
  private UserService userService;
  
  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    logger.info("onLoginSuccess");
    
    Object primaryPrincipal = subject.getPrincipals().getPrimaryPrincipal();
    
    if (primaryPrincipal instanceof UserPrincipal) {
      UserPrincipal userPrincipal = (UserPrincipal) primaryPrincipal;
      User user = this.userService.findById(userPrincipal.getId());
      UserProfile userProfile = new UserProfile(user);
      
      SessionUtil.setUserProfile(userProfile);
    }
    return super.onLoginSuccess(token, subject, request, response);
  }
  
  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    logger.info("onLoginFailure");
    return super.onLoginFailure(token, e, request, response);
  }
  
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    logger.info("onAccessDenied WebUtils.toHttp(request).getRequestURL()= {}", WebUtils.toHttp(request).getRequestURL());
    
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