import java.util.ArrayList;

//Mehdi Tahrat && David hola

public class Ciudades {
	String nombre;
	boolean infectado;
	int[] posicion = new int[2];
	int idVirus;
	int nEnfermedades;
	ArrayList<String> colindantes;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Ciudades(String nombre, boolean infectado, int[] posicion, int idVirus) {
		this.nombre = nombre;
		this.infectado = infectado;
		this.posicion = posicion;
		this.idVirus = idVirus;
		this.nEnfermedades = 0;
		colindantes = new ArrayList<String>();
	}
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	public void infectar() {
		this.nEnfermedades++;
	}

	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////
	// - generarCiudades
	// rellena la lista de ciudades
	/////////////////////////////////////////////////////////////////////////////////////
	public static void generarCiudades() {
		Partida.ciudades.clear();
		
		
		Ciudades ciudad = new Ciudades(null, false, null, 0);
		ciudad.colindantes = generarColindantes();
		Partida.ciudades.add(ciudad);
		System.out.println();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	// - generarColindantes
	// devuelve una lista con las colindandtes
	/////////////////////////////////////////////////////////////////////////////////////
	public static  ArrayList<String> generarColindantes() {
		ArrayList<String> colindantes;
		return colindantes = new ArrayList<String>();
	}
	
	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isInfectado() {
		return infectado;
	}

	public void setInfectado(boolean infectado) {
		this.infectado = infectado;
	}

	public int[] getPosicion() {
		return posicion;
	}

	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}

	public int getIdVirus() {
		return idVirus;
	}

	public void setIdVirus(int idVirus) {
		this.idVirus = idVirus;
	}

	public int getnBrotes() {
		return nEnfermedades;
	}

	public void setnBrotes(int nBrotes) {
		this.nEnfermedades = nBrotes;
	}
}
