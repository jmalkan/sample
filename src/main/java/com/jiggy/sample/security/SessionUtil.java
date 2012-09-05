package com.jiggy.sample.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Utility to access Shiro session info.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class SessionUtil {
  public static final String USER_PROFILE_ATTRIBUTE = User.class.getName();
  public static final String PERMISSION_REFRESH_NEEDED = "permissionRefreshNeeded";
  
  public static Subject getCurrentUser() {
      return SecurityUtils.getSubject();
  }
  
  public static Session getSession() {
      return getCurrentUser().getSession();
  }
  
  public static Object getAttribute(String attribute) {
      return getSession().getAttribute(attribute);
  }
  
  public static void setAttribute(String attribute, Object value) {
      getSession().setAttribute(attribute, value);
  }
  
  public static SessionProfile getProfile() {
      return (SessionProfile) getAttribute(USER_PROFILE_ATTRIBUTE);
  }
  
  public static void setProfile(SessionProfile profile) {
      setAttribute(USER_PROFILE_ATTRIBUTE, profile);
  }
  
  public static void setPermissionRefreshNeeded() {
    setAttribute(PERMISSION_REFRESH_NEEDED, Boolean.TRUE);
  }

  public static void clearPermissionRefreshNeeded() {
    getSession().removeAttribute(PERMISSION_REFRESH_NEEDED);
  }

  public static boolean isPermissionRefreshNeeded() {
    return getSession().getAttribute(PERMISSION_REFRESH_NEEDED) == Boolean.TRUE;
  }
}
