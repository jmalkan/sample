package com.jiggy.sample.security;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jiggy.sample.framework.dao.DBDAO;
import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.service.AbstractDBService;

/**
 * A concrete implementation of the UserCredentialsService.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Service
public class UserCredentialsServiceImpl extends AbstractDBService<UserCredentials> implements UserCredentialsService {
  /**
   * Creates a new instance of com.jiggy.sample.todo.TodoServiceImpl.java and Performs Initialization
   *
   * @param todoDAO The Todo Data Access Object this service interacts with.
   */
  public UserCredentialsServiceImpl(DBDAO<UserCredentials> dao) {
    super(dao);
  }

  @Override
  protected void validateBeforeInsert(UserCredentials entity) {
    return;	
  }

  @Override
  protected void validateBeforeUpdate(UserCredentials entity) {
    return;	
  }

  @Override
  protected void validateBeforeDelete(UserCredentials entity) {
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