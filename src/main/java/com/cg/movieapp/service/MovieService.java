package com.cg.movieapp.service;

import java.util.List;
import com.cg.movieapp.dto.Movies;
import com.cg.movieapp.exceptions.CustomException;

public interface MovieService {
    List<Movies> getAllMovies() throws CustomException;
    List<Movies> searchMoviesByGenre(String genre) throws CustomException;
    Movies addMovie(Movies movie) throws CustomException;
}