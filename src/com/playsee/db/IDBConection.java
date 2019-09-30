package com.playsee.db;

import static com.playsee.db.DataBase.DB;
import static com.playsee.db.DataBase.PASSWORD;
import static com.playsee.db.DataBase.URL;
import static com.playsee.db.DataBase.USER;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IDBConection {

	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
			
			if (connection != null) {
				System.out.println("Se estableci� la conexi�n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se estableci� la conexi�n");
			e.printStackTrace();
		}finally {
			return connection;
		}
	}
	
}

//import com.sun.tools.javac.code.Attribute.Class;
//DriverManager permite crear una instancia de conexi�n, osea: retomar ese jar
//que ya hab�amos inclu�do y generar un objeto para la conexi�n
//Conexi�n permite generar la conexi�n con la BD. El objeto conexi�n almacena el ciclo de 
//vida de esa sesi�n todo el tiempo que nos mantengamos conectados en esa sesi�n; cuando nos desconectamos se vuelve nulo
//Statement nos ayuda a traer datos con SELECT(sin par�metros)
//PrepareStatement nos permite recibir par�metros dentro de la cl�usula WHERE
//ResultSet es b�sicamente una interfaz que almacena los resultados obtenidos de las consultas