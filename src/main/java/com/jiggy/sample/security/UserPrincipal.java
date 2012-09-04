package com.jiggy.sample.security;

import java.io.Serializable;

/**
 * The NextBook User Principal object used for Authentication.
 *
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class UserPrincipal implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  
  
  /**
   * Creates a new instance of com.jiggy.sample.security.UserPrincipal.java and Performs Initialization
   */
  public UserPrincipal(Long id) {
    super();
    this.id = id;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }
}
