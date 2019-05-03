package org.feign;

import org.feign.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
@RestController
//@EnableCircuitBreaker
//@EnableHystrixDashboard
//@EnableTurbine
public class ServiceFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
	
//	@Bean
//    public ServletRegistrationBean getServlet() {
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping("/")
	private String sayHello() {
		return helloWorldService.sayHello();
	}

}
