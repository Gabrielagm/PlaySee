package com.playsee.model;

import java.util.ArrayList;
import java.util.Date;

import com.playsee.model.Book;
import com.playsee.util.PlaySeeUtil;

public class Book extends Publication implements IVisualizable{

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page>pages;

	public Book(String title, Date editionDate, String editorial,String[]authors, ArrayList<Page>pages) {
		super(title, editionDate, editorial);
		setAuthors(authors);
		setPages(pages);// or: this.pages = pages;
	}
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String isReaded() {
		String viewed = "";
		if (readed == true) {
			viewed = "Yes";
		}else {
			viewed = "No";
		}
		return viewed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public int getTimeReaded() {
		return timeReaded;
	}
	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	@Override
	public Date startToSee(Date dateI) {
	
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeReaded(0);
		}
		
	}

	@Override
	public String toString() {

		String detailBook =    "\n :: BOOK ::"+
							   "\nTitle: "+ getTitle()+
							   "\nEditorial: "+getEditorial()+
							   "\nEdition date: "+getEditionDate()+
							   "\nAuthors:";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t"+ getAuthors()[i];
		}
		
		return detailBook;
	}

	
	public static ArrayList<Book>makeBooksList() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		String[]authors = new String[3];
		for (int i = 0; i < authors.length; i++) {
			authors[i] = "Autor "+(i+1);
		}
		
		ArrayList<Page>pages = new ArrayList<Book.Page>();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i+1;
			pages.add(new Book.Page(pagina, "Page Content "+pagina));
		}
		
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book: "+i, new Date(), "Editorial: "+i, authors,pages));
		}
		return books;
	}
	
	
	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());
		
		int i = 0;
		do {
			System.out.println("...................");
			System.out.println("Page "+ getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("...................");
			
			if (i != 0) {
				System.out.println("1. Return page");
			}
			System.out.println("2. Next page");
			System.out.println("0. Close book");
			System.out.println();
			
			int response = PlaySeeUtil.ValidateUserResponseMenu(0, 2);
			if (response == 2) {
				i++;
			}else if(response == 1){
				i--;
			}else if(response == 0){
				break;
			}
		} while (i < getPages().size());
		
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("You have read: "+ toString());
		System.out.println("By: "+getTimeReaded()+ " miliseconds");
		
	}
	
	
	public static class Page{
		private int id;
		private int number;
		private String content;
		
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
	}
	
}
