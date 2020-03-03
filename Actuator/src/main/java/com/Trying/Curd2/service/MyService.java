package com.Trying.Curd2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Trying.Curd2.model.MyModel;
import com.Trying.Curd2.repository.MyRepoInterface;

@Service
public class MyService {
	
	@Autowired
	MyRepoInterface myrepointerface;
	
	public List<MyModel>getAllStudent(){
		List<MyModel> allStudent = new ArrayList<MyModel>();
		myrepointerface.findAll().forEach(s -> allStudent.add(s));
		return allStudent;
	}
	
	public MyModel addStudent(MyModel std) {
		return myrepointerface.save(std);
	}
	public Optional<MyModel> getStudentById(int id) {
		return myrepointerface.findById(id);
	}
	public void updateStudent(MyModel std) {
		 myrepointerface.save(std);
	}
	public void deleteStudent(int id) {
		myrepointerface.deleteById(id);
	}

}
