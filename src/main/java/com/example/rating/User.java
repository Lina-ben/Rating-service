package com.example.rating;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "User")
public class User {
	
	
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private Set<UserMovies> usermovies = new HashSet<UserMovies>();
	
	
		@Override
	public String toString() {
		return "User [userid=" + userid  + "]";
	}

		
		public User(Integer userid, Set<UserMovies> usermovies) {
			super();
			this.userid = userid;
			this.usermovies = usermovies;
		}


		public User() {
		super();

	}
      
		@Id
		@JsonIgnore
		private Integer userid ;

	 



		public Integer getUserid() {
			return userid;
		}

		public void setUserid(Integer userid) {
			this.userid = userid;
		}
        
		//@JsonManagedReference
		public Set<UserMovies> getUsermovies() {
			return usermovies;
		}

		public void setUsermovies(Set<UserMovies> usermovies) {
			this.usermovies = usermovies;
		}

		

}
