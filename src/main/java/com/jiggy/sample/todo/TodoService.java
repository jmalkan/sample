package com.jiggy.sample.todo;

import com.jiggy.sample.framework.service.DBService;

/**
 * The Business Logic Interface for accessing Todo.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface TodoService extends DBService<Todo> {
  //Define non-standard CRUD methods.
}