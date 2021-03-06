package com.rvbs.pm.filter;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
 
 /**
  *	解决RequestBody流只能获取一次问题
  * @author xiaole
  *
  */
@WebFilter(filterName="requestBodyReaderFilter",urlPatterns="/*")
public class RequestBodyReaderFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing
	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletRequest requestWrapper=null;
		if(request instanceof HttpServletRequest) {
			requestWrapper=new RequestBodyReaderWrapper((HttpServletRequest)request);
		}
		if(requestWrapper==null) {
			chain.doFilter(request, response);
		}else {
			chain.doFilter(requestWrapper, response);
		}
		
	}
 
	@Override
	public void destroy() {
		// do nothing
		
	}
 
}
 
