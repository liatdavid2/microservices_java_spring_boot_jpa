package com.group.db.springbootmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.db.springbootmysql.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{



}
