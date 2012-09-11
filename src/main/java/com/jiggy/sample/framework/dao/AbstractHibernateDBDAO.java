package com.jiggy.sample.framework.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.searchengine.FilterExpression;
import com.jiggy.sample.framework.searchengine.FilterExpression.FilterAdvice;
import com.jiggy.sample.framework.searchengine.FilterExpression.FilterTerm;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

/**
 * <p>
 * Data access layer base class using extends HibernateDaoSupport. Implements DAO interface and provides base implementation for the methods that could be extended by the descendant
 * class. DAO class should extend from this class. It calls Before and After abstract/empty methods for validation during insert, update, and delete
 * which descendants needs to provide implementation. Any entity specific database check like required, field length should be implemented here.
 * Business logic should be implemented in the service layer. If any of these methods throws an Runtime exception, the transaction will rolled back.
 * </p>
 * 
 * <p>
 * This is a "singleton" class. This means a singleton per Guice instance. The factory creates a single instance; there is no need for a private
 * constructor, static factory method etc as in the traditional implementation of the Singleton Design Pattern.
 * </p>
 * 
 * Created on Sept 1, 2012
 * 
 * @param <T> An Object that implements Entity interface.
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Repository
public abstract class AbstractHibernateDBDAO<T extends Entity> implements DBDAO<T>, FilterAdvice {
  private final static Long NULL_ID = -1l;
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public final T findById(final Long id) {
    if (id == null) {
      return null;
    }
    
    T entity = this.implementFindById(id);
    
    this.afterFind(entity);
    
    return entity;
  }
  
  @Override
  public final List<T> findAll() {
    final List<T> entities = this.implementFindAll();
    
    if (entities != null) {
      for (final T entity : entities) {
        this.afterFind(entity);
      }
    }
    
    return entities;
  }
  
  @Override
  public final List<T> find(final SearchCriteria searchCriteria) {
    final List<T> entities = this.implementFind(searchCriteria);
    
    if (entities != null) {
      for (final T entity : entities) {
        this.afterFind(entity);
      }
    }
    
    return entities;
  }
  
  @Override
  public int count() {
    // Query rowCountQuery = this.getPersistenceManager().newQuery(this.getPersistenceManager().getExtent(this.getEntity(), false), "true");
    // rowCountQuery.setResult("count(this)");
    // Long rowCountResult = (Long) rowCountQuery.execute();
    //
    // if (rowCountResult != null) {
    // return rowCountResult.intValue();
    // }
    
    return -1;
  }
  
  @Override
  public int count(final SearchCriteria searchCriteria) {
    // Query rowCountQuery = this.getPersistenceManager().newQuery(this.getPersistenceManager().getExtent(this.getEntity(), false), "true");
    // rowCountQuery.setResult("count(this)");
    // Long rowCountResult = (Long) rowCountQuery.execute();
    //
    // if (rowCountResult != null) {
    // return rowCountResult.intValue();
    // }
    
    return -1;
  }
  
  @Override
  public final T findOne(final SearchCriteria searchCriteria) {
    return this.implementFindOne(searchCriteria);
  }
  
  @Override
  public final T insert(final T entity) {
    this.validateBeforeInsert(entity);
    this.beforeInsert(entity);
    T newEntity = this.implementInsert(entity);
    this.afterInsert(newEntity);
    this.validateAfterInsert(newEntity);
    
    return newEntity;
  }
  
  @Override
  public final T update(final T entity) {
    this.validateBeforeUpdate(entity);
    this.beforeUpdate(entity);
    T updatedEntity = this.implementUpdate(entity);
    this.afterUpdate(entity);
    this.validateAfterUpdate(entity);
    
    return updatedEntity;
  }
  
  @Override
  public final void delete(final T entity) {
    this.validateBeforeDelete(entity);
    this.beforeDelete(entity);
    this.implementDelete(entity);
    this.afterDelete(entity);
    this.validateAfterDelete(entity);
  }
  
  /**
   * Returns the Entity objects class that this dao is working with used by finder methods.
   * 
   * @return The Entity Class.
   */
  protected abstract Class<T> getEntity();
  
  /**
   * Implements non-data/non-business validation logic after entity is retrieved from the data store.
   * 
   * @param entity An instance of the Entity that is retrieved from the data store.
   */
  protected void afterFind(final T entity) {
    // Descendants to implement
  }
  
  /**
   * Implements logic to find an entity for the given id.
   * 
   * @param id The id of the entity being searched.
   * @return entity An instance of the Entity that is retrieved from the data store.
   */
  protected T implementFindById(final Long id) {
    return (T) this.getCurrentSession().get(this.getEntity(), id);
  }
  
  /**
   * Implements logic to find all the entities.
   * 
   * @return List of all entities retrieved from the data store.
   */
  protected List<T> implementFindAll() {
    return this.find(null);
  }
  
  /**
   * Implements logic to find all the entities that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input
   * @return List of entity objects that matches the search criteria
   * 
   * @see SearchCriteria
   */
  protected List<T> implementFind(SearchCriteria searchCriteria) {
    List<T> result = null; //this.getCurrentSession().loadAll(this.getEntity());
    // Map<Object, Object> paramMap = null;
    // Query query = this.getPersistenceManager().newQuery(this.getEntity());
    //
    // if (searchCriteria == null) {
    // searchCriteria = new DefaultSearchCriteria();
    // } else {
    // if (StringUtils.isNotBlank(searchCriteria.getQueryVariables())) {
    // query.declareVariables(searchCriteria.getQueryVariables());
    // }
    // }
    // this.applySecurityFilter(searchCriteria);
    //
    // if (searchCriteria != null) {
    // String filter = null;
    // Map<String, Map<Object, Object>> filterMap = buildFilter(searchCriteria);
    //
    // if (filterMap != null && !filterMap.isEmpty()) {
    // Iterator<String> keys = filterMap.keySet().iterator();
    // filter = keys.next();
    // paramMap = filterMap.get(filter);
    // }
    //
    // if (searchCriteria.isPaginationEnabled()) {
    // logger.debug("Pagination is enabled, calculate range.");
    // int rowCount = -1;
    // Long rowCountResult;
    // logger.debug("Build Row Count query.");
    // Query rowCountQuery = this.getPersistenceManager().newQuery(this.getPersistenceManager().getExtent(this.getEntity(), false), "true");
    // if (StringUtils.isNotBlank(searchCriteria.getQueryVariables())) {
    // rowCountQuery.declareVariables(searchCriteria.getQueryVariables());
    // }
    //
    // rowCountQuery.setResult("count(this)");
    //
    // logger.debug("Adding filters to Row Count query.");
    // if (filter != null) {
    // rowCountQuery.setFilter(filter);
    // }
    //
    // logger.debug("Adding soring to the Main Search query.");
    // if (!StringUtils.isBlank(searchCriteria.getSortBy())) {
    // rowCountQuery.setOrdering(searchCriteria.getSortBy());
    // }
    //
    // logger.debug("Executing the Row Count Query={}  with Param={}", rowCountQuery.toString(), paramMap);
    // rowCountResult = (Long) rowCountQuery.executeWithMap(paramMap);
    //
    // if (rowCountResult != null) {
    // rowCount = rowCountResult.intValue();
    // }
    //
    // if (searchCriteria.getOffset() > -1 && searchCriteria.getLimit() > 0 && rowCount > 0) {
    // searchCriteria.setRowCount(rowCount);
    //
    // logger.debug("Calculate the Start Row Number.");
    // long lowerBound = searchCriteria.getOffset() < rowCount ? searchCriteria.getOffset() : rowCount - searchCriteria.getLimit();
    //
    // logger.debug("Calculate the End Row Number.");
    // long upperBound = lowerBound + searchCriteria.getLimit() <= rowCount ? lowerBound + searchCriteria.getLimit() : rowCount;
    // logger.debug("Adding range to the Main Search query.");
    // if (lowerBound != -1 && upperBound != -1 && lowerBound != upperBound) {
    // query.setRange(lowerBound, upperBound);
    // }
    // }
    // }
    //
    // logger.debug("Adding filters to the Main Search query.");
    // if (filter != null) {
    // query.setFilter(filter);
    // }
    //
    // logger.debug("Adding soring to the Main Search query.");
    // if (!StringUtils.isBlank(searchCriteria.getSortBy())) {
    // query.setOrdering(searchCriteria.getSortBy());
    // }
    // }
    //
    // logger.debug("Executing the Main Search Query={}  with Param={}", query.toString(), paramMap);
    // result = (List<T>) query.executeWithMap(paramMap);
    //
    // if (searchCriteria.getRowCount() < 0 && result != null) {
    // searchCriteria.setRowCount(result.size());
    // }
    
    return result;
  }
  
  /**
   * @param searchCriteria
   */
  protected void applySecurityFilter(SearchCriteria searchCriteria) {
    return;
  }
  
  /**
   * Implements logic to find the entity that matches the given search criteria.
   * 
   * @param searchCriteria The SearchCriteria object with user input
   * @return The entity objects that matches the search criteria
   * 
   * @see SearchCriteria
   */
  protected T implementFindOne(final SearchCriteria searchCriteria) {
    T entity = null;
    final List<T> entities = this.find(searchCriteria);
    
    if (entities != null && entities.size() == 1) {
      entity = entities.get(0);
    }
    
    return entity;
  }
  
  /**
   * Maps the input search criteria to a JDO query object
   * 
   * @param searchCriteria An instance of the Search Criteria object.
   * @param Map of 1 item where key is the query and the value is a parameters for the query.
   */
  protected Map<String, Map<Object, Object>> buildFilter(final SearchCriteria searchCriteria) {
    FilterExpression queryFilter = searchCriteria.getFilter();
    Map<String, Map<Object, Object>> filterMap = null;
    String filter = null;
    
    if (queryFilter != null) {
      filter = queryFilter.toQueryString(this);
      if (filter.length() > 0) {
        Map<Object, Object> queryParams = queryFilter.getQueryParams(this);
        filterMap = new HashMap<String, Map<Object, Object>>();
        filterMap.put(filter, queryParams);
      }
    }
    return filterMap;
  }
  
  @Override
  public String getQueryString(FilterTerm term) {
    return term.toQueryString();
  }
  
  @Override
  public List<Object> getParamValues(FilterTerm term) {
    
    String key = term.getKey();
    String value = term.getValue();
    
    List<Object> objectValues = new ArrayList<Object>();
    if (value == null) {
      objectValues.add(value);
    } else {
      Set<String> longFields = new HashSet<String>(Arrays.asList("ID", "CREATEDATE", "CREATEDBY", "LASTMODIFIEDDATE", "LASTMODIFIEDBY"));
      String[] values = value.split(",");
      
      for (String splitValue : values) {
        if (longFields.contains(key.toUpperCase())) {
          if (StringUtils.isNotBlank(splitValue))
            objectValues.add(Long.valueOf(splitValue.trim()));
          else
            objectValues.add(NULL_ID);
        } else {
          objectValues.add(splitValue);
        }
      }
    }
    return objectValues;
  }
  
  /**
   * Implements data (non-business) validation logic before entity is inserted in the data store.
   * 
   * @param entity An instance of the Entity that is about to be created in the data store.
   */
  protected void validateBeforeInsert(final T entity) {
    return;
  }
  
  /**
   * Implements non-data/non-business validation logic before entity is inserted in the data store.
   * 
   * @param entity An instance of the Entity that is about to be created in the data store.
   */
  protected void beforeInsert(final T entity) {
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
    return (T) this.getCurrentSession().save(entity);
  }
  
  /**
   * Implements non-data/non-business validation logic after entity is inserted in the data store.
   * 
   * @param newEntity The reference to the new Entity that is created in the data store.
   */
  protected void afterInsert(final T newEntity) {
    return;
  }
  
  /**
   * Implements business (non-data) validation logic after entity is inserted in the data store.
   * 
   * @param newEntity The reference to the new Entity that is created in the data store.
   */
  protected void validateAfterInsert(final T newEntity) {
    return;
  }
  
  /**
   * Implements data (non-business) validation logic before entity is updated in the data store.
   * 
   * @param entity An instance of the Entity that is about to be updated in the data store.
   */
  protected void validateBeforeUpdate(final T entity) {
    return;
  }
  
  /**
   * Implements non-data/non-business validation logic before entity is updated in the data store.
   * 
   * @param entity An instance of the Entity that is about to be updated in the data store.
   */
  protected void beforeUpdate(final T entity) {
    return;
  }
  
  /**
   * Implements logic to persist the modified entity and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object.
   * @return The modified entity.
   */
  protected T implementUpdate(final T entity) {
	this.getCurrentSession().update(entity);
    return entity;
  }
  
  /**
   * Implements non-data/non-business validation logic after entity is updated in the data store.
   * 
   * @param entity An instance of the Entity that is updated in the data store.
   */
  protected void afterUpdate(final T entity) {
    return;
  }
  
  /**
   * Implements data (non-business) validation logic after entity is updated in the data store.
   * 
   * @param entity An instance of the Entity that is updated in the data store.
   */
  protected void validateAfterUpdate(final T entity) {
    return;
  }
  
  /**
   * Implements data (non-business) validation logic after entity is updated in the data store.
   * 
   * @param entity An instance of the Entity that is updated in the data store.
   */
  protected void validateBeforeDelete(final T entity) {
    return;
  }
  
  /**
   * Implements non-data/non-business validation logic before entity is deleted from the data store.
   * 
   * @param entity An instance of the Entity that is about to be deleted from the data store.
   */
  protected void beforeDelete(final T entity) {
    return;
  }
  
  /**
   * Implements logic to delete an persisted entity and its mapped associations to the underlying data store.
   * 
   * @param entity An instance of the entity object that needs to be deleted.
   */
  protected void implementDelete(final T entity) {
	this.getCurrentSession().delete(entity);
  }
  
  /**
   * Implements non-data/non-business validation logic after entity is deleted from the data store.
   * 
   * @param entity An instance of the Entity that is deleted from the data store.
   */
  protected void afterDelete(final T entity) {
    return;
  }
  
  /**
   * Implements data (non-business) validation logic after entity is deleted from the data store.
   * 
   * @param entity An instance of the Entity that is deleted from the data store.
   */
  protected void validateAfterDelete(final T entity) {
    return;
  }
  
  /**
   * @return The current session from Hibernate's SessionFactory
   */
  protected final Session getCurrentSession() {
	return this.sessionFactory.getCurrentSession();
  }
}