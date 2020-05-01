package com.example.rating;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class Ratingservice {
	
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error")  
  	@ExceptionHandler(Exception.class)
  	public void error() {
  	}
	
	
	MovieRepo movieRepo ;
	UserMoviesRepo userMoviesRepo ;
	UserRepo userRepo ;
	
	@Autowired
	public Ratingservice(MovieRepo movieRepo, UserMoviesRepo userMoviesRepo , UserRepo userRepo  ) {
		super();
		this.movieRepo = movieRepo;
		this.userRepo = userRepo ;
		this.userMoviesRepo = userMoviesRepo;
		
	}
	
	
	@RequestMapping(value ="/add/rating", method = RequestMethod.POST) 
	@ResponseBody
	public void addRating(@RequestBody Rating test, @RequestParam(value="userid", required=true) Integer userid) throws Exception {
		
	     Movie m = new Movie(test.getMovieId());
	     User u = new User();
	     u.setUserid(userid);
	     
	     UserMovies obj = new UserMovies();
	     obj.setMovie(m);
	     obj.setUser(u);
	     obj.setRating(test.getRating());
	     
	     m.getUsermovies().add(obj);
	     u.getUsermovies().add(obj);
	     
	     movieRepo.save(m) ;
         userMoviesRepo.save(obj);
         
		}
	   	 
	
	
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ViewRating getMoviesRating(@PathVariable(value = "userid") Integer userId){
		
		User u = userRepo.findByUserid(userId);
		Set<UserMovies> set =  u.getUsermovies() ;
		
		ViewRating viewRating = new ViewRating();
		viewRating.setUserId(userId);
		
		
		Set<Rating> l = new HashSet<Rating>();
		
		for (UserMovies obj : set) {
		
			Rating r = new Rating();
			r.setMovieId(obj.getMovie().getMovieid());
			r.setRating(obj.getRating());
		    l.add(r);

		}
		
		viewRating.setRatings(l);
		
		return viewRating ;
		
	   
	}
	
	@RequestMapping(value ="/add/user", method = RequestMethod.POST) 
	@ResponseBody
	public void addUser(@RequestBody Integer userid) throws Exception {
		
		
		User u = new User();
		u.setUserid(userid);
		userRepo.save(u);
	
	}
	
	

		 
		 
	      
	     
	    


}
