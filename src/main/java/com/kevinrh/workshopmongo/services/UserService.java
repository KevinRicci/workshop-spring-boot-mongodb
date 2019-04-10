package com.kevinrh.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinrh.workshopmongo.domain.User;
import com.kevinrh.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		List<User> list = repository.findAll();
		return list;
	}
}
