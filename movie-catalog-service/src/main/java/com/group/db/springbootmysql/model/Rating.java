package com.group.db.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Rating {
	@Id		
	private int movieId;	
	
	@Column(name="userId")
	private int userId;
		
	private int rating;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Rating(int userId, int movieId, int rating) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}



}
