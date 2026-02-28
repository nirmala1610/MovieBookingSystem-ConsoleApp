package com.kce.entity;

public class Movie {

	private int movieId;
	private String movieName;
	private String genre;
	private String movieStatus;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMovieStatus() {
		return movieStatus;
	}
	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}
	
}
