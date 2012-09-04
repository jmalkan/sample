package com.jiggy.sample.framework.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for Validation Exceptions.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class ValidationException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private static final Logger LOG = LoggerFactory.getLogger(ValidationException.class);
  
  private Map<String, String> errorMap;
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.exception.ValidationException.java and Performs Initialization.
   * 
   * @param errorCode The error code.
   * @param errorMessage The error message.
   */
  public ValidationException(String errorCode, String errorMessage) {
    this(generateErrorMap(errorCode, errorMessage));
  }
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.exception.ValidationException.java and Performs Initialization.
   * 
   * @param UIElementName -- UI/form/modal element name
   * @param errorCode The error code.
   * @param errorMessage The error message.
   */
  public ValidationException(String UIElementName, String errorCode, String errorMessage) {
    this(generateErrorMap(UIElementName, errorCode, errorMessage));
  }
  
  /**
   * Creates a new instance of com.jiggy.sample.framework.exception.ValidationException.java and Performs Initialization.
   * 
   * @param errorMap The Map of errorCode and errorMessage.
   */
  public ValidationException(Map<String, String> errorMap) {
    super();
    this.errorMap = errorMap;
  }
  
  /**
   * @param errorCode The error code.
   * @param errorMessage The error message.
   * 
   * @return
   */
  private static Map<String, String> generateErrorMap(String errorCode, String errorMessage) {
    Map<String, String> errMap = new HashMap<String, String>();
    
    errMap.put(errorCode, errorMessage);
    return errMap;
  }
  
  /**
   * @param errorCode The error code.
   * @param errorMessage The error message.
   * 
   * @return
   */
  private static Map<String, String> generateErrorMap(String UIElementName, String errorCode, String errorMessage) {
    final Map<String, String> errMap = generateErrorMap(errorCode, errorMessage);
    errMap.put("name", UIElementName);
    return errMap;
  }
  
  @Override
  public String getMessage() {
    return toJSON().toString();
  }
  
  /**
   * Converts errorMap into JSONObject.
   * 
   * @return JSONObject with error.
   */
  public JSONArray toJSON() {
    JSONArray errorJSONArray = new JSONArray();
    
    try {
      if (this.errorMap != null && !this.errorMap.isEmpty()) {
        Set<Entry<String, String>> entrySet = this.errorMap.entrySet();
        
        for (Entry<String, String> entry : entrySet) {
          JSONObject errorJSONObject = new JSONObject();
          
          String key = entry.getKey();
          
          if ("name".equals(key)) errorJSONObject.putOpt("name", entry.getValue());
          
          errorJSONObject.putOpt("ERROR_CODE", key);
          errorJSONObject.putOpt("ERROR_DESC", entry.getValue());
          
          errorJSONArray.put(errorJSONObject);
        }
      }
    } catch (JSONException ex) {
      LOG.error("Error serializing ValidationException into JSON", ex);
    }
    
    return errorJSONArray;
  }
}