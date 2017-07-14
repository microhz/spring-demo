package com.xiaoyulaoshishuo.app.kq.intercepter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.support.BaseController;
import com.xiaoyulaoshishuo.app.kq.support.annotation.UnLoginCheck;

/**
 * @author mapc
 * @date 2017年6月14日
 */
public class LoginCheckIntercepter extends BaseController implements HandlerInterceptor, ApplicationContextAware {

	private WebApplicationContext webApplicationContext;

	private List<String> execludeUrlList;

	@Value("${jyxb.login.exclude.url}")
	private String excludeUrl;

	public void initExcludeUrl() {
		this.execludeUrlList = new ArrayList<String>();
		String[] array = excludeUrl.split(",");
		for (String url : array) {
			execludeUrlList.add(url);
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (applicationContext instanceof WebApplicationContext) {
			this.webApplicationContext = (WebApplicationContext) applicationContext;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * 访问handler必须先登录
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (isCheckLogin(request, handler)) {
			if (webApplicationContext != null) {
				Operator operator = (Operator) request.getSession().getAttribute(USER_KEY);
				if (operator != null) {
					return true;
				}
			}
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.write(fail("未登录"));
			return false;
		}
		return true;
	}

	private boolean isCheckLogin(HttpServletRequest request, Object handler) {
		if (!request.getRequestURI().endsWith(".html") && handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			UnLoginCheck unLoginCheck = handlerMethod.getMethodAnnotation(UnLoginCheck.class);
			if (unLoginCheck != null) {
				return false;
			}
			return true;
		}
		return false;
	}

}
