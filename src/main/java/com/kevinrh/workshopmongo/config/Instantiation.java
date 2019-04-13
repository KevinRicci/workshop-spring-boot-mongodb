package com.kevinrh.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kevinrh.workshopmongo.domain.Post;
import com.kevinrh.workshopmongo.domain.User;
import com.kevinrh.workshopmongo.dto.AuthorDTO;
import com.kevinrh.workshopmongo.dto.CommentDTO;
import com.kevinrh.workshopmongo.repository.PostRepository;
import com.kevinrh.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		CommentDTO comment1 = new CommentDTO("Aproveite!", sdf.parse("28/03/2018"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Só vai", sdf.parse("29/03/2018"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Eaí, tá gostando ?", sdf.parse("29/03/2018"), new AuthorDTO(alex));
		
		Post post1 = new Post(null, sdf.parse("28/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/06/2019"), "Patiu viagem!", "São Paulo ai vou eu...", new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(comment1));
		post2.getComments().addAll(Arrays.asList(comment2, comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
