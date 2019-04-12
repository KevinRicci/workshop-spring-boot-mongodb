package com.kevinrh.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @Getter @Setter
	private String id;
	@Getter @Setter
	private Date data;
	@Getter @Setter
	private String title;
	@Getter @Setter
	private String body;
	
	@Getter @Setter
	private User author;
	
	
}
