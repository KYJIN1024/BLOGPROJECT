package com.david.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.david.dto.HelloResponseDto;


@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello Spring boot!";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("nickname") String nickname) {
		return new HelloResponseDto(name, nickname);
	}
	
	
}
