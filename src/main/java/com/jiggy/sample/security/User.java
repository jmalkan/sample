package com.jiggy.sample.security;

import com.jiggy.sample.framework.entity.AbstractEntity;

/**
 * An entity to represent User.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class User extends AbstractEntity {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  
  private Role role;
  
  
  /**
   * Creates a new instance of com.jiggy.sample.security.User.java and Performs Initialization
   * 
   * @param firstName The First Name.
   * @param lastName The Last Name.
   * @param userName The User Name.
   * @param email The Email address.
   * @param role The Users Role.
   */
  public User(String firstName, String lastName, String userName, String email, Role role) {
    super();
    
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.role = role;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}