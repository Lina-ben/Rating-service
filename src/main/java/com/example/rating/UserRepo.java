package com.example.rating;


import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Integer> {
	
	           User findByUserid(Integer id);
	           
	      

}