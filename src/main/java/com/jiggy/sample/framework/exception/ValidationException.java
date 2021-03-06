package com.jiggy.sample.framework.exception;


/**
 * Base class for Validation Exceptions.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class ValidationException extends AbstractException {
  private static final long serialVersionUID = 1L;

  public ValidationException(Error error) {
    super(error);
  }
}