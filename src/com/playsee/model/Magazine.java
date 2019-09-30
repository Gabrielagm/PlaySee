package com.playsee.model;

import java.util.ArrayList;
import java.util.Date;


public class Magazine extends Publication{

	private int id;
	
	public Magazine(String title, Date editionDate, String editorial, String[]authors) {
		super(title, editionDate, editorial);
		setAuthors(authors);
	}

	public int getId() {
		return id;
	}
	
	
	public static ArrayList<Magazine> makeMagazinesList() {
		ArrayList<Magazine>magazines = new ArrayList<Magazine>();
		String[]authors = new String[3];
		for (int i = 0; i < authors.length; i++) {
			System.out.println("Autor magazine "+ (i+1));
		}
		for (int i = 1; i <= 5; i++) {
			magazines.add(new Magazine("Title "+i,new Date(),"Editorial "+i,authors));
		}
		return magazines;
	}
	
	
	@Override
	public String toString() {

		 String detailMagazine = "\n :: MAGAZINE ::"+
				 				"Title: "+ getTitle()+
				 				"\nEditorial: "+getEditorial()+
				 				"\nEdition date: "+getEditionDate()+
				 				"\nAuthors:";
		 for (int i = 0; i < getAuthors().length; i++) {
			detailMagazine += getAuthors()[i];
		}
		 
		 return detailMagazine;
	}

}
