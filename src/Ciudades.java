import java.util.ArrayList;
import java.util.Arrays;

//Mehdi Tahrat && David hola

public class Ciudades {
	String nombre;
	int idVirus;
	int[] posicion = new int[2];
	ArrayList<String> colindantes;
	boolean brote;
	int nEnfermedades;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Ciudades(String nombre, int[] posicion, int idVirus) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.idVirus = idVirus;
		colindantes = new ArrayList<String>();
		this.nEnfermedades = 0;
		this.brote = false;
		this.colindantes = generarColindantes(this.nombre);
	}
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	////////////////////////////////////
	// -Infectar
	//
	////////////////////////////////////
	public void infectar() {
		System.out.println("////////////////////////////////////");
		System.out.println("infecto:  " + this.nombre);
		for (String string : colindantes) {
			System.out.println("colindante: " + string);
		}
		System.out.println("////////////////////////////////////");

		if (this.nEnfermedades < 3) {// si es mas pequeño de 3
			System.out.println("no tiene brote");
			this.nEnfermedades++;
			// si tiene 3 enfermedades y no tiene un brote, se generara uno
		} else if (this.nEnfermedades == 3 && !this.brote) {
			System.out.println("brote:" + Partida.brotes);
			this.brote = true;
			Partida.brotes++;
			// recorremos las ciudades colindantes a esta
			for (String ciudadColindante : this.colindantes) {
				System.out.println("ciudad: " + ciudadColindante);
				// y por cada una de ellas ejecutamos este metodo
				Partida.ciudades.get(getIdXnombre(ciudadColindante)).infectar();
			}
		} else if (this.brote) {
			for (String ciudadColindante : this.colindantes) {
				// y por cada una de ellas ejecutamos este metodo
				Partida.ciudades.get(getIdXnombre(ciudadColindante)).infectar();
			}
		}
	}

	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	// - nEnfermedadesPartida
	// recorre la lista de ciudades y cuenta cuantas enfermedades hay
	/////////////////////////////////////////////////////////////////////////////////////
	public static void infectarColindantes() {

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - nEnfermedadesPartida
	// recorre la lista de ciudades y cuenta cuantas enfermedades hay
	/////////////////////////////////////////////////////////////////////////////////////
	public static int nEnfermedadesPartida() {
		int resultado = 0;
		for (Ciudades city : Partida.ciudades) {
			resultado += city.nEnfermedades;
		}
		return resultado;

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - getIdXnombre
	// devuelve la posicion en la lista segun el nombre
	/////////////////////////////////////////////////////////////////////////////////////
	public static int getIdXnombre(String nombre) {
		int aux = 0;
		// recorre todas las ciudades
		for (int i = 0; i < Partida.ciudades.size(); i++) {
			// si encuentra el nombre con la ciudad enviada
			if (Partida.ciudades.get(i).nombre.contains(nombre))
				aux = i;
		}
		return aux;// devuelve su posicion en la lista
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarCiudades
	// rellena la lista de Partida.ciudades
	/////////////////////////////////////////////////////////////////////////////////////
	public static void generarCiudades() {
		String nombre;
		int idVirus;
		int[] posicion = new int[2];
		ArrayList<String> listaCiudades = ArchivosIO.leerCiudades();
		// por cada linea se recogen los datos y pasan a ser los constructores de
		// ciudades
		for (String lin : listaCiudades) {
			// lin = " nombre;idVirus;pos1,pos2;colindante1,colindante2...; "
			// extraer los datos de la String
			nombre = lin.split(";")[0];
			idVirus = Integer.parseInt(lin.split(";")[1]);
			posicion[0] = Integer.parseInt(lin.split(";")[2].split(",")[0]);
			posicion[1] = Integer.parseInt(lin.split(";")[2].split(",")[1]);
			// Construccion de todas las ciudades
			Ciudades ciudad = new Ciudades(nombre, posicion, idVirus);
			// Se añade en la lista global Partida.ciudades
			Partida.ciudades.add(ciudad);
		}

		// Mientras haya menos brotes que los necesarios para empezar
		while (Partida.brotes < Parametros.brotesInicio) {
			// busca una ciudad aleatoria y la infecta 4 veces para generar un brote
			int random = (int) (Math.random() * Partida.ciudades.size());
			for (int i = 0; i < 4; i++) {
				Partida.ciudades.get(random).infectar();
			}

		}

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarColindantes
	// devuelve una lista con las colindandtes
	/////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<String> generarColindantes(String nombre) {
		ArrayList<String> colindantes = null;
		ArrayList<String> listaCiudades = ArchivosIO.leerCiudades();
		for (String lin : listaCiudades) {
			// lin = " nombre;idVirus;pos1,pos2;colindante1,colindante2...; "
			if (lin.split(";")[0].equals(nombre)) {// si encuentra el nombre enviado lee las colindantes
				colindantes = new ArrayList<String>(Arrays.asList(lin.split(";")[3].split(",")));
			}
		}
		return colindantes;
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

	public boolean isBrote() {
		return brote;
	}

	public void setBrote(boolean brote) {
		this.brote = brote;
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
