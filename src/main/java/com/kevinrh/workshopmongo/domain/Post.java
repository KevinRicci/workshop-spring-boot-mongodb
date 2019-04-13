package com.kevinrh.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.kevinrh.workshopmongo.dto.AuthorDTO;
import com.kevinrh.workshopmongo.dto.CommentDTO;

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
	private AuthorDTO author;
	@Getter @Setter
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post (String id, Date data, String title, String body, AuthorDTO author) {
		this.id = id;
		this.data = data;
		this.title = title;
		this.body = body;
		this.author = author;
	}
}
