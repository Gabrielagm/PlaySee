package com.playsee.model;

import java.util.Date;

public interface IVisualizable {

	Date startToSee(Date date);
	 //Este método captura el tiempo exacto de inicio de visualización
	 //dateI Es un objeto {@code Date}con el tiempo de inicio exacto.
	 //Devuelve la fecha y hora capturada
	
	
	void stopToSee(Date dateI, Date dateF);
	 //Este método captura el tiempo exacto de inicio y final de visualización
	 //dateI Es un objeto {@code Date}con el tiempo de inicio exacto.
	 //dateF Es un objeto {@code Date}con el tiempo final exacto.
	
}
