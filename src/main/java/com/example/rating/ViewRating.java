package com.example.rating;

import java.util.Set;

public class ViewRating {
	
	Integer UserId ;
	Set<Rating> ratings ;
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	@Override
	public String toString() {
		return "ViewRating [UserId=" + UserId + ", ratings=" + ratings + "]";
	}
	public Set<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	public ViewRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
