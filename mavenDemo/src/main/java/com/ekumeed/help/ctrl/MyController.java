package com.ekumeed.help.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	MyService service;
	
	/*@RequestMapping(value ="/welcome", method=RequestMethod.GET)
	public String welcomeMsg() {
		return "Welcome to Spring boot App";
	}
	@RequestMapping("/getuser")
	public String getUserName(@RequestParam String name) {
		return "WELCOME boss u are   "+ name;
	}*/
	@RequestMapping(value = "/abc")
	@ResponseBody
	public Contact getIdName(@RequestBody Contact detail) {
		service.showDetail(detail);
		return detail;

}

	
	
	
				
		
	}

