package com.jiggy.sample.framework.service;

import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

import java.util.List;

/**
 * <p>
 * Business layer facade base class for a standard Services interacting with single DAO.
 * </p>
 * 
 * Created on Sept 1, 2012
 * 
 * @param <T> An Object that implements Entity interface.
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface DBService<T extends Entity> extends Service {
  /**
   * Finds the entity for the given Id.
   * 
   * @param id The id for the entity to be searched for.
   * @return An instance of the entity object.
   */
  public abstract T findById(Long id);
  
  /**
   * Finds all the entity objects.
   * 
   * @return List of all the entity objects.
   */
  public abstract List<T> findAll();
  
  /**
   * Finds the entity for the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input.
   * @return List of entity objects that matches the search criteria.
   */
  public abstract List<T> find(SearchCriteria searchCriteria);
  
  /**
   * Convenient method when one result is expected from the Search. Finds the entities that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input.
   * @return An instance of the entity object.
   * 
   * @see SearchCriteria
   */
  public abstract T findOne(SearchCriteria searchCriteria);
  
  /**
   * Runs business logic and persists the entity object and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the domain/entity object.
   * 
   * @return The Id of the newly created entity.
   */
  public abstract T insert(T entity);
  
  /**
   * Runs business logic and persists the entity object and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the domain/entity object.
   * @return The modified entity.
   */
  public abstract T update(T entity);
  
  /**
   * Runs business logic and deletes the entity from the data store. Cascades if configured.
   * 
   * @param entity An instance of the domain/entity object that needs to be deleted
   */
  public abstract void delete(T entity);
  
  /**
   * Runs business logic and deletes the entity from the data store. Cascades if configured.
   * 
   * @param id The id of the domain/entity object that needs to be deleted.
   */
  public abstract void delete(Long id);
  
  /**
   * This operation can span across multiple DAO's or Services or combinations.
   * 
   * Runs business logic and persists the entity object and its mapped associations to the underlying data store.
   * 
   * @param entities List of entities of the domain/entity object.
   * 
   * @return List of newly created entities.
   */
  public abstract List<? extends Entity> create(List<? extends Entity> entities);
  
  /**
   * This operation can span across multiple DAO's or Services or combinations.
   * 
   * Runs business logic and persists the entity object and its mapped associations to the underlying data store.
   * 
   * @param entities List of entities of the domain/entity object.
   * @return List of modified entities.
   */
  public abstract List<? extends Entity> modify(List<? extends Entity> entities);
  
  /**
   * This operation can span across multiple DAO's or Services or combinations.
   * 
   * Runs business logic and deletes the entity from the data store. Cascades if configured.
   * 
   * @param entities List of entities of the domain/entity object.
   */
  public abstract void remove(List<? extends Entity> entities);
}