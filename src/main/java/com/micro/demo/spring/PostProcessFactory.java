package com.micro.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author mapc 
 * @date 2017年6月11日
 */
// 在工厂配置之前进行一些处理
@Component
public class PostProcessFactory implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		UserBean userBean = beanFactory.getBean(UserBean.class);
//		userBean.setStatus(0);
//		System.out.println("post factory.");
//		userBean.test();
	}

}
