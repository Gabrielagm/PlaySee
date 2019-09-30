package com.playsee.db;

public class DataBase {

	//esta clase tendrá todos las constantes que tengo en mi BD
	//para que siempre coincida con lo que yo esté tratando de consultar
		public static final String URL 			= "jdbc:mysql://localhost:33065/";
		public static final String DB 			= "playsee";
		public static final String USER 		= "root";
		public static final String PASSWORD 	= "toor";
		
		public static final String TMOVIE 				= "movie";
		public static final String TMOVIE_ID 			= "id";
		public static final String TMOVIE_TITLE 		= "title";
		public static final String TMOVIE_GENRE 		= "genre";
		public static final String TMOVIE_CREATOR 		= "creator";
		public static final String TMOVIE_DURATION 		= "duration";
		public static final String TMOVIE_YEAR 			= "year";
		
		public static final String TMATERIAL 			= "material";
		public static final int[] ID_TMATERIALS 		= {1,2,3,4,5};
		
		public static final String TUSER 				= "user";
		public static final int TUSER_IDUSUARIO 		= 1;
		
		public static final String TVIEWED 				= "viewed";
		public static final String TVIEWED_IDMATERIAL 	= "id_material";
		public static final String TVIEWED_IDELEMENT 	= "id_element";
		public static final String TVIEWED_IDUSUARIO 	= "id_user";
	
}
