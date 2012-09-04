package com.jiggy.sample.framework.exception;

/**
 * Security exception.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class SecurityException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  private int errorCode;
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.exception.SecurityException.java and Performs Initialization
   * 
   * @param errorCode The Error Code.
   * @param errorMsg The Error Message.
   * @param throwable An instance of the Throwable for root cause.
   */
  public SecurityException(int errorCode, String errorMsg, Throwable throwable) {
    super(errorMsg, throwable);
    this.errorCode = errorCode;
  }
  
  /**
   * Getter of the property <tt>errorCode</tt>
   * 
   * @return the errorCode
   */
  public int getErrorCode() {
    return this.errorCode;
  }
}