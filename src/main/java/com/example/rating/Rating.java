package com.example.rating;



public class Rating {
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}


	Integer movieId; 
	float rating ;

	
	
	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", rating=" + rating +  "]";
	}



	public Rating(Integer movieId, float rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}


	public Integer getMovieId() {
		return movieId;
	}


	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	

}
