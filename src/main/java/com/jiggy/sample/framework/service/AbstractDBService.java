package com.jiggy.sample.framework.service;

import com.jiggy.sample.framework.dao.DBDAO;
import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractDBService.java
 * 
 * <p>
 * Provides base implementation for the methods that could be extended by the descendant class. All Service/Facade class that interact with 1 DAO in a
 * standard way must extend from this class. It calls Before and After abstract/empty methods for validation during insert, update, and delete which
 * descendants needs to provide implementation. Only Business logic should be implemented here. Any entity specific database check requiring database
 * look up should be implemented in the DAO. Transaction AOP advice is provided here, So If any of these methods throws an Runtime exception, the
 * transaction will rolled back.
 * 
 * <p>
 * This object makes use of one DAO, decoupling it from the details of working with persistence APIs. Therefore, although this application uses
 * Hibernate for data access, a different persistence strategy like JDO could be incorporated without breaking this class.
 * 
 * <p>
 * The DAO is made available to the instance of this object using Dependency Injection. (The DAO is in turn configured using Dependency Injection.) We
 * use constructor Injection here to ensure object is created in a valid state with mandatory properties. dao is a read-only property for the
 * descendants to use.
 * 
 * <p>
 * This is a "singleton" class. This means a singleton per Spring Factory instance. The factory creates a single instance; there is no need for a
 * private constructor, static factory method etc as in the traditional implementation of the Singleton Design Pattern.
 * 
 * <p>
 * This is a POJO. It does not depend on any APIs. It is usable outside of Spring/Guice, and can be instantiated using new in a JUnit test. However,
 * we can still apply declarative transaction management to it using AOP.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 * @see com.jiggy.sample.framework.service.DBService
 */
public abstract class AbstractDBService<T extends Entity> implements DBService<T> {
  private final static Logger logger = LoggerFactory.getLogger(AbstractDBService.class);
  
  private DBDAO<T> dao;
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.service.AbstractDBService.java and Performs Initialization
   * 
   * @param dao The Data Access Object this service interacts with.
   */
  public AbstractDBService(DBDAO<T> dao) {
    super();
    this.dao = dao;
  }
  
  /**
   * Getter of the property <tt>dao</tt>
   * 
   * @return Returns the dao value.
   */
  protected DBDAO<T> getDao() {
    logger.debug("Obtained Data Access Object:{}", this.dao);
    return this.dao;
  }
  
  @Override
  public T findById(Long id) {
    this.validateBeforeFind(id);
    T foundEntity = this.implementFindById(id);
    
    return validateAfterFindById(foundEntity);
  }
  
  @Override
  public List<T> findAll() {
    List<T> foundEntities = this.implementFindAll();
    
    return validateAfterFind(foundEntities);
  }
  
  @Override
  public List<T> find(SearchCriteria searchCriteria) {
    List<T> foundEntities = this.implementFind(searchCriteria);
    return validateAfterFind(foundEntities);
  }
  
  @Override
  public final T findOne(final SearchCriteria searchCriteria) {
    return this.implementFindOne(searchCriteria);
  }
  
  @Override
  public T insert(T entity) {
    this.validateBeforeInsert(entity);
    this.beforeInsert(entity);
    T newEntity = this.implementInsert(entity);
    this.afterInsert(newEntity);
    this.validateAfterInsert(newEntity);
    
    return newEntity;
  }
  
  @Override
  public T update(T entity) {
    this.validateBeforeUpdate(entity);
    this.beforeUpdate(entity);
    T updatedEntity = this.implementUpdate(entity);
    this.afterUpdate(entity);
    this.validateAfterUpdate(entity);
    
    return updatedEntity;
  }
  
  @Override
  public void delete(T entity) {
    this.validateBeforeDelete(entity);
    this.beforeDelete(entity);
    this.implementDelete(entity);
    this.afterDelete(entity);
    this.validateAfterDelete(entity);
  }
  
  @Override
  public void delete(Long id) {
    this.delete(this.findById(id));
  }
  
  @Override
  public final List<? extends Entity> create(List<? extends Entity> entities) {
    this.validateBeforeCreate(entities);
    this.beforeCreate(entities);
    List<? extends Entity> newEntities = this.implementCreate(entities);
    this.afterCreate(newEntities, entities);
    this.validateAfterCreate(newEntities, entities);
    
    return newEntities;
  }
  
  @Override
  public final List<? extends Entity> modify(List<? extends Entity> entities) {
    this.validateBeforeModify(entities);
    this.beforeModify(entities);
    List<? extends Entity> modifiedEntities = this.implementModify(entities);
    this.afterModify(modifiedEntities, entities);
    this.validateAfterModify(modifiedEntities, entities);
    
    return modifiedEntities;
  }
  
  @Override
  public final void remove(List<? extends Entity> entities) {
    this.validateBeforeRemove(entities);
    this.beforeRemove(entities);
    this.implementRemove(entities);
    this.afterRemove(entities);
    this.validateAfterRemove(entities);
  }
  
  /**
   * Implements non-business/non-data validation logic, typically a security access check before entity is accessed.
   * 
   * @param id The id of the Domain/Entity that is about to be accessed.
   */
  protected void validateBeforeFind(Long id) {
    return;
  }
  
  /**
   * Implements logic to find an entity for the given id.
   * 
   * @param id The id of the entity being searched.
   * @return entity An instance of the Entity that is retrieved from the data store.
   */
  protected T implementFindById(final Long id) {
    return this.getDao().findById(id);
  }
  
  /**
   * Implements business (non-data) validation logic after finding an entity by id.
   * 
   * @param entity the entity returned by the mapper's findById or null if not found.
   */
  protected T validateAfterFindById(T entity) {
    return entity;
  }
  
  /**
   * Implements logic to find all the entities.
   * 
   * @return List of all entities retrieved from the data store.
   */
  protected List<T> implementFindAll() {
    return this.getDao().findAll();
  }
  
  /**
   * Implements logic to find all the entities that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input
   * @return List of entity objects that matches the search criteria
   * 
   * @see SearchCriteria
   */
  protected List<T> implementFind(final SearchCriteria searchCriteria) {
    return this.getDao().find(searchCriteria);
  }
  
  /**
   * Implements logic to find the entity that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input
   * @return List of entity objects that matches the search criteria
   * 
   * @see SearchCriteria
   */
  protected T implementFindOne(final SearchCriteria searchCriteria) {
    return this.getDao().findOne(searchCriteria);
  }
  
  /**
   * Implements business (non-data) validation logic after finding entities.
   * 
   * @param entities the list of entities returned from the find method
   */
  protected List<T> validateAfterFind(List<T> entities) {
    return entities;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is inserted in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be created in the data store.
   */
  protected abstract void validateBeforeInsert(T entity);
  
  /**
   * Implements non-business/non-data validation logic before entity is inserted in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be created in the data store.
   */
  protected void beforeInsert(T entity) {
    return;
  }
  
  /**
   * Implements logic to persist the entity and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object.
   * 
   * @return The Id of the newly created entity.
   */
  protected T implementInsert(final T entity) {
    return this.getDao().insert(entity);
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is inserted in the data store.
   * 
   * @param id The id of the Entity that is created in the data store.
   * @param entity An instance of the Domain/Entity that was sent from the client to be created in the data store.
   */
  protected void afterInsert(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is inserted in the data store.
   * 
   * @param id The id of the Entity that is created in the data store.
   * @param entity An instance of the Domain/Entity that was sent from the client to be created in the data store.
   */
  protected void validateAfterInsert(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is updated in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be updated in the data store.
   */
  protected abstract void validateBeforeUpdate(T entity);
  
  /**
   * Implements non-business/non-data validation logic before entity is updated in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be updated in the data store.
   */
  protected void beforeUpdate(T entity) {
    return;
  }
  
  /**
   * Implements logic to persists the modified entity and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object.
   * @return The modified entity.
   */
  protected T implementUpdate(final T entity) {
    return this.getDao().update(entity);
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is updated in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is updated in the data store.
   */
  protected void afterUpdate(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is updated in the data store.
   * 
   * @param entity An instance of the Domain/Entity that is updated in the data store.
   */
  protected void validateAfterUpdate(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is deleted from the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be deleted from the data store.
   */
  protected abstract void validateBeforeDelete(T entity);
  
  /**
   * Implements non-business/non-data validation logic before entity is deleted from the data store.
   * 
   * @param entity An instance of the Domain/Entity that is about to be deleted from the data store.
   */
  protected void beforeDelete(T entity) {
    return;
  }
  
  /**
   * Implements logic to delete an persisted entity and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object that needs to be deleted.
   */
  protected void implementDelete(final T entity) {
    this.getDao().delete(entity);
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is deleted from the data store.
   * 
   * @param entity An instance of the Domain/Entity that is deleted from the data store.
   */
  protected void afterDelete(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is deleted from the data store.
   * 
   * @param entity An instance of the Domain/Entity that is deleted from the data store.
   */
  protected void validateAfterDelete(T entity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is created in the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be created in the data store.
   */
  protected abstract void validateBeforeCreate(List<? extends Entity> entities);
  
  /**
   * Implements non-business/non-data validation logic before entity is created in the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be created in the data store.
   */
  protected void beforeCreate(List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements logic to persist the entities and its mapped associations to the underlying data store.
   * 
   * @param entities Instances of the entities object.
   * 
   * @return The list of the newly created entities.
   */
  protected List<? extends Entity> implementCreate(List<? extends Entity> entities) {
    return null;
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is created in the data store.
   * 
   * @param newEntities List of entities of the domain/entity objects that created in the data store.
   * @param entities List of entities of the domain/entity objects that are requested to be created in the data store.
   */
  protected void afterCreate(List<? extends Entity> newEntities, List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is created in the data store.
   * 
   * @param newEntities List of entities of the domain/entity objects that created in the data store.
   * @param entities List of entities of the domain/entity objects that are requested to be created in the data store.
   */
  protected void validateAfterCreate(List<? extends Entity> newEntities, List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is updated in the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be modified in the data store.
   */
  protected abstract void validateBeforeModify(List<? extends Entity> entities);
  
  /**
   * Implements non-business/non-data validation logic before entity is updated in the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be modified in the data store.
   */
  protected void beforeModify(List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements logic to persist the modified entities and its mapped associations to the underlying data store.
   * 
   * @param entities List of entities of the domain/entity objects that are requested to be modified in the data store.
   * 
   * @return The list of the modified entities.
   */
  protected List<? extends Entity> implementModify(List<? extends Entity> entities) {
    return null;
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is updated in the data store.
   * 
   * @param modifiedEntities List of entities of the domain/entity objects that are modified in the data store
   * @param entities List of entities of the domain/entity objects that are requested to be modified in the data store.
   */
  protected void afterModify(List<? extends Entity> modifiedEntities, List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is updated in the data store.
   * 
   * @param modifiedEntities List of entities of the domain/entity objects that are modified in the data store.
   * @param entities List of entities of the domain/entity objects that are modified in the data store.
   */
  protected void validateAfterModify(List<? extends Entity> modifiedEntities, List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic before entity is deleted from the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be removed from the data store.
   */
  protected abstract void validateBeforeRemove(List<? extends Entity> entities);
  
  /**
   * Implements non-business/non-data validation logic before entity is deleted from the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be removed from the data store.
   */
  protected void beforeRemove(List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements logic to remove persisted entities and its mapped associations to the underlying data store.
   * 
   * @param entities List of entities of the domain/entity objects that are about to be removed from the data store.
   */
  protected void implementRemove(List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements non-business/non-data validation logic after entity is deleted from the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are removed from the data store.
   */
  protected void afterRemove(List<? extends Entity> entities) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is deleted from the data store.
   * 
   * @param entities List of entities of the domain/entity objects that are removed from the data store.
   */
  protected void validateAfterRemove(List<? extends Entity> entities) {
    return;
  }
}