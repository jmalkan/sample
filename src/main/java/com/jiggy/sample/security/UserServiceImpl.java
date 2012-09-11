package com.jiggy.sample.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiggy.sample.framework.entity.Entity;
import com.jiggy.sample.framework.service.AbstractDBService;

/**
 * A concrete implementation of the UserServiceImpl.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Service
public class UserServiceImpl extends AbstractDBService<User> implements UserService {
  /**
   * Creates a new instance of com.jiggy.sample.security.UserServiceImpl.java and Performs Initialization
   *
   * @param userDAO The UserCredentialsDAO Data Access Object this service interacts with.
   */
  @Autowired
  public UserServiceImpl(UserDAO userDAO) {
    super(userDAO);
  }

  @Override
  protected void validateBeforeInsert(User entity) {
    return;	
  }

  @Override
  protected void validateBeforeUpdate(User entity) {
    return;	
  }

  @Override
  protected void validateBeforeDelete(User entity) {
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