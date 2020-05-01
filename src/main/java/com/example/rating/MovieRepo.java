package com.example.rating;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Integer> {
	

}