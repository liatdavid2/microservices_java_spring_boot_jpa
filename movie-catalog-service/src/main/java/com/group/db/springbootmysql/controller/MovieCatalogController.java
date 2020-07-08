package com.group.db.springbootmysql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.group.db.springbootmysql.error.ApiError;
import com.group.db.springbootmysql.model.Movie;
import com.group.db.springbootmysql.model.Rating;
import com.group.db.springbootmysql.model.UserRatings;
import com.group.db.springbootmysql.model.catalogItem;
//import com.group.db.springbootmysql.repository.catalogRepository;
import com.group.db.springbootmysql.shared.GenericResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/rest/1.0/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	//http://localhost:7000/rest/1.0/catalog/catalogItem?userId=1
	@GetMapping(value="/catalogItem")
	public catalogItem  getCatalog(@RequestParam int userId)
	{
		//get user rating from rating-data-service by user id
		Rating rating = restTemplate
				.getForObject("http://localhost:7002/rest/1.0/ratingsdata/user?userId="+userId,
						Rating.class);
		
		//get movie name and info from movie-info-service by user id
		Movie movie = restTemplate
				.getForObject("http://localhost:7001/rest/1.0/movies/movieItem?movieId="+userId
		,Movie.class);
		
		//return catalogItem from the data in rating-data-service and in movie-info-service
		return new catalogItem(movie.getName(),movie.getDescription(),rating.getRating());
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		ApiError apiError = new ApiError(400, request.getServletPath(), "validation Error");
		
		BindingResult result = exception.getBindingResult();
		
		Map<String,String> validationErrors = new HashMap<>();
		for (FieldError fieldError: result.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		apiError.setValidationErrors(validationErrors);
		return apiError;
	}

}
