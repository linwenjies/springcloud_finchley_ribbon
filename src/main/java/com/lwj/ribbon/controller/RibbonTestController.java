package com.lwj.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate集成ribbon
 * @author linwenjie
 *
 */
@RestController
@RequestMapping("/ribbonTest")
public class RibbonTestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ribbon")
	public String down() {
		return restTemplate.getForObject("http://eureka-client/hello/hello", String.class);
	}
	
	@GetMapping("/testRetry")
	public String testRetry() {
		return restTemplate.getForObject("http://eureka-client/ribbonTest/testRetry", String.class);
	}
	
	
	
}
