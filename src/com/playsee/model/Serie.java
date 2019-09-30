package com.playsee.model;

import java.util.ArrayList;


public class Serie extends Film{

	private int id;
	private int sesionQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration,
			int sessionQuantity) {
		super(title, genre, creator, duration);
		this.sesionQuantity = sessionQuantity;
		
	}
	
	public int getId() {
		return id;
	}
	public int getSesionQuantity() {
		return sesionQuantity;
	}
	public void setSesionQuantity(int sesionQuantity) {
		this.sesionQuantity = sesionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {

		return "\n :: SERIE ::"+
				"\nTitle: "+ getTitle()+
			   "\nGenre: "+getGenre()+
			   "\nCreator: "+getCreator()+
			   "\nDuration: "+getDuration()+
			   "\nSeason: "+getSesionQuantity();
	}
	
	public static ArrayList<Serie> makeSeriesList(){
		ArrayList<Serie> series = new ArrayList<Serie>();
		for (int i = 1; i <=5; i++) {
			new Serie("Serie: "+i,"Genre: "+i,"Creator: "+i,120,5+i);
		}
		return series;
	}
	
	@Override
	public void view() {
		setViewed(true);
		
	}

}
