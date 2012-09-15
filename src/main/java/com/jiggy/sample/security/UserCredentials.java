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
  private static final long serialVersionUID = 1L;
  
  private String password;
  private Boolean changePassword = Boolean.FALSE;
  
  private User user;

  
  /**
   * Creates a new instance of com.jiggy.sample.securit.UserCredentials.java and Performs Initialization
   */
  public UserCredentials() {
    super();
  }

  
  /**
   * Creates a new instance of com.jiggy.sample.securit.UserCredentials.java and Performs Initialization
   * 
   * @param password The password.
   * @param changePassword The changePassword indicator.
   * @param user The user object.
   */
  public UserCredentials(String password, Boolean changePassword, User user) {
    super();
    
    this.password = password;
    this.changePassword = changePassword;
    this.user = user;
  }

  public String getPassword() {
      return password;
  }
  
  public void setPassword(String password) {
      this.password = password;
  }
  
  public Boolean getChangePassword() {
      return this.changePassword;
  }
  
  public void setChangePassword(Boolean changePassword) {
      this.changePassword = changePassword;
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