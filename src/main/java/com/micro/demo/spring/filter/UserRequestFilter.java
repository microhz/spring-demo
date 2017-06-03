package com.micro.demo.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mapc 
 * @date 2017年5月19日
 */
public class UserRequestFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(" filter init..");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter...");
	}

	public void destroy() {
		System.out.println("des");
	}

	

}
