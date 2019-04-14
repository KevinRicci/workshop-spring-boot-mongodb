package com.kevinrh.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kevinrh.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{'body': {$regex : ?0, $options: 'i'}}")
	public List<Post> findByPostBody(String text);
	
	public List<Post> findByTitleContainingIgnoreCase(String text); //query method
}