package com.jiggy.sample.todo;

import com.jiggy.sample.framework.entity.AbstractEntity;

/**
 * An entity to represent Todo.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class Todo extends AbstractEntity {
  private static final long serialVersionUID = 1L;
  private String name;
  
  

  /**
   * Creates a new instance of com.jiggy.sample.todo.Todo.java and Performs Initialization.
   */
  public Todo() {
    super();
  }

  /**
   * Creates a new instance of com.jiggy.sample.todo.Todo.java and Performs Initialization.
   * 
   * @param id The task id.
   * @param name The task Name.
   */
  public Todo(Long id, String name) {
    super(id);

    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}