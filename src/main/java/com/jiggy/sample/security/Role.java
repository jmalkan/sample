package com.jiggy.sample.security;

import java.util.Set;

import com.jiggy.sample.framework.entity.AbstractEntity;

/**
 * An entity to represent Role.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class Role extends AbstractEntity {
  private static final long serialVersionUID = 1L;
  private String name;
  private String description;
  
  private Set<Permission> permissions;
  
  
  /**
   * Creates a new instance of com.jiggy.sample.security.Role.java and Performs Initialization
   * 
   * @param name The Role Name
   * @param permissions The permissions assigned to the role
   */
  public Role(String name, Set<Permission> permissions) {
    super();
    
    this.name = name;
    this.permissions = permissions;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }
}