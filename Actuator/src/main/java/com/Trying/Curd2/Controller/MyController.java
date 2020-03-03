package com.Trying.Curd2.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Trying.Curd2.model.MyModel;
import com.Trying.Curd2.service.MyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Student")
@RestController
@RequestMapping("/students")
public class MyController {
	
	@Autowired
	MyService myservice;
	
	@ApiOperation(value ="Get all student records", notes ="implementation notesssss")
	@RequestMapping(value ="", method = RequestMethod.GET)
	public List<MyModel> Anymethod(){
		return myservice.getAllStudent();		
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addStudent(@RequestBody MyModel std,HttpServletRequest request, HttpServletResponse response){
		MyModel student= myservice.addStudent(std);
		response.setHeader("Location", request.getRequestURL().append("/").append(student.getId()).toString());	
	}
	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public Optional<MyModel> getStudent(@PathVariable("id") String id) {
		return 	myservice.getStudentById(Integer.valueOf(id));
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void upStudent(@PathVariable("id") int id,@RequestBody MyModel std) {
		 	myservice.updateStudent(std);
	}
	@RequestMapping(value= "/{id}", method= RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("id") int id) {
		 	myservice.deleteStudent(id);
	}

}
