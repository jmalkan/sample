package com.jiggy.sample.security;

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
@Repository
public class UserDAOImpl extends AbstractHibernateDBDAO<User> implements UserDAO {
  @Override
  protected Class<User> getEntity() {
    return User.class;
  }
}