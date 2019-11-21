package com.exampe.aop.demoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SimpleAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Pointcut("execution(public * com.exampe.aop.demoaop.service.SimpleService.aspectBefore(..))")
	public void beforePointcut() { }

	@Before("beforePointcut()")
	public void beforeAdvice(JoinPoint jp) {
		logger.info("1) Before method: " + jp.getSignature());
	}


	@Pointcut("execution(public * com.exampe.aop.demoaop.service.SimpleService.aspectAfter(..))")
	public void afterPointcut() { }

	@After("afterPointcut()")
	public void afterAdvice(JoinPoint jp) {
		logger.info("2) After method: " + jp.getSignature());
	}


	@Around("execution(public * com.exampe.aop.demoaop.service.SimpleService.aspectAround(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("3) Around method (before): " + pjp.getSignature());
		Object retVal = pjp.proceed();
		logger.info("3) Around method (after): " + pjp.getSignature());
		return retVal;
	}


	@Around("@annotation(AnnotationAround)")
	public Object annotationAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("4) Annotation around method (before): " + pjp.getSignature());
		Object retVal = pjp.proceed();
		logger.info("4) Annotation around method (after): " + pjp.getSignature());
		return retVal;
	}
}