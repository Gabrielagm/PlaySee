package com.playsee.dao;

import static com.playsee.db.DataBase.ID_TMATERIALS;
import static com.playsee.db.DataBase.TMOVIE;
import static com.playsee.db.DataBase.TMOVIE_CREATOR;
import static com.playsee.db.DataBase.TMOVIE_DURATION;
import static com.playsee.db.DataBase.TMOVIE_GENRE;
import static com.playsee.db.DataBase.TMOVIE_ID;
import static com.playsee.db.DataBase.TMOVIE_TITLE;
import static com.playsee.db.DataBase.TMOVIE_YEAR;
import static com.playsee.db.DataBase.TUSER_IDUSUARIO;
import static com.playsee.db.DataBase.TVIEWED;
import static com.playsee.db.DataBase.TVIEWED_IDELEMENT;
import static com.playsee.db.DataBase.TVIEWED_IDMATERIAL;
import static com.playsee.db.DataBase.TVIEWED_IDUSUARIO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.playsee.model.Movie;
import com.playsee.db.IDBConection;

public interface MovieDAO extends IDBConection{

	//default, permite implementar el método en la interfaz
	
	default Movie setMovieViewed(Movie movie) {
		try(Connection connection = connectToDB()){
			Statement statement = connection.createStatement();
			String query = "INSERT INTO "+ TVIEWED+" ("
					+TVIEWED_IDMATERIAL+", "
					+TVIEWED_IDELEMENT+", "
					+TVIEWED_IDUSUARIO+")"+
					" VALUES("+
					ID_TMATERIALS[0]+", "+
					movie.getId()+", "+
					TUSER_IDUSUARIO+")";
			//para ejecutar esta sentencia uso "if"
			if (statement.executeUpdate(query)>0) {//lo que devuelve, es la cantidad de rows afectadas
				System.out.println("Se marcó en visto");
			}
			//lo que se valida es:si se afectó al menos 1 row, es >0; por lo tanto, quiere decir que sí se ejecutó la sentencia y sí se insertó el registro
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return movie;
	}
	
	default ArrayList<Movie>read(){
		ArrayList<Movie>movies = new ArrayList<Movie>();//arrayList de objetos Movie
		try(Connection connection = connectToDB()){
			String query = "SELECT * FROM "+ TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(rs.getString(TMOVIE_TITLE),
										rs.getString(TMOVIE_GENRE),
										rs.getString(TMOVIE_CREATOR),
										Integer.valueOf(rs.getString(TMOVIE_DURATION)),
										Short.valueOf(rs.getString(TMOVIE_YEAR)));
				//rs.getString(TMOVIE_ID);
				//movie.setId(rs.getString(TMOVIE_ID));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
		}catch(SQLException e){
			
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement,Connection connection,int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM "+TVIEWED+
					" WHERE "+TVIEWED_IDMATERIAL+"=?"+
					" AND "+TVIEWED_IDELEMENT+"=?"+
					" AND "+TVIEWED_IDUSUARIO+"=?";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO);
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
		}catch(Exception e){
			e.printStackTrace();
		}
		return viewed;
	}
	
}
