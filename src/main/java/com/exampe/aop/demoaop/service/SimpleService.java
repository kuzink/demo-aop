package com.exampe.aop.demoaop.service;

import com.exampe.aop.demoaop.aspect.AnnotationAround;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String hello(){
		return "hello";
	}

	public String aspectBefore(){
		logger.info("1) aspectBefore");
		return "aspectBefore";
	}

	public String aspectAfter(){
		logger.info("2) aspectAfter");
		return "aspectAfter";
	}

	public String aspectAround(){
		logger.info("3) aspectAround");
		return "aspectAround";
	}

	@AnnotationAround
	public String aspectAnnotationAround(){
		logger.info("4) aspectAnnotationAround");
		return "aspectAnnotationAround";
	}
}
