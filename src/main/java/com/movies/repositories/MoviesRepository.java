package com.movies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movies.entities.Movies;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
	
	@Query(value="select m.* from movies m where  m.title LIKE CONCAT('%',:query,'%')", nativeQuery = true)
	List<Movies> searchMoviesByTitle(String query);

}
