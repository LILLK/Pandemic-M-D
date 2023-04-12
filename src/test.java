
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

	public static void main(String[] args) {
		//parametros {brotesTotal, infeccionRonda , porcentajeCura}
		escribirParametros(10, 2, 15);
		ArrayList<Integer> parametros = leerParametros();
		System.out.println(parametros);
	}

	
	
	public static ArrayList<Integer> escribirParametros( int brotesTotal, int infeccionRonda, int porcentajeCura) {
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		escribirXML("parametros.xml",brotesTotal, infeccionRonda,porcentajeCura);
		//parametros (brotesTotal, infeccionRonda , porcentajeCura)
		return parametros;
	}


	public static String getTextValue(Element doc, String tag) {
		String value = null;
		NodeList nl;
		nl = doc.getElementsByTagName(tag);
		if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
			value = nl.item(0).getFirstChild().getNodeValue();
		}
		return value;
	}

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
	
	// - escribirXML	
	// Escribe en xml los parametros en el archivo parametros.xml
	public static void escribirXML(String xml, int brotesTotal, int infeccionRonda, int porcentajeCura) {
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
			//dentro de este creamos los elementos hijos 
			e = dom.createElement("infeccionRonda");
			e.appendChild(dom.createTextNode(Integer.toString(infeccionRonda)));
			rootEle.appendChild(e);
			e = dom.createElement("porcentajeCura");
			e.appendChild(dom.createTextNode(Integer.toString(porcentajeCura)));
			rootEle.appendChild(e);
			dom.appendChild(rootEle);
			try {
				//generamos la cabezera del documento xml
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				//Transofrmamos el documento virtual creado a un documento en el sistema. "parametros.xml" 
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

}
