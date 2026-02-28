package com.kce.service;

import java.util.ArrayList;
import java.util.List;

import com.kce.entity.Booking;
import com.kce.entity.Customer;
import com.kce.entity.Movie;
import com.kce.entity.Show;

public class CustomerService {

	List<Customer> customers = new ArrayList<Customer>();
	List<Booking> bookings = new ArrayList<Booking>();

	public Customer viewProfile(int customerId) {
		for (Customer c : customers) { 
			if (c.getCustomerId() == customerId) {
				return c; 
				} 
			} 
		return null;
	}
	
	public boolean editProfile(int customerId,Customer customer) {
		for(Customer c : customers) {
			if(c.getCustomerId()==customerId) {
				c.setCustomerName(customer.getCustomerName());
				c.setHistory(customer.getHistory());
				c.setActiveStatus(customer.getActiveStatus());
				c.setPhoneNo(customer.getPhoneNo());
				return true;
			}
		}
		return false;
	}
	
	public List<Movie> browseMovies(){
		return new AdminService().viewAllMovies();
	}
	
	public List<Show> browseShows(){
		return new StaffService().viewShows();
	}
	
	public boolean bookTickets(Booking booking) {
		if(booking==null) {
			return false;
		}
		bookings.add(booking);
		return true;
	}
	
	public String viewHistory(int customerId) {
		for(Customer c : customers) {
			if(c.getCustomerId()==customerId) {
				return c.getHistory();
			}
		}
		return "No History";
	}
	
	public String viewBookingsStatus(int customerId) {
		for(Customer c : customers) {
			if(c.getCustomerId()==customerId) {
				return c.getActiveStatus();
			}
		}
		return "No History";
	}
}
