package com.cg.movieapp.dao;

import java.util.List;

import com.cg.movieapp.dto.Movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@org.springframework.stereotype.Repository
public interface MovieRepository extends JpaRepository<Movies,Integer> {
    
    @Query(value = "SELECT * from Movies m WHERE m.movie_genre=?1", nativeQuery = true)
    List<Movies> findMoviesByGenre(String genre);
    
    @Query(value="SELECT * from Movies m WHERE m.movie_name=?1", nativeQuery = true)
    Movies findByName(String name);
}