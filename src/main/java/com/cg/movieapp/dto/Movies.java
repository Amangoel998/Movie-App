package com.cg.movieapp.dto;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", updatable = false, nullable = false)
    private Integer movieId;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="movie_releasedate")
    private Date movieReleasedate;

    @Column(name="movie_rating")
    private Double movieRating;

    @Column(name="movie_genre")
    private String movieGenre;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieReleasedate() {
        return movieReleasedate;
    }

    public void setMovieReleasedate(Date movieReleasedate) {
        this.movieReleasedate = movieReleasedate;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Movies(String movieName, Date movieReleasedate, Double movieRating, String movieGenre) {
        super();
        this.movieName = movieName;
        this.movieReleasedate = movieReleasedate;
        this.movieRating = movieRating;
        this.movieGenre = movieGenre;
    }

	public Movies() {
	}

    @Override
    public String toString() {
        return "Movies [movieGenre=" + movieGenre + ", movieName=" + movieName
                + ", movieRating=" + movieRating + ", movieReleasedate=" + movieReleasedate + "]";
    }
}