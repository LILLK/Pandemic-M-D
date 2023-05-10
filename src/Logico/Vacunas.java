package Logico;
import java.util.ArrayList;

//Mehdi Tahrat && David hola

public class Vacunas {

	String nombre;
	public String color;
	public int desarollo;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////	
	public Vacunas(int idVirus) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = datos.get(idVirus).split(" ")[2];
		this.desarollo = 0;
	}
	public Vacunas(int idVirus,int desarrollo,String color) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = color;
		this.desarollo = desarrollo;
	}

	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	/*
	* 
	*/
	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////
	// -vacunasDescubiertas
	// recorre todas las vacunas y devuelve verdaero si todas estan all 100% de desarollo
	/////////////////////////////////////////////////////////////////////////////////////
	public static boolean vacunasDescubiertas() {
		boolean aux=true;
		for (Vacunas vacuna : Partida.vacunas) {
			if (vacuna.desarollo!=100)
				aux=false;
		}
		return aux;	
	}
	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

}
