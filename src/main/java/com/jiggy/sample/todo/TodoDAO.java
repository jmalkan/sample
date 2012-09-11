package com.jiggy.sample.todo;

import com.jiggy.sample.framework.dao.DBDAO;

/**
 * Data access interface for Todo.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface TodoDAO extends DBDAO<Todo> {
  //Define non-standard CRUD methods.
}