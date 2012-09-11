package com.jiggy.sample.security;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * UserProfile is simple POJO that maintains current user's state in the Shiro Session.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class UserProfile implements Serializable {
  private static final long serialVersionUID = 1L;
  public User user;
  
  
  /**
   * Creates a new instance of com.jiggy.sample.security.UserProfile.java and Performs Initialization
   * 
   * @param user The Users object containing Role/Permission.
   */
  public UserProfile(User user) {
	super();
	this.user = user;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}