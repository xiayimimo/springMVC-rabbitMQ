package com.tycho.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class EncodingFilter implements Filter {

	private String encoding;
	public void destroy() {
		System.out.println("销毁时间过滤器");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("开始执行编码过滤器");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化编码过滤器");
		this.encoding = filterConfig.getInitParameter("encoding");
		
	}

	

}
