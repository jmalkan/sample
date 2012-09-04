package com.jiggy.sample.framework.interceptors.audit;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Intercepts any method that extends AbstractResource and logs audit entry. This class does NOT handle exceptions thrown by Resource methods. The
 * ResourceExceptionInterceptor is meant for that purpose.
 * 
 * Created on Sept 1, 2012
 * 
 * @version $Revision$
 */
public class AuditInterceptor implements MethodInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(AuditInterceptor.class);
  
  // If a resource method call exceeds this limit, a log entry at ERROR level is
  // logged. Set to 2 secs for now.
  private static short PERF_THRESHOLD_MILLIS = 2000;
  
  @Override
  public Object invoke(MethodInvocation mthodInvocation) throws Throwable {
    String args = null;
    String className = null;
    String methodName = null;
    double elapsed = 0;
    Object returnObject = null;
    
    // NOTE: Do NOT move the position of the following line of code
    long start = System.nanoTime();
    try {
      returnObject = mthodInvocation.proceed();
    } finally {
      // NOTE: Do NOT move the position of the following line of code
      elapsed = ((System.nanoTime() - start) / 1000000.0);
      if (elapsed > PERF_THRESHOLD_MILLIS) {
        methodName = mthodInvocation.getMethod().getName();
        args = Arrays.toString(mthodInvocation.getArguments());
        try {
          className = mthodInvocation.getThis().getClass().getName();
        } catch (final Exception ignored) {
          // Smothered to prevent reentrancy [GS]
        }
        
        logger.error(
            "Method Invocation {} on Class {} with Parameters {} took {} ms, exceeding performance limits of {} ms -- please tune your code paths.",
            new Object[] {methodName, className == null ? "UNKNOWN" : className, args, elapsed, PERF_THRESHOLD_MILLIS});
      }
    }
    
    return returnObject;
  }
}