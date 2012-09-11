package com.jiggy.sample.framework.dao;

import java.util.List;

import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

/**
 * DBDAO.java defines basic data access CRUD operations. All the DAO/Data access classes will implement this interface.
 * 
 * Created on Sept 1, 2012
 * 
 * @param <T> An Object that implements Entity interface.
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface DBDAO<T extends Entity> extends DAO {
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
   * Finds all the entities that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input.
   * @return List of entity objects that matches the search criteria.
   * 
   * @see SearchCriteria
   */
  public abstract List<T> find(SearchCriteria searchCriteria);
  
  /**
   * Returns the count of such entities.
   * 
   * @return The row count
   */
  public abstract int count();
  
  /**
   * Returns the count of such entities.
   * 
   * @param searchCriteria
   * @return The row count
   */
  public abstract int count(SearchCriteria searchCriteria);
  
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
   * @param entity An instance of the entity object.
   * 
   * @return The Id of the newly created entity.
   */
  public abstract T insert(T entity);
  
  /**
   * Runs business logic and persists the entity object and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object.
   * @return The modified entity.
   */
  public abstract T update(T entity);
  
  /**
   * Runs business logic and deletes the entity from the data store. Cascades if configured.
   * 
   * @param entity An instance of the entity object that needs to be deleted.
   */
  public abstract void delete(T entity);
}