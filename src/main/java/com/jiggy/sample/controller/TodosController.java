package com.jiggy.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiggy.sample.todo.Todo;
import com.jiggy.sample.todo.TodoService;

/**
 * Handles requests for the application todos request.
 */
@Controller
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
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Todo> findAll() {
    logger.info("findAll");
    List<Todo> todos = new ArrayList<Todo>();
    
    //List<Todo> todos = this.todoService.findAll();
    todos.add(new Todo(new Long(1), "wake up"));
    todos.add(new Todo(new Long(2), "do dishes"));
    todos.add(new Todo(new Long(3), "take out trash"));
    
    return todos;
  }
  
  @ResponseBody
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Todo findById(@PathVariable String id) {
    logger.info("findById");
    
    return new Todo(new Long(1), "wake up");
  }
  
  @ResponseBody
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public List<Todo> find(@RequestBody String body) {
    logger.info("find body: {}", body);
    List<Todo> todos = new ArrayList<Todo>();
    
    todos.add(new Todo(new Long(1), "wake up"));
    todos.add(new Todo(new Long(2), "do dishes"));
    
    return todos;
  }
}