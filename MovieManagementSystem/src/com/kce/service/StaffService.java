package com.kce.service;

import java.util.ArrayList;
import java.util.List;
import com.kce.entity.Show;

public class StaffService {

	List<Show> shows = new ArrayList<Show>();
	public List<Show> viewShows(){
		return shows;
	}
	public void scheduleMovieShow(int staffId,int movieId,Double showTime) {
		Show show=new Show();
		show.setShowId(shows.size()+1);
		show.setMovieId(movieId);
		show.setStaffId(staffId);
		show.setShowTime(showTime);
		shows.add(show);
	}
	
	public boolean updateShow(int showId,int staffId,int movieId,Double showTime) {
		for(Show s : shows) {
			if(s.getShowId() == showId) {
				s.setStaffId(staffId);
				s.setMovieId(movieId);
				s.setShowTime(showTime);
				return true;
			}
		}
		return false;
	}
	
	public boolean cancelShow(int showId) {
		for(Show s : shows) {
			if(s.getShowId()==showId) {
				shows.remove(s);
				return true;
			}
		}
		return false;
	}
}
