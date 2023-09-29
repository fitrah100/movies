package com.movies.requests;

import java.util.Date;

import com.movies.entities.Movies;

public record CreateMoviesInput(int id, String title, String description, Float rating, String image, Date created_at, Date updated_at) {
	public Movies toMovies() {
		Movies movies = new Movies();
			movies.setId(id);
			movies.setTitle(title);
			movies.setDescription(description);
			movies.setRating(rating);
			movies.setImage(image);
			movies.setCreated_at(created_at);
			movies.setUpdated_at(updated_at);
	
			
			return movies;
	}
}
