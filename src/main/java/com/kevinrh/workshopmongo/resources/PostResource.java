package com.kevinrh.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevinrh.workshopmongo.domain.Post;
import com.kevinrh.workshopmongo.services.PostService;;

@RestController
@RequestMapping(value="/post")
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findPostById(@PathVariable String id){
		Post post = service.findPostById(id);
		return ResponseEntity.ok().body(post);
	}
}
