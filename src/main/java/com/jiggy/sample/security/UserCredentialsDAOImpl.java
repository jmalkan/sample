package com.jiggy.sample.security;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiggy.sample.framework.dao.AbstractHibernateDBDAO;
import com.jiggy.sample.framework.searchengine.FilterExpression.FilterTerm;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

/**
 * Data access implementation for UserCredentials.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Repository("userCredentialsDAO")
public class UserCredentialsDAOImpl extends AbstractHibernateDBDAO<UserCredentials> implements UserCredentialsDAO {
  /**
   * Creates a new instance of com.jiggy.sample.security.UserCredentialsDAOImpl.java and Performs Initialization
   * 
   * @param sessionFactory The Hibernate's sessionFactory Object this dao interacts with.
   */
  @Autowired
  public UserCredentialsDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  protected List<UserCredentials> implementFind(SearchCriteria searchCriteria) {
    String queryString = "from " + this.getPersistentClass().getSimpleName() + " where user.userName = :userName";
    
    Query query = this.getCurrentSession().createQuery(queryString);
    
    Collection<FilterTerm> filterTerms = searchCriteria.getFilter().terms();
    
    for (FilterTerm filterTerm : filterTerms) {
      query.setString(filterTerm.getKey(), filterTerm.getValue());
    }
    
    List<UserCredentials> result = query.list();
    
    return result;
  }
}