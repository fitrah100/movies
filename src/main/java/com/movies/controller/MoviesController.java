package com.movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.entities.Movies;
import com.movies.requests.CreateMoviesInput;
import com.movies.services.MoviesService;

@RestController
public class MoviesController {
	public MoviesService MoviesService;
	
	public MoviesController(MoviesService MoviesService) {
		this.MoviesService=MoviesService;
	}
	
	@PostMapping("/Movies")
	public ResponseEntity<Movies> createMovies(@RequestBody CreateMoviesInput createMoviesInput) {
	    Movies MoviesCreated = MoviesService.create(createMoviesInput.toMovies());

	    return new ResponseEntity<>(MoviesCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/Movies/{id}")
	public ResponseEntity<Object> getMovies(@PathVariable("id") int id) {
	    Optional<Movies> movies =MoviesService.findById(id);
	   try {
		   
	    if(movies.isPresent()) 
	    	return new ResponseEntity<>(movies.get(), HttpStatus.OK);
	    else 
	    	throw new Exception();
	    
	   } catch (Exception e) {
		   return new ResponseEntity<>("movie not found", HttpStatus.BAD_REQUEST);
	   }
	}
	
	@GetMapping("/Movies/search/{title}")
	public ResponseEntity<Object> searchMovies(@PathVariable("title") String title) {
	
		   try {

			List<Movies> movies =MoviesService.searchMoviesByTitle(title);
			ObjectMapper obj = new ObjectMapper();
			 
			 if(movies.size()>0) {
				 return new ResponseEntity<>(obj.writerWithDefaultPrettyPrinter().writeValueAsString(movies), HttpStatus.OK);
			 } else {
			    	throw new Exception();
		   	 }	
			
		   } catch (Exception e) {
				// TODO: handle exception
			   return new ResponseEntity<>("movie not found", HttpStatus.BAD_REQUEST);
		   }
		   
		
	}
	@GetMapping("/Movies")
	public ResponseEntity<Object> getMovies() {
	   List<Movies> movies =MoviesService.findAll();
	   try {

		   ObjectMapper obj = new ObjectMapper();
		   
		   if(movies.size()>0) 
		   	
		    	return new ResponseEntity<>(obj.writerWithDefaultPrettyPrinter().writeValueAsString(movies), HttpStatus.OK);
		    else
		    	throw new Exception();
		
	   } catch (Exception e) {
			// TODO: handle exception
		   return new ResponseEntity<>("movie not found", HttpStatus.BAD_REQUEST);
	   }
	    
	}

	
	@PatchMapping("/Movies/{id}")
	public ResponseEntity<Object> patchMovies(@PathVariable("id") int id, @RequestBody CreateMoviesInput movinput) {

		   try {
			Optional<Movies> mov = MoviesService.findById(id);
			Movies moviesupdated  = movinput.toMovies();
		    if(mov.isPresent()) {
		    	Movies movies= mov.get();
		    	movies.setId(moviesupdated.getId());
				movies.setTitle(moviesupdated.getTitle());
				movies.setDescription(moviesupdated.getDescription());
				movies.setRating(moviesupdated.getRating());
				movies.setImage(moviesupdated.getImage());
				movies.setCreated_at(moviesupdated.getCreated_at());
				movies.setUpdated_at(moviesupdated.getUpdated_at());

		        Movies movret = MoviesService.update(movies);
		        return new ResponseEntity<>(movret, HttpStatus.OK);
		    }
		    else {
		    	throw new Exception();
		    }
		   } catch (Exception e) {
			   return new ResponseEntity<>("movie not found", HttpStatus.BAD_REQUEST);
		   }
	}
	
	
	@DeleteMapping("/Movies/{id}")
	public ResponseEntity<Object> deleteMovies(@PathVariable("id") int id) {
	    Optional<Movies> movies =MoviesService.findById(id);
	   try {
		   
		    if(movies.isPresent()) {
		    	MoviesService.delete(id);
		    	return new ResponseEntity<>("Movie with id: "+id+" successfully deleted", HttpStatus.OK);
		    } else { 
		    	throw new Exception();
		    }
		    
	   } catch (Exception e) {
		   return new ResponseEntity<>("movie not found", HttpStatus.BAD_REQUEST);
	   }
	}


}
