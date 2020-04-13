export interface Movie {
  movieName: String;
  movieReleasedate: string;
  movieRating: String;
  movieGenre: String;
}

export enum Genres {
  Action = 'Action',
  Comedy = 'Comedy',
  Romance = 'Romance',
  SciFi = 'Sci-Fi',
  Drama = 'Drama',
  Documentery = 'Documentery',
  Thriller = 'Thriller',
  Sports = 'Sports',
}
