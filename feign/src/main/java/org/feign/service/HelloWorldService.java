package org.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "config-client", fallback = HelloWorldServiceFailure.class)
public interface HelloWorldService {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String sayHello();
}
