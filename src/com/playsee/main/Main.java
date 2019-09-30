package com.playsee.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.playsee.makereports.Report;
import com.playsee.model.Book;
import com.playsee.model.Chapter;
import com.playsee.model.Magazine;
import com.playsee.model.Movie;
import com.playsee.model.Serie;
import com.playsee.util.PlaySeeUtil;

public class Main {

	public static void main(String[] args) {
		showMenu();
		
		
	}

	public static void showMenu() {
		
		int exit = 0;
		
		do {
			System.out.println("WELCOME TO PLAYSEE");
			System.out.println();
			System.out.println("Select an Option:");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			
			Scanner sc = new Scanner(System.in);
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, 6);

				switch (response) {
				case 0:
					exit = 0;
					break;
				case 1:
					showMovies();
					break;
				case 2:
					showSeries();
					break;
				case 3:
					showBooks();
					break;
				case 4:
					showMagazines();
					break;
				case 5:
					makeReport();
					break;
				case 6:
					makeReport(new Date());
					break;

				default:
					System.out.println();
					System.out.println("........¡¡Select an option!!.......");
					System.out.println();
					break;
				}
	
		} while (exit != 0);
		
	}
	
	static ArrayList<Movie>movies2 = new ArrayList<Movie>();
	public static void showMovies() {
		movies2 = Movie.makeMoviesList();
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println("::MOVIES::");
			System.out.println();
			for (int i = 0; i < movies2.size(); i++) {
				System.out.println(i+1 + ". "+movies2.get(i).getTitle()+" It has been seen: "+movies2.get(i).isViewed());
			}
			System.out.println("0. Return to the main menu");
			System.out.println();
			//leer ingreso usuario
		
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, movies2.size());
			
			if (response == 0) {
				exit = 0;
				showMenu();
				break;
			}
			
			if (response > 0) {
				Movie movieSelected = movies2.get(response - 1);
				movieSelected.view();							
			}
			
		} while (exit != 0);
		
		
	}
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;	
		do {
			System.out.println();
			System.out.println("::SERIES::");
			System.out.println();
			for (int i = 0; i < series.size(); i++) {
				System.out.println(i+1 + " ."+series.get(i).getTitle()+" It has been seen: "+series.get(i).isViewed());
			}
			
			System.out.println("0. Return to the main menu");
			System.out.println();
			
			//Usuario ingresa datos
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, series.size());
			
			if (response == 0) {
				exit = 0;
				showMenu();
				
			}
			if (response > 0) {
				showChapters(series.get(response - 1).getChapters());
			}
			
		} while (exit != 0);
	}
	public static void showChapters(ArrayList<Chapter> chapterOfSerieSelected) {
		int exit = 1;
		do {
			System.out.println();
			System.out.println("::CHAPTERS::");
			System.out.println();
			for (int i = 0; i < chapterOfSerieSelected.size(); i++) {
				System.out.println(i+1 +" ."+ chapterOfSerieSelected.get(i).getTitle()+ "It has been seen: "+chapterOfSerieSelected.get(i).isViewed());
			}
			System.out.println("0. Return to the main menu");
			System.out.println();
			
			//Usuario ingresa datos
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, chapterOfSerieSelected.size());
			
			if (response == 0) {
				exit = 0;
				showSeries();
			}
			if (response > 0) {
				Chapter chapterSelected = chapterOfSerieSelected.get(response - 1);
				chapterSelected.view();
			}
			
			
		} while (exit != 0);
	}
	
	static ArrayList<Book>books = Book.makeBooksList();
	public static void showBooks() {	
		int exit = 1;
		do {
			System.out.println();
			System.out.println("::BOOKS::");
			System.out.println();
			for (int i = 0; i < books.size(); i++) {
				System.out.println(i+1 + " ."+books.get(i).getTitle()+ "It has been seen: "+ books.get(i).isReaded());
			}
			System.out.println();
			System.out.println("0. Return to the main menu");
			System.out.println();
			
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, books.size());
			if (response == 0) {
				exit = 0;
				showMenu();
			}
			if (response > 0) {
				Book bookSelected = books.get(response - 1);
				bookSelected.view();
			}
			
	
		} while (exit != 0);
	}
	public static void showMagazines() {
		ArrayList<Magazine>magazines = Magazine.makeMagazinesList();
		int exit = 0;
		do {
			System.out.println();
			System.out.println("::MAGAZINES::");
			System.out.println();
			for (int i = 0; i < magazines.size(); i++) {
				System.out.println(i+1 + " ."+magazines.get(i).getTitle());
			}
			System.out.println();
			System.out.println("0. Return to the menu");
			
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, 0);
			if (response == 0) {
				exit = 0;
				showMenu();
			}
		} while (exit != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("report");
		report.setExtension("txt");
		report.setTitle(":: LIST OF VIEWS ::");
		String contentReport = "";
		for (Movie movie : movies2) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString()+"\n";
			}
		}

		
		report.setContent(contentReport);
		report.makeReport();
		System.out.println("Report Generated");
		System.out.println();

	}
	public static void makeReport(Date date) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd-h-m-s-S");
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("report "+ dateString);
		report.setExtension("txt");
		report.setTitle(":: LIST OF VIEWS ::");
		
		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: "+dateString+"\n\n\n";

		
		for (Movie movie : movies2) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString()+"\n";
			}
		}

		
		report.setContent(contentReport);
		report.makeReport();
		
		System.out.println("Report Generated");
		System.out.println();
	
	}
	
	
}
