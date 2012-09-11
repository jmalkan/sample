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
public class UserCredentialsDAOImpl extends AbstractHibernateDBDAO<UserCredentials> implements UserCredentialsDAO {
  @Override
  protected Class<UserCredentials> getEntity() {
    return UserCredentials.class;
  }
}