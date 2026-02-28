package com.kce.main;

import java.util.List;
import java.util.Scanner;

import com.kce.entity.Booking;
import com.kce.entity.Customer;
import com.kce.entity.Movie;
import com.kce.entity.Show;
import com.kce.service.AdminService;
import com.kce.service.CustomerService;
import com.kce.service.StaffService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
        boolean check = true;
		System.out.print("__________________________________\n");
		System.out.print("\nWelcome to Movie Management System \n");
		System.out.print("__________________________________\n");
		
		System.out.print(" 1.Admin\n 2.Staff\n 3.Customer\n4.Exit\n");
		int chioce=sc.nextInt();
		sc.nextLine();
		while(check){
		switch (chioce) {
		case 1: {
			System.out.println("options for Admin:");
			System.out.println("1.View all movies and shows");
            System.out.println("2.Add new movie");
            System.out.println("3.Update movie details");
            System.out.println("4.Delete movie");
            System.out.println("5.View all bookings");
            System.out.println("6.Filter bookings by movie");
            System.out.println("7.Filter bookings by customer");
            System.out.println("8.Filter bookings by date");
            
            int option = sc.nextInt();
            sc.nextLine();
            AdminService adminService = new AdminService();
            switch (option) {
            
			case 1: {
				List<Movie> movies = adminService.viewAllMovies();
				if(movies != null) {
					for(Movie m:movies) {
						System.out.println("Movie name:" + m.getMovieName());
						System.out.println("Movie ID:" + m.getMovieId());
						System.out.println("Movie Genre:" + m.getGenre());
						System.out.println("Movie Statue:"+m.getMovieStatus());
					}
				}
				break;
			}
			case 2:{
				System.out.println("Enter Movie name:");
				String name = sc.nextLine();
				System.out.println("Enter Movie Genre:");
				String genre = sc.nextLine();
				System.out.println("Enter Movie Statue:");
				String status = sc.nextLine();
				adminService.addMovie(name,genre,status);
                System.out.println("Movie added");
                break;
			}
			case 3:{
				System.out.println("Enter Movie id to update:");
				int movieId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Movie name:");
				String name = sc.nextLine();
				System.out.println("Enter Movie Genre:");
				String genre = sc.nextLine();
				System.out.println("Enter Movie Statue:");
				String status = sc.nextLine();
				if(adminService.updateMovie(movieId,name,genre,status) == false ) {
					System.out.println("Movie id not found");
				}else {
					System.out.println("Movie updated Sussefully !");
				}	
				break;
			}
			case 4:{
				System.out.println("Enter Movie id to delete:");
				int movieId = sc.nextInt();
				sc.nextLine();
				if(adminService.deleteMovie(movieId)==true) {
					System.out.println("Movie deleted Sussefully !");
				}else {
					System.out.println("Movie id not found");
				}
				break;
			}
			case 5:{
				List<Booking> bookings = adminService.viewAllBookings();
				if(bookings != null) {
					for(Booking b:bookings) {
						System.out.println("Booking Id :" + b.getBookingId());
						System.out.println("Customer ID : " + b.getCustomerId());
						System.out.println("Show ID:" + b.getShowId());
						System.out.println("Statue:"+b.getBookingStatus());
						System.out.println("Date:"+b.getDate());
					}
				}
				break;
			}
			case 6:{
				System.out.println("Enter Booking id to search:");
				int bookingId = sc.nextInt();
				sc.nextLine();
				List<Booking> bookings= adminService.filterBookingsByMovie(bookingId);
				if(bookings != null) {
					for(Booking b:bookings) {
						System.out.println("Booking Id :" + b.getBookingId());
						System.out.println("Customer ID : " + b.getCustomerId());
						System.out.println("Show ID:" + b.getShowId());
						System.out.println("Statue:"+b.getBookingStatus());
						System.out.println("Date:"+b.getDate());
					}
				}
				break;
			}
			case 7:{
				System.out.println("Enter Customer id to search:");
				int customerId = sc.nextInt();
				sc.nextLine();
				List<Booking> bookings= adminService.filterBookingsByCustomer(customerId);
				if(bookings != null) {
					for(Booking b:bookings) {
						System.out.println("Booking Id :" + b.getBookingId());
						System.out.println("Customer ID : " + b.getCustomerId());
						System.out.println("Show ID:" + b.getShowId());
						System.out.println("Statue:"+b.getBookingStatus());
						System.out.println("Date:"+b.getDate());
					}
				}
				break;
			}
			case 8:{
				System.out.println("Enter Date to search:");
				String Date = sc.nextLine();
				List<Booking> bookings= adminService.filterBookingsByDate(Date);
				for(Booking b:bookings) {
					System.out.println("Booking Id :" + b.getBookingId());
					System.out.println("Customer ID : " + b.getCustomerId());
					System.out.println("Show ID:" + b.getShowId());
					System.out.println("Statue:"+b.getBookingStatus());
					System.out.println("Date:"+b.getDate());
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);	
			}
            break;
		}
		case 2:{
			System.out.println("Options for Staff:");
			System.out.println("1.Schedule a movie show");
            System.out.println("2.Update show details ");
            System.out.println("3.Cancel show");
            System.out.println("4.Delete movie");
            int option = sc.nextInt();
            sc.nextLine();
            StaffService staffService=new StaffService();
            switch (option) {
			case 1: {
				System.out.println("Enter staff id");
				int staffId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Movie id:");
				int movieId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter show Time:");
				Double showTime = sc.nextDouble();
				staffService.scheduleMovieShow(staffId,movieId,showTime);
                System.out.println("Show added");
                break;
			}
			case 2:{
				System.out.println("Enter show id to update:");
				int showId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter StaffId:");
				int staffId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Movie iD:");
				int movieId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Movie showTime:");
				Double showTime = sc.nextDouble();
				if(staffService.updateShow(showId, staffId,movieId,showTime) == false ) {
					System.out.println("show id not found");
				}else {
					System.out.println("show updated Sussefully !");
				}
				break;
			}
			case 3:{
				System.out.println("Enter Show id to be cancelled:");
				int showId = sc.nextInt();
				sc.nextLine();
				if(staffService.cancelShow(showId)==true) {
					System.out.println("Show cancelled Sussefully !");
				}else {
					System.out.println("show id not found");
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
            break;
		}
		case 3:{
			System.out.println("Options for Customer:");
			System.out.println("1.View profile");
            System.out.println("2.Edit profile");
            System.out.println("3.Browse available movies and shows ");
            System.out.println("4.Book tickets ");
            System.out.println("5.View booking history");
            System.out.println("6.View active bookings/balance");
            int option = sc.nextInt();
            CustomerService customerService=new CustomerService();
            switch (option) {
			case 1: {
				System.out.println("Enter your customer id to view your profile:");
				int customerId = sc.nextInt();
				sc.nextLine();
				Customer customer = customerService.viewProfile(customerId);
				System.out.println("Customer Name:"+customer.getCustomerName());
				System.out.println("Customer History:"+customer.getHistory());
				System.out.println("Customer Status"+customer.getActiveStatus());
				break;
			}
			case 2:{
				System.out.println("Enter your customer id to Edit your profile:");
				int customerId = sc.nextInt();
				sc.nextLine();
				Customer customer = new Customer();
				System.out.println("Enter Customer name:");
				customer.setCustomerName(sc.nextLine());
				System.out.println("Enter new history");
				customer.setHistory(sc.nextLine());
				System.out.println("Enter new Statue:");
				customer.setActiveStatus(sc.nextLine());
				System.out.println("Enter new phoneNo:");
				customer.setPhoneNo(sc.nextInt());
				if(customerService.editProfile(customerId, customer) == false ) {
					System.out.println("customer id not found");
				}else {
					System.out.println("Profile updated Sussefully !");
				}
				break;
			}
			case 3:{
				System.out.print("Available Movies\n");
				List<Movie> movies = customerService.browseMovies();
				if(movies != null) {
					for(Movie m:movies) {
						System.out.println("Movie name:" + m.getMovieName());
						System.out.println("Movie ID:" + m.getMovieId());
						System.out.println("Movie Genre:" + m.getGenre());
						System.out.println("Movie Statue:"+m.getMovieStatus());
					}
				}
				System.out.println("Available Shows\n");
				List<Show> shows = customerService.browseShows();
				if(shows !=null) {
					for(Show s:shows) {
						System.out.println("ShowID:"+s.getShowId());
						System.out.println("ShowTime:"+s.getShowTime());
					}
				}
				break;
			}
			case 4:{
				System.out.println("Enter details to Book ticket");
				Booking booking=new Booking();
				System.out.println("Enter customerId:");
				booking.setCustomerId(sc.nextInt());
				System.out.println("Enter showId:");
				booking.setShowId(sc.nextInt());
				System.out.println("Enter Status:");
				booking.setBookingStatus(sc.nextLine());
				System.out.println("Enter Date:");
				booking.setDate(sc.nextLine());
				customerService.bookTickets(booking);
				System.out.println("Ticket was Booked!");
				break;
			}
			case 5:{
				System.out.println("Enter customerId to view history:");
				int cutomerId = sc.nextInt();
				sc.nextLine();
				String history = customerService.viewHistory(cutomerId);
				System.out.println("History:"+history);
				break;
			}
			case 6:{
				System.out.println("Enter customerId to view Active Bookings:");
				int cutomerId = sc.nextInt();
				sc.nextLine();
				String history = customerService.viewBookingsStatus(cutomerId);
				System.out.println("Active Bookings:"+history);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
            break;
		}
		case 4:{
			check = false;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + chioce);
		}	
		}
		sc.close();
	}
}
