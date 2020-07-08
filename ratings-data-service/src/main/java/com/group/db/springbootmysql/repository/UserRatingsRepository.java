package com.group.db.springbootmysql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group.db.springbootmysql.model.Rating;

public interface UserRatingsRepository extends JpaRepository<Rating,Integer>{

	@Query("select new Rating(movieId,userId,rating) from Rating r where r.userId = ?1")
	Rating findMoviesRatingsByUserId(int userId);
}
