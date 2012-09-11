package com.jiggy.sample.security;

import com.jiggy.sample.framework.dao.DBDAO;

/**
 * Data access interface for User.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface UserDAO extends DBDAO<User> {
  //Define non-standard CRUD methods.
}