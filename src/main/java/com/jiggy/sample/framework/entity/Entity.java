package com.jiggy.sample.framework.entity;

import java.io.Serializable;

/**
 * Entity.java
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface Entity extends Serializable {
  /** The Entity's Id column name. */
  public static final String ID_COLUMN_NAME = "id";
  
  /**
   * Getter of the property <tt>id</tt> of the domain.
   * 
   * @return the id of the current entity.
   */
  public Long getId();
  
  /**
   * Getter of the property <tt>createDate</tt>
   * 
   * @return the createDate
   */
  public Long getCreateDate();
  
  /**
   * Setter of the property <tt>createDate</tt>
   * 
   * @param createDate the createDate to set
   */
  public void setCreateDate(Long createDate);
  
  /**
   * Getter of the property <tt>lastModifiedDate</tt>
   * 
   * @return the lastModifiedDate
   */
  public Long getLastModifiedDate();
  
  /**
   * Setter of the property <tt>lastModifiedDate</tt>
   * 
   * @param lastModifiedDate the lastModifiedDate to set
   */
  public void setLastModifiedDate(Long lastModifiedDate);
  
  /**
   * Getter of the property <tt>createdBy</tt>
   * 
   * @return
   */
  public Long getCreatedBy();
  
  /**
   * Setter of the property <tt>createdBy</tt>
   * 
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(Long createdBy);
  
  /**
   * Getter of the property <tt>lastModifiedBy</tt>
   * 
   * @return
   */
  public Long getLastModifiedBy();
  
  /**
   * Setter of the property <tt>lastModifiedBy</tt>
   * 
   * @param lastModifiedBy the lastModifiedBy to set
   */
  public void setLastModifiedBy(Long lastModifiedBy);
}