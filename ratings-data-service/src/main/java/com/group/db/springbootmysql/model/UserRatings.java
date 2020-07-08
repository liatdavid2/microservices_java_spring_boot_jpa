package com.group.db.springbootmysql.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//@Entity
public class UserRatings {

	private List<Rating> UserRatingList;

	public List<Rating> getUserRatingList() {
		return UserRatingList;
	}

	public void setUserRatingList(List<Rating> userRatingList) {
		UserRatingList = userRatingList;
	}

	public UserRatings(List<Rating> userRatingList) {
		super();
		UserRatingList = userRatingList;
	}

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
