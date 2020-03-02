package com.infotech.app.controller;


@RestController
public class HelloWorldController {
	@RequestMapping(Value = "/")
	public String hello() {
		return "Hello World !!";
	}
	

}
