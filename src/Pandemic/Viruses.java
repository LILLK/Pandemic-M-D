import java.util.ArrayList;

//Mehdi Tahrat && David hola

public class Viruses {
	int id;
	String nombre;
	String color;
	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Viruses(int idVirus) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.id = idVirus;
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = datos.get(idVirus).split(" ")[2];
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
	
	/////////////////////////////////////////////////////////////////////
	// - generarVirus
	// Crea los objetos de los virus y sus vacunas y las coloca en su debida lista 
	///////////////////////////////////////////////////////////////////////
		public static void generarVirus() {
			for (int i = 0; i < 4 ; i++) {
				Viruses Viruses = new Viruses(i);
				Vacunas vacuna = new Vacunas(i);
				Partida.vacunas.add(vacuna);
				Partida.viruses.add(Viruses);
			}
		}
	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

}
