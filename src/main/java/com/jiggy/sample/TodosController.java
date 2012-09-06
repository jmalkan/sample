package com.jiggy.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TodosController {
  private static final Logger logger = LoggerFactory.getLogger(TodosController.class);
  
  
  @RequestMapping(value = "/todos", method = RequestMethod.GET)
  public String home() {
    logger.info("TodosController: Passing through...");
    return "login.html";
  }
}