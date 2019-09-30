package com.playsee.util;

import java.util.Scanner;

public class PlaySeeUtil {

public static int ValidateUserResponseMenu(int min, int max){
		
		Scanner sc = new Scanner(System.in);
		//validar respuesta de usuario
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("You did not enter a valid option");
			System.out.println("Try again");
		}
		
		int response = sc.nextInt();
		
		//Validar rango de respuesta
		while(response < min || response > max) {
			System.out.println("You did not enter a valid option");
			System.out.println("Try again");
			
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("You did not enter a valid option");
				System.out.println("Try again");
			}
			response = sc.nextInt();
		}
		System.out.println("Your answer was: "+response+"\n");
		return response;
	}
	
}
