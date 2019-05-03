package org.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceFailure implements HelloWorldService {

	@Override
	public String sayHello() {
		return "我错了";
	}

}
