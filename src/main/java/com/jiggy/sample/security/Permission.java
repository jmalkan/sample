package com.jiggy.sample.security;

import com.jiggy.sample.framework.entity.AbstractEntity;

/**
 * An entity to represent Permission.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class Permission extends AbstractEntity {
  private static final long serialVersionUID = 1L;
  private String resource;
  private String operation;

  
  /**
   * Creates a new instance of com.jiggy.sample.securit.Permission.java and Performs Initialization
   * 
   * @param resource The Resource Name.
   * @param operation The Operation Name.
   */
  public Permission(String resource, String operation) {
    super();
    
    this.resource = resource;
    this.operation = operation;
  }
  
  /**
   * Getter of the property <tt>resource</tt>
   * 
   * @return the resource
   */
  public String getResource() {
    return this.resource;
  }
  
  /**
   * Setter of the property <tt>resource</tt>
   * 
   * @param resource the resource to set
   */
  public void setResource(String resource) {
    this.resource = resource;
  }
  
  /**
   * Getter of the property <tt>operation</tt>
   * 
   * @return the operation
   */
  public String getOperation() {
    return this.operation;
  }
  
  /**
   * Setter of the property <tt>operation</tt>
   * 
   * @param operation the operation to set
   */
  public void setOperation(String operation) {
    this.operation = operation;
  }
  
  /**
   * Convenient method to provide the entire permission
   * 
   * @return The complete permission
   */
  public String getPermissionValue() {
    return this.getResource() + ":" + this.getOperation();
  }
}