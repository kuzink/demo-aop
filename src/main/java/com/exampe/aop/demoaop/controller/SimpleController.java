package com.exampe.aop.demoaop.controller;

import com.exampe.aop.demoaop.service.SimpleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {

	private SimpleService simpleService;

	public SimpleController(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	@GetMapping
	public String hello(){
		return simpleService.hello();
	}

	@GetMapping("/aspectBefore")
	public String aspectBefore(){
		return simpleService.aspectBefore();
	}

	@GetMapping("/aspectAfter")
	public String aspectAfter(){
		return simpleService.aspectAfter();
	}

	@GetMapping("/aspectAround")
	public String aspectAround(){
		return simpleService.aspectAround();
	}

	@GetMapping("/aspectAnnotationAround")
	public String aspectAnnotationAround(){
		return simpleService.aspectAnnotationAround();
	}
}
