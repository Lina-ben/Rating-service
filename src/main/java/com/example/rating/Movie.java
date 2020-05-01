package com.example.rating;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Movie")
public class Movie {
	
	
	@OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
	private Set<UserMovies> usermovies = new HashSet<UserMovies>();

	public Movie() {
		super();

	}

	@Id
	Integer movieid ;

	public Movie(Integer movieid, Set<UserMovies> usermovies) {
		super();
		this.movieid = movieid;
		this.usermovies = usermovies;
	}
	
	public Movie(Integer movieid) {
		super();
		this.movieid = movieid;
		
	}


	public Integer getMovieid() {
		return movieid;
	}


	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

    
	//@JsonManagedReference
	public Set<UserMovies> getUsermovies() {
		return usermovies;
	}


	public void setUsermovies(Set<UserMovies> usermovies) {
		this.usermovies = usermovies;
	}
	
	

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", usermovies=" + usermovies + "]";
	}


	
}
