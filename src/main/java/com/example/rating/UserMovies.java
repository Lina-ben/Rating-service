package com.example.rating;


import java.io.Serializable;

import javax.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name = "User_Movie")
@IdClass(PK.class)
public class UserMovies implements Serializable {

	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id",referencedColumnName = "movieid")
    private Movie movies;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",referencedColumnName = "userid")
    private User users;

    @Column(name = "rating")
    private float rating;



	@Override
	public String toString() {
		return "UserMovies [movies=" + movies + ", users=" + users + ", rating=" + rating + "]";
	}

	public UserMovies(Movie movies, User users, float rating) {
		super();
		this.movies = movies;
		this.users = users;
		this.rating = rating;
	}

	public UserMovies() {
		super();
		// TODO Auto-generated constructor stub
	}

	//@JsonBackReference
	public Movie getMovie() {
		return movies;
	}
	


	public void setMovie(Movie movie) {
		this.movies = movie;
	}
    
	//@JsonBackReference
	public User getUser() {
		return users;
	}

	public void setUser(User user) {
		this.users = user;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
}