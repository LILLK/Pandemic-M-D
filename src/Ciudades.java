import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Mehdi Tahrat && David hola

public class Ciudades {
	String nombre;
	int idVirus;
	int[] posicion = new int[2];
	ArrayList<String> colindantes;
	boolean infectado;
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
	}
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	public void infectar() {
		if (this.nEnfermedades < 3)// no se puede infectar mas de 3
			this.nEnfermedades++;
		else
			System.out.println("nEnfermedades no puede ser mayor que 3 ");

	}

	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

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
			//extraer los datos de la String 
			nombre = lin.split(";")[0];
			idVirus = Integer.parseInt(lin.split(";")[1]);
			posicion[0] = Integer.parseInt(lin.split(";")[2].split(",")[0]);
			posicion[1] = Integer.parseInt(lin.split(";")[2].split(",")[1]);
			Ciudades ciudad = new Ciudades(nombre, posicion, idVirus);
			ciudad.colindantes = generarColindantes(ciudad.nombre);
			generarBrote(ciudad);
			Partida.ciudades.add(ciudad);
		}
		while (Partida.brotes < Parametros.brotesInicio ) {
			for (Ciudades ciudad : Partida.ciudades) {
				if (!ciudad.infectado)
					generarBrote(ciudad);
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

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarBrotes
	// infeca las ciudades dependiendo de los parametros y genera los brotes necesarias
	/////////////////////////////////////////////////////////////////////////////////////
	public static void generarBrote(Ciudades ciudad) {
		if (validarInfectar()) {//si se puede y le toca esta ciudad se infectara
			for (int i = 0; i < 3; i++) {
				ciudad.infectar();
			}
			ciudad.setInfectado(true);
			Partida.brotes++;
		} else
			ciudad.setInfectado(false);
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// - infectar
	// al generar la ciudad revisa si se tiene que infectar al principio de la partida
	/////////////////////////////////////////////////////////////////////////////////////
	public static boolean validarInfectar() {
		int random = (int) (Math.random() * 100);
		// si acierta con un 20% por cierto de posibilidad y hay menos brotes en partida
		// que los devidos
		if (Partida.brotes < Parametros.brotesInicio && random % 5 == 0)
			return true;
		else
			return false;
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
