package com.movies.services;

import org.springframework.stereotype.Service;

import com.movies.entities.Movies;
import com.movies.repositories.MoviesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

	private final MoviesRepository MoviesRepository;

	public MoviesService(MoviesRepository MoviesRepository) {
		this.MoviesRepository = MoviesRepository;
	}

	public Movies create(Movies Movies) {
		return MoviesRepository.save(Movies);
	}

	public List<Movies> findAll() {
		List<Movies> Moviess = new ArrayList<>();
		MoviesRepository.findAll().forEach(Moviess::add);
		return Moviess;
	}

	public Optional<Movies> findById(int id) {
		return MoviesRepository.findById(id);
	}

	public Movies update(Movies MoviestoUpdate) {
		return MoviesRepository.save(MoviestoUpdate);
	}

	public void delete(int id) {
		MoviesRepository.deleteById(id);
	}

	public List<Movies> searchMoviesByTitle(String query) {

		List<Movies> mov = new ArrayList<>();
		MoviesRepository.searchMoviesByTitle(query).forEach(mov::add);
		return mov;
	}
}