package com.jiggy.sample.todo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Repository("todoDAO")
public class TodoDAOImpl extends AbstractHibernateDBDAO<Todo> implements TodoDAO {
  /**
   * Creates a new instance of com.jiggy.sample.todo.TodoDAOImpl.java and Performs Initialization
   * 
   * @param sessionFactory The Hibernate's sessionFactory Object this dao interacts with.
   */
  @Autowired
  public TodoDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
  
  @Override
  protected Class<Todo> getEntity() {
    return Todo.class;
  }
}