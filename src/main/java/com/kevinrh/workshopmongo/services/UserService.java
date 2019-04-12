package com.kevinrh.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinrh.workshopmongo.domain.User;
import com.kevinrh.workshopmongo.dto.UserDTO;
import com.kevinrh.workshopmongo.repository.UserRepository;
import com.kevinrh.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		List<User> list = repository.findAll();
		return list;
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newObj = findById(user.getId());
		updateData(newObj, user);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User user) {
		if(user.getNome() == null) {
		}
		else {newObj.setNome(user.getNome());}
		if(user.getEmail() == null) {
		}
		else {newObj.setEmail(user.getEmail());}
	}
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}
}
