package com.group.db.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class catalogItem {
	private int ID;
	
	private String name;
	
	private String description;
	
	private int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	public catalogItem( @Size(min = 4, max = 255) String name, @Size(min = 4, max = 500) String desc,
			int rating) {
		super();
		this.name = name;
		this.description = desc;
		this.rating = rating;
	}

	public catalogItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
