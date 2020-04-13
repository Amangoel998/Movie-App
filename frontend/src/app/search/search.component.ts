import { Component, OnInit } from '@angular/core';
import { Genres, Movie } from '../models';
import { MoviedataService } from '../moviedata.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  allgenres: any;
  genre = new FormControl('');
  searchedmovies: Movie[];
  displayedColumns: string[] = ['index', 'name', 'releasedate', 'rating', 'genre'];
  constructor(private moviedata: MoviedataService) {
    this.genre = new FormControl('');
    this.allgenres = Object.keys(Genres);
  }

  ngOnInit(): void {
    this.genre = new FormControl('');
    this.allgenres = Object.keys(Genres);
    this.moviedata.getMovies().subscribe((e) => {
      e.forEach(s=>s.movieReleasedate = new Date(s.movieReleasedate).toDateString())
      this.searchedmovies = e
      });
  }
  searchMovie() {
    this.moviedata
      .getMoviesByGenre(Genres[this.genre.value])
      .subscribe((e) => (this.searchedmovies = e));
  }
}
