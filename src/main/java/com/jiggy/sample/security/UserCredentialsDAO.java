package com.jiggy.sample.security;

import com.jiggy.sample.framework.dao.DBDAO;

/**
 * Data access interface for UserCredentials.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface UserCredentialsDAO extends DBDAO<UserCredentials> {
  //Define non-standard CRUD methods.
}
