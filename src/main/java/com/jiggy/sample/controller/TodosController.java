package com.jiggy.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiggy.sample.todo.Todo;
import com.jiggy.sample.todo.TodoService;

/**
 * Handles requests for the application todos request.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
@Controller
@RequestMapping("todos")
public class TodosController {
  private static final Logger logger = LoggerFactory.getLogger(TodosController.class);
  
  private TodoService todoService;
  
  /**
   * Creates a new instance of com.jiggy.sample.controller.TodosController.java and Performs Initialization
   */
  public TodosController() {
    super();
  }
  
  /**
   * Creates a new instance of com.jiggy.sample.controller.TodosController.java and Performs Initialization
   */
  @Autowired
  public TodosController(TodoService todoService) {
    super();
    this.todoService = todoService;
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public List<Todo> findAll() {
    logger.info("findAll");
    
    return this.todoService.findAll();
  }
  
  @ResponseBody
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Todo findById(@PathVariable Long id) {
    logger.info("findById");
    
    return this.todoService.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public List<Todo> find(HttpServletRequest request) {
    logger.info("find");
    Map<String, String> searchCriteria = getSearchCriteria(request);
    
    return this.todoService.find(null);
  }
  
  @ResponseBody
  @RequestMapping(value = "/findOne", method = RequestMethod.GET)
  public Todo findOne(HttpServletRequest request) {
    logger.info("findOne");
    Map<String, String> searchCriteria = getSearchCriteria(request);
    
    return this.todoService.findOne(null);
  }
  
  @ResponseBody
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    logger.info("delete");
    
    this.todoService.delete(id);
  }
  
  private Map<String, String> getSearchCriteria(HttpServletRequest request) {
    logger.debug("find queryString: {}", request.getQueryString());
    Map<String, String> searchCriteria = new HashMap<String, String>();
    Map<Object, Object> requestParameterMap = request.getParameterMap();
    
    if (requestParameterMap != null) {
      for (Entry<Object, Object> entrySet:requestParameterMap.entrySet()) {
        logger.debug("find {}={}", entrySet.getKey(), entrySet.getValue());
        searchCriteria.put(entrySet.getKey().toString(), entrySet.getValue().toString());
      };
    };
    
    return searchCriteria;
  }
}