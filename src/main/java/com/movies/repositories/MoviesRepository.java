package com.movies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movies.entities.Movies;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

}
