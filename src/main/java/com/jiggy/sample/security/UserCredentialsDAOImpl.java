package com.jiggy.sample.security;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiggy.sample.framework.dao.AbstractHibernateDBDAO;

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
  protected Class<UserCredentials> getEntity() {
    return UserCredentials.class;
  }
}