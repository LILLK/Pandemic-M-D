package Logico;

import Pandemic.JF_Marco;

public class ejecutar {
	
	public static void main(String[] args) {
		JF_Marco marco = new JF_Marco();
		boolean a =true;
	int resultado = a?0:1;

	}
	
	
	public static void imprimir() {
		System.out.println("----------------");

		for (Ciudades ciudad : Partida.ciudades) {
			System.out.println(ciudad.nombre +"-" + ciudad.nEnfermedades);
		}
		System.out.println("----------------");

		for (Vacunas string : Partida.vacunas) {
			System.out.println(string.nombre + " " + string.desarollo + "%"+" "+string.color );
		}
		System.out.println("----------------");
		
		System.out.println(Partida.Puntuacion);
		System.out.println(Partida.brotes + " / "+ Parametros.brotesTotal);
		
	}

}
