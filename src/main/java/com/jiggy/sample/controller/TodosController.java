package com.jiggy.sample.controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application todos request.
 */
@Controller
@RequestMapping(value = "/sample/service/todos")
public class TodosController {
  private static final Logger logger = LoggerFactory.getLogger(TodosController.class);
  
  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public JSONArray findAll() {
    logger.info("findAll");
    JSONObject todo = null;
    JSONArray todos = new JSONArray();
    try {
      todo = new JSONObject("{id: 1, name: wake up}");
    } catch (JSONException e) {
      e.printStackTrace();
    }
    
    todos.put(todo);
    
    return todos;
  }
  
  @ResponseBody
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public JSONObject findById(@PathVariable String id) {
    logger.info("id = {}", id);
    JSONObject todo = null;
    try {
      todo = new JSONObject("{id: 1, name: wake up}");
    } catch (JSONException e) {
      e.printStackTrace();
    }
    
    return todo;
  }
  
  @ResponseBody
  @RequestMapping(value = "/find", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
  public JSONArray find(@RequestBody String body) {
    logger.info("find body: {}", body);
    JSONObject todo = null;
    JSONArray todos = new JSONArray();
    try {
      todo = new JSONObject("{id: 1, name: wake up}");
    } catch (JSONException e) {
      e.printStackTrace();
    }
    
    todos.put(todo);
    
    return todos;
  }
}