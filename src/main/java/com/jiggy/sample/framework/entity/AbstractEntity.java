package com.jiggy.sample.framework.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * AbstractEntity.java This is an abstract base class for the Entity class to extend from. Common functionality used by descendants is implemented
 * here.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public abstract class AbstractEntity implements Entity {
  private static final long serialVersionUID = 1L;
  
  private Long id;
  private Long createDate;
  private Long lastModifiedDate;
  private Long createdBy;
  private Long lastModifiedBy;
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.entity.AbstractEntity.java and Performs Initialization.
   */
  public AbstractEntity() {
    super();
  }
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.entity.AbstractEntity.java and Performs Initialization.
   * 
   * @param id The ID for this domain object.
   * 
   */
  public AbstractEntity(final Long id) {
    super();
    this.id = id;
  }
  
  @Override
  public Long getId() {
    return id;
  }
  
  /**
   * Setter of the property <tt>id</tt>
   * 
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Override
  public Long getCreateDate() {
    return createDate;
  }
  
  @Override
  public void setCreateDate(Long createDate) {
    this.createDate = createDate;
  }
  
  @Override
  public Long getLastModifiedDate() {
    return lastModifiedDate;
  }
  
  @Override
  public void setLastModifiedDate(Long lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
  
  @Override
  public Long getCreatedBy() {
    return createdBy;
  }
  
  @Override
  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }
  
  @Override
  public Long getLastModifiedBy() {
    return lastModifiedBy;
  }
  
  @Override
  public void setLastModifiedBy(Long lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
  
  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
  
  @Override
  public boolean equals(final Object entity) {
    if (this == entity) {
      return true;
    }
    
    if (entity instanceof AbstractEntity) {
      final Long id1 = ((AbstractEntity) entity).getId();
      final Long id2 = getId();
      
      return id1 == null && id2 == null || id1 != null && id1.equals(id2);
    }
    
    return false;
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}