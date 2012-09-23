package com.jiggy.sample.framework.exception;

/**
 * Security exception.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class SecurityException extends AbstractException {
  private static final long serialVersionUID = 1L;
  
  public SecurityException(Error error) {
    super(error);
  }
}