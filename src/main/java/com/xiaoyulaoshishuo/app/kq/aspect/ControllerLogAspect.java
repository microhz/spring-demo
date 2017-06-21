package com.xiaoyulaoshishuo.app.kq.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xiaoyulaoshishuo.app.kq.support.BaseController;
import com.xiaoyulaoshishuo.app.kq.utils.ErrorMsgEnum;

/**
 * @author mapc
 * @date 2017年6月15日
 */
@Aspect
@Component
public class ControllerLogAspect extends BaseController {

	// Logger logger = Logger.getLogger("ApiLogger");
	Logger logger = Logger.getLogger(this.getClass());

	private final static String LOG_PREFIXX = "API : ";

	@Pointcut("execution(* com.xiaoyulaoshishuo.app.kq.controller.*.*(..))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object log(ProceedingJoinPoint proceedingJoinPoint) {
		Object[] args = proceedingJoinPoint.getArgs();
		String methodName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
		StringBuilder sb = new StringBuilder();
		sb.append(LOG_PREFIXX).append("request to ").append(className).append(" - > ").append(methodName)
				.append(" - > ").append(" args : ");
		for (Object p : args) {
			sb.append(p).append(",");
		}
		String msg = sb.lastIndexOf(",") != -1 ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
		logger.debug(msg);
		try {
			Object ret = proceedingJoinPoint.proceed();
			if (ret instanceof String) {
				logger.debug("response - > : " + ret);
			}
			return ret;
		} catch (Throwable e) {
			logger.error("execute controller error , msg : " + e.getMessage());
		}
		return fail(ErrorMsgEnum.ERROR);
	}
}
