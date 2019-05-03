package org.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class DemoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(DemoFilter.class);

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

}
