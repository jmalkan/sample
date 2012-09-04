package com.jiggy.sample;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiggy.sample.security.UserRealm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
  private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
  
  @Autowired
  Comparator<String> comparator;
  
  @RequestMapping(value = "/")
  public String home() {
    logger.info("HomeController: Passing through...");
    return "login.html";
  }
}