package com.kce.service;

import java.util.ArrayList;
import java.util.List;

import com.kce.entity.Booking;

import com.kce.entity.Movie;

public class AdminService {

	List<Movie> movies = new ArrayList<Movie>();
	List<Booking> bookings = new ArrayList<Booking>();

	public List<Movie> viewAllMovies(){
		return movies;
	}
	
	public void addMovie(String name,String genre,String status){
		Movie movie = new Movie();
		movie.setMovieId(movies.size()+1);
		movie.setMovieName(name);
		movie.setGenre(genre);
		movie.setMovieStatus(status);
		movies.add(movie);
	}
	
	public boolean updateMovie(int movieId,String name,String genre,String status) {
		for(Movie m : movies) {
			if(m.getMovieId() == movieId) {
				m.setMovieName(name);
				m.setGenre(genre);
				m.setMovieStatus(status);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteMovie(int movieId) {
		for(Movie m : movies) {
			if(m.getMovieId()==movieId) {
				movies.remove(m);
				return true;
			}
		}
		return false;
	}
	
	
	public List<Booking> viewAllBookings(){
		return bookings;
	}
	
	public List<Booking> filterBookingsByMovie(int bookingId){
		List<Booking> bookingsByMovie = new ArrayList<Booking>();
		for(Booking b : bookings) {
			if(bookingId==b.getBookingId()) {
				bookingsByMovie.add(b);
			}
		}
		return bookingsByMovie;
	}
	
	public List<Booking> filterBookingsByCustomer(int customerId){
		List<Booking> bookingsByCustomer = new ArrayList<Booking>();
		for(Booking b : bookings) {
			if(customerId==b.getCustomerId()) {
				bookingsByCustomer.add(b);
			}
		}
		return bookingsByCustomer;
	}
	
	public List<Booking> filterBookingsByDate(String date){
		List<Booking> bookingsByDate = new ArrayList<Booking>();
		for(Booking b : bookings) {
			if(date.equals(b.getDate())) {
				bookingsByDate.add(b);
			}
		}
		return bookingsByDate;
	}
}
