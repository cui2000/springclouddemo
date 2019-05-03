package org.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="getHelloContentError")
	public String getHelloContent() {
		return restTemplate.getForObject("http://CONFIG-CLIENT/", String.class);
	}
	
	public String getHelloContentError(){
		return "err";
	}

}
