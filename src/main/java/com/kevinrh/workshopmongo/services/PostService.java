package com.kevinrh.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinrh.workshopmongo.domain.Post;
import com.kevinrh.workshopmongo.repository.PostRepository;
import com.kevinrh.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findPostById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		List<Post> posts = repository.findByTitleContainingIgnoreCase(text);
		return posts;
	}
}
