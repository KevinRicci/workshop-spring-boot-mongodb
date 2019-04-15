package com.kevinrh.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kevinrh.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	public List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
	@Query("{'body': {$regex : ?0, $options: 'i'}}")
	public List<Post> findByPostBody(String text);
	
	public List<Post> findByTitleContainingIgnoreCase(String text); //query method
}