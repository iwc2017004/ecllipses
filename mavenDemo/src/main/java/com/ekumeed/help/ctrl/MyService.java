package com.ekumeed.help.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	MyDao dao;
	
	public void showDetail(Contact detail) {
		
		System.out.println("servies class");
		dao.needDetail(detail);
		
		
	}

	
	
	
	

}
