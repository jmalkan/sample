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
  private String username;
  private String password;
  private String email;
  
  /**
   * Creates a new instance of com.jiggy.sample.User.java and Performs
   * Initialization
   */
  public User() {
      super();
  }
  
  /**
   * Creates a new instance of com.jiggy.sample.User.java and Performs
   * Initialization
   * 
   * @param firstName The First Name.
   * @param lname The Last Name.
   */
  public User(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
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
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
}