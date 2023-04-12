import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//Mehdi Tahrat&&David Hola


 //Esta classe es la que se encargara de alojar todas las funciones en nuestro programa que entran o sacan datos del programa
 
public class ArchivosIO {
	//////////////////////////////////////////////////////////////////////////////////////
	// - leerTamanioMapa
	// lee el archivo CCP.bin , y devuelve el tamaño del mapa
	/////////////////////////////////////////////////////////////////////////////////////
	public static int[] leerTamanioMapa() {
		int aux[] = new int[2];
		leerCCP(null, aux, false);
		return aux;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - leerCCP
	// lee el archivo CCP.bin , y si el ultimo parametro es verdadero imprime el
	////////////////////////////////////////////////////////////////////////////////////// archivo
	/////////////////////////////////////////////////////////////////////////////////////
	public static void leerCCP(ArrayList<String> viruses, int[] tamañoMapa, boolean imprimir) {
		String linea = "";
		try {
			DataInputStream leeCCP = new DataInputStream(new FileInputStream("CCP.bin"));
			for (String c : leeCCP.readUTF().split(":")) {
				if (imprimir)
					System.out.println("txt: " + c);
			}
			for (int i = 0; i < 4; i++) {
				linea = Integer.toString(leeCCP.readInt());
				linea = linea + " " + leeCCP.readUTF() + " " + leeCCP.readUTF();
				if (imprimir)
					System.out.println(linea);
				viruses.add(linea);
			}
			if (imprimir) {
				System.out.println("\nCords");
				System.out.println(tamañoMapa[0] = leeCCP.readInt());
				System.out.println(tamañoMapa[1] = leeCCP.readInt());
			} else {
				tamañoMapa[0] = leeCCP.readInt();
				tamañoMapa[1] = leeCCP.readInt();
			}

		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}
	}

	/////////////////////////////////////////////////////////////////////
	// - leerCiudades
	// lee el archivo ciudades.txt y lo guarda en el ArrayList ciudades
	///////////////////////////////////////////////////////////////////////
	public static void leerCiudades(ArrayList<String> ciudades) {

		try {

			BufferedReader leer = new BufferedReader(new FileReader("Ciudades.txt"));
			String linea;
			// Leemos el archivo linea a linea y guardamos cada linia en la siuiente
			// posicion del ArrayList ciudades
			while ((linea = leer.readLine()) != null) {
				ciudades.add(linea);
			}

		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}

	}

	/////////////////////////////////////////////////////////////////////
	// - leerParametros
	// lee el archivo "parametros.bin" y lo guarda en los atributos del objeto
	///////////////////////////////////////////////////////////////////////
	public static ArrayList<Integer> leerParametros() {
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		leerXML("parametros.xml", parametros);
		return parametros;

	}

	/////////////////////////////////////////////////////////////////////
	// - leerXML
	// lee en xml 
	///////////////////////////////////////////////////////////////////////
	public static boolean leerXML(String xml, ArrayList<Integer> parametros) {
		Integer aux = null;
		Document dom;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(xml);
			Element doc = dom.getDocumentElement();
			aux = Integer.parseInt(getTextValue(doc, "brotesTotal"));
			if (aux != null) {
					parametros.add(aux);
			}
			aux = Integer.parseInt(getTextValue(doc, "infeccionRonda"));
			if (aux != null) {
					parametros.add(aux);
			}
			aux = Integer.parseInt(getTextValue(doc, "porcentajeCura"));
			if (aux != null) {
					parametros.add(aux);
			}
			return true;
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return false;
	}
	

	/////////////////////////////////////////////////////////////////////
	// - getTextValue
	// lee los datos que hay en el elemento deseado  
	///////////////////////////////////////////////////////////////////////
	public static String getTextValue(Element doc, String tag) {
		String value = null;
		NodeList nl;
		nl = doc.getElementsByTagName(tag);
		if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
			value = nl.item(0).getFirstChild().getNodeValue();
		}
		return value;
	}


	/////////////////////////////////////////////////////////////////////
	// - leerRanking
	// lee el archivo " " y lo guarda en el ArrayList ranking
	///////////////////////////////////////////////////////////////////////
	public static void leerRanking(ArrayList<String> ranking) {

		try {

			BufferedReader leer = new BufferedReader(new FileReader("idk.txt"));
			String linea;
			// Leemos el archivo linea a linea y guardamos cada linia en la siuiente
			// posicion del ArrayList ranking
			while ((linea = leer.readLine()) != null) {
				ranking.add(linea);
			}

		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}

	}

	/////////////////////////////////////////////////////////////////////
	// - leerViruses
	// lee el archivo CCP.bin y lo guarda los viruses en el ArrayList viruses
	///////////////////////////////////////////////////////////////////////
	public static void leerViruses(ArrayList<String> viruses) {
		leerCCP(viruses, null, false);
	}

	/////////////////////////////////////////////////////////////////////
	// - leerCargarDatos
	// lee el archivo " " y lo guarda en el ArrayList datos
	///////////////////////////////////////////////////////////////////////
	public static void leerCargarDatos(ArrayList<String> datos) {
		String archivo = "Archivo" + Jugador.getNombre() + ".bin";

		try {

			BufferedReader leer = new BufferedReader(new FileReader(archivo));
			String linea;
			// Leemos el archivo linea a linea y guardamos cada linia en la siuiente
			// posicion del ArrayList datos
			while ((linea = leer.readLine()) != null) {
				datos.add(linea);
			}

		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}

	}

	/////////////////////////////////////////////////////////////////////
	// - borrarDatos
	// borra la partida guardada del jugador
	///////////////////////////////////////////////////////////////////////
	public static void borrarDatos() {
		String archivo = "Archivo" + Jugador.getNombre() + ".bin";
		File fichero = new File(archivo);
		fichero.delete();
	}

	/////////////////////////////////////////////////////////////////////
	// - escribirDatos
	// Coge el estado de la partida y la guarada en un archivo especializado
	///////////////////////////////////////////////////////////////////////
	public static void escribirDatos() {
		String archivo = "Archivo" + Jugador.getNombre() + ".bin";

		try {
			DataOutputStream escribeFichero = new DataOutputStream(new FileOutputStream(archivo));

			/*
			 * to do
			 */
			escribeFichero.writeInt(Partida.Puntuacion);
			escribeFichero.close();
		} catch (IOException e) {
			System.out.println("Error E/S");

		}
	}

	/////////////////////////////////////////////////////////////////////
	// - escribirParametros
	// Guarda los parametros en parametros.bin
	///////////////////////////////////////////////////////////////////////
	public static void escribirParametros(Parametros parametro) {

		try {
			DataOutputStream escribeFichero = new DataOutputStream(new FileOutputStream("parametros.xml"));
			escribeFichero.writeInt(parametro.brotesTotal);
			escribeFichero.writeInt(parametro.infeccionRonda);
			escribeFichero.writeInt(parametro.porcentajeCura);

			escribeFichero.close();
		} catch (IOException e) {
			System.out.println("Error E/S");

		}
	}

	/////////////////////////////////////////////////////////////////////
	// - gurardarRanking
	// Guarda las puntuaciones de los usuarios en " "
	///////////////////////////////////////////////////////////////////////
	public static void gurardarRanking(int puntuacion) {

		try {
			PrintWriter pw = new PrintWriter(new FileWriter("idk.txt", true));
			/*
			 * to do
			 */
			pw.write(Jugador.usuario);
			pw.write(puntuacion);

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}