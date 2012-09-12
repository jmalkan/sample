package com.jiggy.sample.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("userCredentialsService")
public class UserCredentialsServiceImpl extends AbstractDBService<UserCredentials> implements UserCredentialsService {
  /**
   * Creates a new instance of com.jiggy.sample.security.UserCredentialsServiceImpl.java and Performs Initialization
   *
   * @param userCredentialsDAO The UserCredentialsDAO Data Access Object this service interacts with.
   */
  @Autowired
  public UserCredentialsServiceImpl(UserCredentialsDAO userCredentialsDAO) {
    super(userCredentialsDAO);
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