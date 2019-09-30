package com.playsee.model;


public abstract class Film {

		protected String title;
		protected String genre;
		protected String creator;
		protected int duration;
		protected short year;
		private boolean viewed;
		
		public Film() {}
		
		public Film(String title, String genre, String creator, int duration) {
			super();
			this.title = title;
			this.genre = genre;
			this.creator = creator;
			this.duration = duration;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public short getYear() {
			return year;
		}
		public void setYear(short year) {
			this.year = year;
		}
		public String isViewed() {
			String visto = "";
			if (viewed == true) {
				visto = "Yes";
			}else {
				visto = "No";
			}
			return visto;
		}
		public boolean getIsViewed() {
			return viewed;
		}
		public void setViewed(boolean viewed) {
			this.viewed = viewed;
		}
		
		//método see() MÉTODO ABSTRACTO
		//view() es un método abstracto obligatorio de implementar
		 
		public abstract void view();
		
}
