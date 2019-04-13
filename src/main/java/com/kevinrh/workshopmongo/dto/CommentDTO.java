package com.kevinrh.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String text;
	@Getter @Setter
	private Date date;
	
	@Getter @Setter
	private AuthorDTO author;
}
