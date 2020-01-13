package com.example.bootdemo2.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bootdemo2.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findByName(String name);
}
