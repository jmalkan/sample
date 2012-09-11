package com.jiggy.sample.todo;

import org.springframework.stereotype.Repository;

import com.jiggy.sample.framework.dao.AbstractHibernateDBDAO;

/**
 * Data access implementation for Todo.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Repository
public class TodoDAOImpl extends AbstractHibernateDBDAO<Todo> implements TodoDAO {
  @Override
  protected Class<Todo> getEntity() {
    return Todo.class;
  }
}