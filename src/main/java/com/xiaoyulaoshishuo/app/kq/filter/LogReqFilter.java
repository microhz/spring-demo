package com.xiaoyulaoshishuo.app.kq.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.xiaoyulaoshishuo.app.kq.support.BaseController;

/**
 * @author mapc 
 * @date 2017年6月19日
 */
public class LogReqFilter implements Filter {
	
	private List<Pattern> excluedUrlPatternList;

	public void init(FilterConfig filterConfig) throws ServletException {
		excluedUrlPatternList = new ArrayList<Pattern>();
		String excludeUrl = filterConfig.getInitParameter("excluedUrl");
		List<Pattern> patternList = new ArrayList<Pattern>();
		if (!StringUtils.isEmpty(excludeUrl)) {
			String[] array = excludeUrl.split(",");
			for (String s : array) {
				Pattern pattern = Pattern.compile(s);
				patternList.add(pattern);
				excluedUrlPatternList.add(pattern);
			}
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (response instanceof HttpServletResponse && request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String suffix = getSuffix(httpServletRequest.getRequestURI());
			if (!suffix.equals("register.html") && !suffix.equals("login.html") && !suffix.equals("logined.html")) {
				Object obj = httpServletRequest.getSession().getAttribute(BaseController.USER_KEY);
				if (obj == null) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse.sendRedirect("/xiaoyulaoshishuo-kq/page/login.html");
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	private boolean isPattern(String suffix) {
		for (Pattern pattern : excluedUrlPatternList) {
			if (pattern.matcher(suffix) != null && pattern.matcher(suffix).matches()) {
				return true;
			}
		}
		return false;
	}
	
	private String getSuffix(String uri) {
		if (uri.lastIndexOf(".") != -1) {
			return uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		}
		return "";
	}

	public void destroy() {
		
	}

}
