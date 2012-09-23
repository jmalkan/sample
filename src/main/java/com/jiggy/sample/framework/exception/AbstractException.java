package com.jiggy.sample.framework.exception;

import java.util.HashMap;
import java.util.Map;


/**
 * Base class for Validation Exceptions.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public abstract class AbstractException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  private Map<String, String> errorMap;
  
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.exception.ValidationException.java and Performs Initialization.
   * 
   * @param error The error object.
   */
  public AbstractException(Error error) {
    this.errorMap = generateErrorMap(error);
  }

  /**
   * Generates a Map based on the given error object instance.
   * @param error The error object.
   * @return generates a map bases on the error object.
   */
  public static Map<String, String> generateErrorMap(Error error) {
    Map<String, String> errMap = new HashMap<String, String>();
    
    errMap.put("ERROR_CODE", error.getErrorCode());
    errMap.put("ERROR_DESC", error.getErrorDesc());
    errMap.put("UI_ELEMENT_NAME", error.getAttributeName());
    
    return errMap;
  }
  
  
  public Map<String, String> getErrorMap() {
    return errorMap;
  }
}