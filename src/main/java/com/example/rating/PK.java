package com.example.rating;

import java.io.Serializable;

public class PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer movies ;
	private Integer users ;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK other = (PK) obj;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	public Integer getMovies() {
		return movies;
	}
	public void setMovies(Integer movies) {
		this.movies = movies;
	}
	public Integer getUsers() {
		return users;
	}
	public void setUsers(Integer users) {
		this.users = users;
	}
	

}
