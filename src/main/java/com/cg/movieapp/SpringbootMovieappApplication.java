package com.cg.movieapp;

import java.util.HashSet;
import java.util.List;

import com.cg.movieapp.dto.Movies;
import com.cg.movieapp.exceptions.CustomException;
import com.cg.movieapp.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RequestMapping("/api")
class SpringbootMovieappApplication {

	@Autowired
	private MovieService service;

	private static final Logger logger = LoggerFactory.getLogger(SpringbootMovieappApplication.class);

	private static HashSet<String> genres;
	public static void main(String[] args) {
		genres = new HashSet<String>(8);
		genres.add("Action");
		genres.add("Comedy");
		genres.add("Romance");
		genres.add("Sci-Fi");
		genres.add("Drama");
		genres.add("Documentery");
		genres.add("Thriller");
		genres.add("Sports");
		SpringApplication.run(SpringbootMovieappApplication.class, args);
	}

	@GetMapping(value = "/allMovies", produces = "application/json")
	public ResponseEntity<List<Movies>> getAllMovies() {
		List<Movies> movies = service.getAllMovies();
		if (movies != null) {
			return new ResponseEntity<List<Movies>>(movies, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Movies> addMovie(@RequestBody Movies movie)throws CustomException {
		Movies newMovie = service.addMovie(movie);
		if (newMovie != null) {
			return new ResponseEntity<Movies>(newMovie, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/movieByGenre")
	public ResponseEntity<List<Movies>> getMovieByGenre(@RequestParam(name="genre", required = true) String genre) {
		if(!isValid(genre)){
			ResponseEntity<List<Movies>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			System.out.println(res);
			return res;
		}
		List<Movies> movies = service.searchMoviesByGenre(genre);
		if (movies != null) {
			return new ResponseEntity<List<Movies>>(movies, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private boolean isValid(String genre) {
		logger.debug(genre);
		return genres.contains(genre);
	}

}
