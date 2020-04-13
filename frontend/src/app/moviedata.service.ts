import { Injectable, OnInit } from '@angular/core';
import { Movie } from './models';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class MoviedataService implements OnInit {
  public movies: Movie[];
  constructor(private http: HttpClient) {}
  private baseURL: string = '/api/';
  ngOnInit() {
    this.getMovies().subscribe((e) => (this.movies = e));
  }
  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseURL + 'allMovies');
  }
  addMovie(movie):Observable<Movie> {
    const payload = {
      responseType: 'application/json',
    };
    Object.assign(payload, movie);
    return this.http.post<Movie>(this.baseURL + 'add', payload);
  }
  getMoviesByGenre(genre):Observable<Movie[]> {
    const params = { genre: genre };
    const payload = {
      responsetype: 'application/json',
      params: params,
    }
    return this.http.get<Movie[]>(this.baseURL + 'movieByGenre', payload);
  }
}
