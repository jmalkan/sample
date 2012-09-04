package com.jiggy.sample.security;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * SessionProfile is simple POJO that maintains current user's state in the Shiro Session
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class SessionProfile implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String TOKEN_DELIMITER = "||";
  
  private Long id;
  
  // User related data
  private Long userId;
  private String userName;
  private String userSourceName;
  private String userSourceId;
  private String userFirstName;
  private String userLastName;
  private String userEmail;
  
  // Role object
  private Role role;
  
  public Role getRole() {
    return this.role;
  }
  
  public void setRole(Role role) {
    this.role = role;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getUserId() {
    return this.userId;
  }
  
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  public String getUserName() {
    return this.userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getUserSourceName() {
    return this.userSourceName;
  }
  
  public void setUserSourceName(String userSourceName) {
    this.userSourceName = userSourceName;
  }
  
  public String getUserSourceId() {
    return this.userSourceId;
  }
  
  public void setUserSourceId(String userSourceId) {
    this.userSourceId = userSourceId;
  }
  
  public String getUserFirstName() {
    return this.userFirstName;
  }
  
  public void setUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
  }
  
  public String getUserLastName() {
    return this.userLastName;
  }
  
  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }
  
  public String getUserEmail() {
    return this.userEmail;
  }
  
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  
  /**
   * Convenient method to return User's firstName & lastName like: "John Smith"
   * 
   * @return String - User FirstName & LastName
   */
  public String getUserFNameLName() {
    return String.format("%s %s", getUserFirstName(), getUserLastName());
  }
  
  /**
   * Convenient method to return User's latName & firstName like: "Smith John"
   * 
   * @return
   */
  public String getUserLNameFName() {
    return String.format("%s %s", getUserLastName(), getUserFirstName());
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.userEmail == null) ? 0 : this.userEmail.hashCode());
    result = prime * result + ((this.userFirstName == null) ? 0 : this.userFirstName.hashCode());
    result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
    result = prime * result + ((this.userLastName == null) ? 0 : this.userLastName.hashCode());
    result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
    result = prime * result + ((this.userSourceId == null) ? 0 : this.userSourceId.hashCode());
    result = prime * result + ((this.userSourceName == null) ? 0 : this.userSourceName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    SessionProfile other = (SessionProfile) obj;
    if (this.id == null) {
      if (other.id != null) return false;
    } else if (!this.id.equals(other.id)) return false;
    if (this.userEmail == null) {
      if (other.userEmail != null) return false;
    } else if (!this.userEmail.equals(other.userEmail)) return false;
    if (this.userFirstName == null) {
      if (other.userFirstName != null) return false;
    } else if (!this.userFirstName.equals(other.userFirstName)) return false;
    if (this.userId == null) {
      if (other.userId != null) return false;
    } else if (!this.userId.equals(other.userId)) return false;
    if (this.userLastName == null) {
      if (other.userLastName != null) return false;
    } else if (!this.userLastName.equals(other.userLastName)) return false;
    if (this.userName == null) {
      if (other.userName != null) return false;
    } else if (!this.userName.equals(other.userName)) return false;
    if (this.userSourceId == null) {
      if (other.userSourceId != null) return false;
    } else if (!this.userSourceId.equals(other.userSourceId)) return false;
    if (this.userSourceName == null) {
      if (other.userSourceName != null) return false;
    } else if (!this.userSourceName.equals(other.userSourceName)) return false;
    return true;
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}