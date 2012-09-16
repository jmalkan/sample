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
@Repository("userDAO")
public class UserDAOImpl extends AbstractHibernateDBDAO<User> implements UserDAO {
  /**
   * Creates a new instance of com.jiggy.sample.security.UserDAOImpl.java and Performs Initialization
   * 
   * @param sessionFactory The Hibernate's sessionFactory Object this dao interacts with.
   */
  @Autowired
  public UserDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}