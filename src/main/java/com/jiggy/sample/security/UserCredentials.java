package com.jiggy.sample.security;

import com.jiggy.sample.framework.entity.AbstractEntity;

/**
 * An entity to represent User Credentials.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class UserCredentials extends AbstractEntity {
  private static final long serialVersionUID = -4223583692168687276L;
  
  public static final String FORCE_PASSWORD_CHANGE_SESSION_ATTRIBUTE = "UserCredentials.mustChangePasswordOnLogin";
  
  private String username;
  private String password;
  private Boolean mustChangePasswordOnLogin = Boolean.FALSE;
  
  private User user;
  
  
  public String getUsername() {
      return username;
  }
  
  public void setUsername(String username) {
      this.username = username;
  }
  
  public String getPassword() {
      return password;
  }
  
  public void setPassword(String password) {
      this.password = password;
  }
  
  public Boolean getMustChangePasswordOnLogin() {
      return mustChangePasswordOnLogin;
  }
  
  public void setMustChangePasswordOnLogin(Boolean mustChangePasswordOnLogin) {
      this.mustChangePasswordOnLogin = mustChangePasswordOnLogin;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
}