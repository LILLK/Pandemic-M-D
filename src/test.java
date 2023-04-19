
import java.io.FileOutputStream;
import java.io.IOException;
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

public class test {

	public static void mai2n(String[] args) {
		
		
		ArrayList<ArrayList> listas = new ArrayList<ArrayList>();

		ArrayList<String> listaCompra = new ArrayList<String>();
		ArrayList<String> listaCoches = new ArrayList<String>();
		ArrayList<String> listaCasas = new ArrayList<String>();


		
		listaCompra.add("manzana");
		listaCompra.add("pera");
		listaCompra.add("leceh");
		listaCompra.add("pan");
		listaCoches.add("coche 1");
		listaCasas.add("casa 1");
		
		listas.add(listaCoches);
		listas.add(listaCasas);
		listas.add(listaCompra);
		
		System.out.println(listaCompra);
		System.out.println(listaCompra.contains("pera"));
		System.out.println(listaCompra.set(1, "naranja"));
		System.out.println(listaCompra);
		System.out.println(listaCompra.contains("pera"));

		
		
		System.out.println(listas.get(0).get(0));
		
		
		
		for (ArrayList aux : listas) {
			
			
			System.out.println(aux.get(0));
		}
		
		
	}




	

}
