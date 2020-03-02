package com.ekumeed.help.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping(value ="/welcome", method=RequestMethod.GET)
	public String welcomeMsg() {
		return "Welcome to Spring boot App";
	}
	@RequestMapping("/getuser")
	public String getUserName(@RequestParam String name) {
		return "WELCOME boss u are   "+ name;
	}

}
