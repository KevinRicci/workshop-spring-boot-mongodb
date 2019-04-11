package com.kevinrh.workshopmongo.dto;

import java.io.Serializable;

import com.kevinrh.workshopmongo.domain.User;

import lombok.Getter;
import lombok.Setter;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private String id;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.nome = user.getNome();
		this.email = user.getEmail();
	}
}
