package com.playsee.model;

import java.util.ArrayList;
import java.util.Date;

import com.playsee.model.Movie;
import com.playsee.dao.MovieDAO;

public class Movie extends Film implements IVisualizable, MovieDAO {


	private int id;
	private int timeViewed;
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		this.setYear(year);
		//setYear(year);
	}

	public Movie() {}
	
	public int getId() {
		return id;
	}
	//se quitó el método set porque lo generaré automáticamente
	//Lo agregó al hacer la parte de BD
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	//SÍ usará el método see();
	
	
	@Override
	public String toString() {

		return "\n :: MOVIE ::"+
			    "\nTitle: "+ getTitle()+
			    "\nGenre: "+getGenre()+
			   "\nYear: "+getYear()+
			   "\nCreator: "+getCreator()+
			   "\nDuration: "+getDuration();

	}
	
	@Override
	public Date startToSee(Date dateI) {
	
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));	
		}else {
			 setTimeViewed(0);
		}		
	}
	
	public static ArrayList<Movie> makeMoviesList(){
		Movie movie = new Movie();
		return movie.read();
	}

	@Override
	public void view() {

		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);//con este this , hago referencia a todo el componente como tal, osea a todo el objeto movie
		Date dateI = startToSee(new Date());
		
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..............................");
		}
		//Termino de ver la movie
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: "+ toString());
		System.out.println("Por: "+ getTimeViewed()+" miliseconds");
		
		
	}

}
