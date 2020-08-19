CREATE TABLE Movies(
	Movie_Id INT Auto_Increment PRIMARY KEY,
	Movie_Name VARCHAR(50) Not NULL,
	Movie_Releasedate Date Not NUll,
	Movie_Rating DECIMAL(2,1) Not NULL,
	Movie_Genre Enum('Action','Comedy','Romance','Sci-Fi','Drama','Documentery','Thriller', 'Sports') Not NULL
);

INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Avengers Endgame', '2019-04-26', 9.1, 1);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Togo', '2019-12-20', 8.1, 6);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('3 Idiots', '2008-12-25', 8.4, 2);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Chak De India', '2007-08-10', 8.2, 8);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Joker', '2019-10-02', 8.5, 5);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Star Wars: The Rise of Skywalker', '2019-12-16', 6.7, 4);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Forest Gump', '1994-06-23', 8.8, 4);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Fight Club', '1999-10-15', 8.8, 7);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('The Shawshank Redemption', '1994-09-22', 9.3, 5);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('The Dark Knight', '2008-07-18', 9.0, 1);
INSERT INTO Movies(Movie_Name, Movie_Releasedate,Movie_Rating, Movie_Genre)
	VALUES('Dangal', '2016-12-23', 8.4, 8);