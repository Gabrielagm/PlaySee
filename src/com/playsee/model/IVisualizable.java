package com.playsee.model;

import java.util.Date;

public interface IVisualizable {

	Date startToSee(Date date);
	 //Este m�todo captura el tiempo exacto de inicio de visualizaci�n
	 //dateI Es un objeto {@code Date}con el tiempo de inicio exacto.
	 //Devuelve la fecha y hora capturada
	
	
	void stopToSee(Date dateI, Date dateF);
	 //Este m�todo captura el tiempo exacto de inicio y final de visualizaci�n
	 //dateI Es un objeto {@code Date}con el tiempo de inicio exacto.
	 //dateF Es un objeto {@code Date}con el tiempo final exacto.
	
}
