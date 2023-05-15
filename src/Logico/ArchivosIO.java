//Mehdi Tahrat&&David Hola
package Logico;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Esta classe es la que se encargara de alojar todas las funciones en nuestro programa que entran o sacan datos del programa localmente
 * @author DAME
 */


public class ArchivosIO {
	/**
	 * Funcion que obtiene y devuelve el tamaño del mapa (x,y)
	 * 	Lee el archivo CCP.bin , y devuelve el tamaño del mapa
	 * @return int[] 
	 */
	public static int[] leerTamanioMapa() {
		int aux[] = new int[2];
		leerCCP(null, aux, false);
		return aux;
	} 
	/**
	 * Funcion que  lee el archivo CCP.bin , y si el ultimo parametro es verdadero imprime el archivo por consola
	 * @param ArrayList<String> viruses_op
	 * @param int[] tamañoMapa_op
	 * @param boolean imprimir
	 */
	public static void leerCCP(ArrayList<String> viruses_op, int[] tamañoMapa_op, boolean imprimir) {
		//Esta declaracion nos permitira ejecutar esta funcion teniendo parametros nullos
		Optional<ArrayList<String> > op_v = Optional.ofNullable(viruses_op);
	
		ArrayList<String>  viruses = op_v.isPresent() ? op_v.get() : new ArrayList<String>();
		
		Optional<int[]> op_p = Optional.ofNullable(tamañoMapa_op);
		int[]  tamañoMapa = op_p.isPresent() ? op_p.get() : new int[2];
		
		
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
			
			leeCCP.close();

		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}
	}	
	/**
	 * Funcion que lee el archivo Ciudades.txt y lo guarda en el ArrayList ciudades
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> leerCiudades() {
		ArrayList<String> ciudades = new ArrayList<>();
		try {

			BufferedReader leer = new BufferedReader(new FileReader("Ciudades.txt"));
			String ln=" ";
			// Leemos el archivo linea a linea y guardamos cada linia en la siuiente
			// posicion del ArrayList ciudades
			while ((ln = leer.readLine()) != null) {
				ciudades.add(ln);
			}
		} catch (EOFException e) {
			System.out.println("fin del archiovo");
		} catch (IOException e) {
			System.out.println("Error I/O-Ciudades.txt-leerCiudades");
		}
		return ciudades;

	}
	/**
	 * Esta funcion lee el archivo "parametros.xml" y devuelve una lista con los componentes de este
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> leerParametros() {
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		leerXML("parametros.xml", parametros);
		return parametros;
	}
	/**
	 * Lee los datos de "parametros.xml"
	 * @param String xml
	 * @param ArrayList<Integer> parametros
	 */
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
			
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}


	/**
	 * lee los datos que hay en el elemento deseado
	 * @param Element doc
	 * @param String tag
	 * @return String
	 */
	public static String getTextValue(Element doc, String tag) {
		String value = null;
		NodeList nl;
		nl = doc.getElementsByTagName(tag);
		if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
			value = nl.item(0).getFirstChild().getNodeValue();
		}
		return value;
	}



}