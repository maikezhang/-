package com.product.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


	 @RequestMapping("/hello")
	    public String index() {
		 	logger.info("success");
	        return "Hello World";
	    }
}
