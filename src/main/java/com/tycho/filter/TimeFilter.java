package com.tycho.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化时间过滤器");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		 System.out.println("开始执行时间过滤器");
	        Long start = new Date().getTime();
	        filterChain.doFilter(servletRequest, servletResponse);
	        System.out.println("【过滤器】耗时 " + (new Date().getTime() - start));
	        System.out.println("结束执行过滤器");
	}

	@Override
	public void destroy() {
		System.out.println("销毁时间过滤器");
		
	}

}
