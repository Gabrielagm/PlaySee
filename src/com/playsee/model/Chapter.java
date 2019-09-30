package com.playsee.model;

import java.util.ArrayList;

import com.playsee.model.Chapter;
import com.playsee.model.Serie;

public class Chapter extends Movie {

	private int id;
	private int sesionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year,
			int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		this.sesionNumber = sessionNumber;
		//this.setSesionNumber(sessionNumber);
		this.serie = serie;
	}


	@Override
	public int getId() {
		return this.id;
	}
	
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public int getSesionNumber() {
		return sesionNumber;
	}
	public void setSesionNumber(int sesionNumber) {
		this.sesionNumber = sesionNumber;
	}
	
	//SÍ usará el método see()
	@Override
	public String toString() {

		return "\n :: CHAPTER ::"+
				"\nTitle: "+ getTitle()+
			   "\nGenre: "+getGenre()+
			   "\nCreator: "+getCreator()+
			   "\nDuration: "+getDuration()+
			   "\nYear: "+getYear()+
			   "\nChapter number: "+getSesionNumber();
	}
	
	public static ArrayList<Chapter>makeChapterList(Serie serie){
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		for (int i = 1; i <=5; i++) {
			chapters.add(new Chapter("Chapter: "+i, "Genre: "+i, "Creator: "+i, 45,(short)(2017+i), i, serie));
		}
		return chapters;
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter>chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
		
	}
	
}
