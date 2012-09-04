package com.jiggy.sample.framework.web;

import com.jiggy.sample.framework.entity.Entity;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.sun.jersey.api.representation.Form;

/**
 * This is the abstract base class for all the transformation classes used by Resources. Provides base interface and partial implementation for
 * transforming 1. Jersey Form into Entity that could be consumed by services. 2. Entity into JSON object to be returned to client.
 * 
 * Created on Sept 1, 2012
 * 
 * @param <T> The core Entity object instance this class transforms.
 * 
 * @version $Revision$
 */
public abstract class AbstractTransformer<T extends Entity> implements Transformer<T> {
  @Override
  @SuppressWarnings("unchecked")
  public JSONArray entitiesToJSONArray(List<? extends Entity> entities) throws JSONException {
    JSONArray jsonArray = new JSONArray();
    
    for (Entity entity : entities) {
      jsonArray.put(entityToJSON((T) entity));
    }
    
    return jsonArray;
  }
  
  @Override
  public Object formToEntityId(Form form) {
    if (form != null && form.getFirst(getEntityIdColumnName()) != null) {
      return form.getFirst(getEntityIdColumnName(), Long.class);
    }
    
    return null;
  }
  
  protected String getEntityIdColumnName() {
    return Entity.ID_COLUMN_NAME;
  }
  
  protected boolean isIdPresent(Form form) {
    return null != this.formToEntityId(form);
  }
}