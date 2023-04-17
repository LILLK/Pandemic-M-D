import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
	public static ArrayList<String> leerCiudades() {
		ArrayList<String> ciudades = new ArrayList<>();
		try {

			BufferedReader leer = new BufferedReader(new FileReader("Ciudadestesteo.txt"));
			String ln=" ";
			// Leemos el archivo linea a linea y guardamos cada linia en la siuiente
			// posicion del ArrayList ciudades
			while ((ln = leer.readLine()) != null) {
				ciudades.add(ln);
			}
		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O-Ciudadestesteo.txt-leerCiudades");
		}
		return ciudades;

	}


	//////////////////////////////////////////////////////////////////////////////////////
	// - leerParametros
	// lee el archivo "parametros.xml" y devuelve una lista con los componentes de este
	/////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<Integer> leerParametros() {
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		leerXML("parametros.xml", parametros);
		return parametros;
	}

	/////////////////////////////////////////////////////////////////////
	// - leerXML
	// Lee los datos de "parametros.xml" 
	///////////////////////////////////////////////////////////////////////
	public static void leerXML(String xml, ArrayList<Integer> parametros) {
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
			
			aux = Integer.parseInt(getTextValue(doc, "brotesInicio"));
			if (aux != null) {
				parametros.add(aux);
			}
			aux = Integer.parseInt(getTextValue(doc, "nEnfermedades"));
			if (aux != null) {
				parametros.add(aux);
			}
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
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
	// - escribirXML
	// Escribe en xml los parametros en el archivo "parametros.xml"
	///////////////////////////////////////////////////////////////////////
	public static void escribirXML(String xml, int brotesTotal, int infeccionRonda, int porcentajeCura, int brotesInicio, int nEnfermedades) {
		Document dom;
		Element e = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos el documento donde se va a escribir el xml
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.newDocument();
			Element rootEle = dom.createElement("parametros");
			// creamos un elemento padre nuevo en la instacia de documento creada.
			e = dom.createElement("brotesTotal");
			e.appendChild(dom.createTextNode(Integer.toString(brotesTotal)));
			rootEle.appendChild(e);
			// dentro de este creamos los elementos hijos
			e = dom.createElement("infeccionRonda");
			e.appendChild(dom.createTextNode(Integer.toString(infeccionRonda)));
			rootEle.appendChild(e);
			e = dom.createElement("porcentajeCura");
			e.appendChild(dom.createTextNode(Integer.toString(porcentajeCura)));
			rootEle.appendChild(e);
			e = dom.createElement("brotesInicio");
			e.appendChild(dom.createTextNode(Integer.toString(brotesInicio)));
			rootEle.appendChild(e);
			e = dom.createElement("nEnfermedades");
			e.appendChild(dom.createTextNode(Integer.toString(nEnfermedades)));
			rootEle.appendChild(e);
			dom.appendChild(rootEle);
			try {
				// generamos la cabezera del documento xml
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				// Transofrmamos el documento virtual creado a un documento en el sistema.
				// "parametros.xml"
				tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(xml)));
			} catch (TransformerException te) {
				System.out.println(te.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		} catch (ParserConfigurationException pce) {
			System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		}
	}

	/////////////////////////////////////////////////////////////////////
	// - escribirParametros
	// guarda en parametros.xml los parametros del programa
	///////////////////////////////////////////////////////////////////////
	public static ArrayList<Integer> escribirParametros(int brotesTotal, int infeccionRonda, int porcentajeCura,
			int brotesInicio,int nEnfermedades) {
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		escribirXML("parametros.xml", brotesTotal, infeccionRonda, porcentajeCura, brotesInicio,nEnfermedades);
		// parametros (brotesTotal, infeccionRonda , porcentajeCura,brotesInicio,nEnfermedades)
		return parametros;
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

	/////////////////////////////////////////////////////////////////////
	// - nCiudades
	// devuelve el numero de ciudades que hay
	///////////////////////////////////////////////////////////////////////
	public static int nCiudades() {
		int lineas = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader("Ciudadestesteo.txt"))) {
			while (reader.readLine() != null) lineas++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineas;
	}
}