import { Component, OnInit } from '@angular/core';
import { Movie } from '../models';
import { MoviedataService } from '../moviedata.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  allmovies: Movie[];
  constructor(private moviedata: MoviedataService) {}
  displayedColumns: string[] = ['index', 'name', 'releasedate', 'rating', 'genre'];
  ngOnInit(): void {
    this.getAllSongs();
  }
  getAllSongs() {
    this.moviedata.getMovies().subscribe((e) => {
      e.forEach(
        (s) =>
          (s.movieReleasedate = new Date(s.movieReleasedate).toDateString())
      );
      this.allmovies = e;
    });
  }
}
