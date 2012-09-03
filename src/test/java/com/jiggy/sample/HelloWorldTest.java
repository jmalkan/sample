package com.jiggy.sample;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.jiggy.sample.HelloWorld;

public class HelloWorldTest {

  @Test
  public void sayHello() {
    HelloWorld helloWorld = new HelloWorld();
    
    assertEquals(helloWorld.sayHello(), "Hello");
  }
}