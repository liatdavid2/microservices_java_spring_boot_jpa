package com.group.db.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Movie {
@Id	
@GeneratedValue
@Column(name="movieId")
private int movieId;

@NotNull
@Size(min = 4,max =255)
private String Name;

@NotNull
@Size(min = 4,max =500)
private String description;



public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getMovieId() {
	return movieId;
}

public void setMovieId(int movieId) {
	this.movieId = movieId;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}


public Movie(int movieId, @NotNull @Size(min = 4, max = 255) String name,
		@NotNull @Size(min = 4, max = 500) String description) {
	super();
	this.movieId = movieId;
	Name = name;
	this.description = description;
}

public Movie() {
	super();
	// TODO Auto-generated constructor stub
}




}
