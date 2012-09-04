package com.jiggy.sample.framework.searchengine;

import com.jiggy.sample.framework.searchengine.FilterExpression.FilterTerm;

import java.io.Serializable;
import java.util.Map;

/**
 * SearchCriteria.java This is interface for searching entities.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public interface SearchCriteria extends Serializable {
  /** Value for the Wildcared Token. */
  public static String WILDCARD_TOKEN = "*";
  
  /**
   * Getter of the property <tt>sortBy</tt>
   * 
   * @return the sortBy
   */
  String getSortBy();
  
  /**
   * Setter of the property <tt>sortBy</tt>
   * 
   * @param sortBy the sortBy to set
   */
  void setSortBy(String sortBy);
  
  /**
   * Getter of the property <tt>filter</tt>
   * 
   * @return the filter
   */
  public FilterExpression getFilter();
  
  /**
   * Setter of the property <tt>filter</tt>
   * 
   * @param expr the filter to set
   */
  public void setFilter(FilterExpression expr);
  
  /**
   * Convenient method to add filter.
   * 
   * @param filter A map of key/value pairs.
   */
  public void setFilter(Map<String, String> filter);
  
  /**
   * Convenient method to add filter;
   * 
   * @param term FilterTerm
   */
  public void addFilter(FilterTerm term);
  
  /**
   * Convenient method to add filter.
   * 
   * @param key the key.
   * @param value the value.
   */
  public void addFilter(String key, String value);
  
  /**
   * Parse string to create key-value pair for SearchCriteria. key/value is seperated by '=', multiple key/value pairs are seperated by '&'. Example:
   * id=100 id=100&name=Jiggy id=100,101&name=Jiggy, john
   * 
   * @param filterString the rowCount to set
   */
  public void addFilter(String filterString);
  
  /**
   * Returns if pagination is enabled or disabled. Getter of the property <tt>paginationEnabled</tt>
   * 
   * @return true if pagination is enabled else false.
   */
  boolean isPaginationEnabled();
  
  /**
   * Getter of the property <tt>offset</tt>
   * 
   * @return the offset
   */
  public int getOffset();
  
  /**
   * Setter of the property <tt>offset</tt>
   * 
   * @param offset the offset to set
   */
  public void setOffset(int offset);
  
  /**
   * Getter of the property <tt>limit</tt>
   * 
   * @return the limit
   */
  public int getLimit();
  
  /**
   * Setter of the property <tt>limit</tt>
   * 
   * @param limit the limit to set
   */
  public void setLimit(int limit);
  
  /**
   * Getter of the property <tt>rowCount</tt>
   * 
   * @return the rowCount
   */
  public int getRowCount();
  
  /**
   * Setter of the property <tt>rowCount</tt>
   * 
   * @param rowCount the rowCount to set
   */
  public void setRowCount(int rowCount);
  
  /**
   * Getter of the property <tt>queryVariables</tt>
   * 
   * @return the queryVariables
   */
  public String getQueryVariables();
  
  /**
   * Setter of the property <tt>queryVariables</tt>
   * 
   * Use only if the query involves a join
   * 
   * @param queryVariables the queryVariables to set
   */
  public void setQueryVariables(String queryVariables);
}