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
				System.out.println("Se estableció la conexión");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se estableció la conexión");
			e.printStackTrace();
		}finally {
			return connection;
		}
	}
	
}

//import com.sun.tools.javac.code.Attribute.Class;
//DriverManager permite crear una instancia de conexión, osea: retomar ese jar
//que ya habíamos incluído y generar un objeto para la conexión
//Conexión permite generar la conexión con la BD. El objeto conexión almacena el ciclo de 
//vida de esa sesión todo el tiempo que nos mantengamos conectados en esa sesión; cuando nos desconectamos se vuelve nulo
//Statement nos ayuda a traer datos con SELECT(sin parámetros)
//PrepareStatement nos permite recibir parámetros dentro de la cláusula WHERE
//ResultSet es básicamente una interfaz que almacena los resultados obtenidos de las consultas