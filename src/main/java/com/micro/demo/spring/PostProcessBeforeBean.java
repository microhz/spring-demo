package com.micro.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author mapc 
 * @date 2017年6月11日
 */
// 能够在对象初始化之前和之后进行操作
@Component
public class PostProcessBeforeBean implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof UserBean) {
			System.out.println("bean post method execute before invoke..");
//			((UserBean) bean).setStatus(1);
			((UserBean) bean).test();
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof UserBean) {
			System.out.println("bean post method execute after invoke..");
//			((UserBean) bean).setStatus(2);
			((UserBean) bean).test();
		}
		return bean;
	}

}
