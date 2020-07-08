# microservices_java_spring_boot_jpa

#main microservices code

	//http://localhost:7000/rest/1.0/catalog/catalogItem?userId=1
	@GetMapping(value="/catalogItem")
	public catalogItem  getCatalog(@RequestParam int userId)
	{
		//Get user rating from rating-data-service by user id
		Rating rating = restTemplate
				.getForObject("http://localhost:7002/rest/1.0/ratingsdata/user?userId="+userId,
						Rating.class);
		
		//Get movie name and info from movie-info-service by user id
		Movie movie = restTemplate
				.getForObject("http://localhost:7001/rest/1.0/movies/movieItem?movieId="+userId
		,Movie.class);
		
		//return catalogItem from the data in rating-data-service and in movie-info-service
		return new catalogItem(movie.getName(),movie.getDescription(),rating.getRating());
	}
