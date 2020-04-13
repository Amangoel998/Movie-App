package com.cg.movieapp.service;

import java.util.List;

import com.cg.movieapp.dao.MovieRepository;
import com.cg.movieapp.dto.Movies;
import com.cg.movieapp.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository repository;

    @Autowired
    MovieServiceImpl(MovieRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Movies> getAllMovies() throws CustomException {
        return repository.findAll();
    }

    @Override
    public List<Movies> searchMoviesByGenre(String genre) throws CustomException {
        return repository.findMoviesByGenre(genre);
    }

    @Override
    public Movies addMovie(Movies movie) throws CustomException {
        return repository.save(movie);
    }

}