package com.jiggy.sample.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.service.AbstractDBService;

/**
 * A concrete implementation of the TodoService.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Service("todoService")
public class TodoServiceImpl extends AbstractDBService<Todo> implements TodoService {
  /**
   * Creates a new instance of com.jiggy.sample.todo.TodoServiceImpl.java and Performs Initialization.
   * 
   * @param todoDAO The Todo Data Access Object this service interacts with.
   */
  @Autowired
  public TodoServiceImpl(TodoDAO todoDAO) {
    super(todoDAO);
  }

  @Override
  protected void validateBeforeInsert(Todo entity) {
    return;
  }

  @Override
  protected void validateBeforeUpdate(Todo entity) {
    return;
  }

  @Override
  protected void validateBeforeDelete(Todo entity) {
    return;
  }

  @Override
  protected void validateBeforeCreate(List<? extends Entity> entities) {
    return;
  }

  @Override
  protected void validateBeforeModify(List<? extends Entity> entities) {
    return;
  }

  @Override
  protected void validateBeforeRemove(List<? extends Entity> entities) {
    return;
  }
}