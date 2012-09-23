package com.jiggy.sample.framework.exception;

/**
 * Base class for System Exceptions.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class SystemException extends AbstractException {
  private static final long serialVersionUID = 1L;

  public SystemException(Error error) {
    super(error);
  }
}