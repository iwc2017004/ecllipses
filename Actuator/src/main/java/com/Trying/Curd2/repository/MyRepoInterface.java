package com.Trying.Curd2.repository;

import org.springframework.data.repository.CrudRepository;

import com.Trying.Curd2.model.MyModel;

public interface MyRepoInterface extends CrudRepository<MyModel, Integer> {
	
}
