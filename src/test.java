
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
		ArrayList<String> rolev = new ArrayList<String>();

		saveToXML("parametros.xml");
		readXML("parametros.xml",rolev);
		System.out.println(rolev);
		

	}

	public static boolean readXML(String xml,ArrayList<String> rolev) {
		Document dom;
		// Make an instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use the factory to take an instance of the document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parse using the builder to get the DOM mapping of the
			// XML file
			dom = db.parse(xml);
			Element doc = dom.getDocumentElement();
			String role1=" ";
			role1 = getTextValue(doc, "brotesTotal");
			if (role1 != null) {
				if (!role1.isEmpty())
					rolev.add(role1);
			}
			role1 = getTextValue(doc, "infeccionRonda");
			if (role1 != null) {
				if (!role1.isEmpty())
					rolev.add(role1);
			}
			role1 = getTextValue(doc, "porcentajeCura");
			if (role1 != null) {
				if (!role1.isEmpty())
					rolev.add(role1);
			}
			
			return true;

		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		System.out.println(rolev);
		return false;
	}


	public static void saveToXML(String xml) {
		Document dom;
		Element e = null;

		String role1 = "priemro";
		String role2 = "segu";
		String role3 = "ter";
		String role4 = "cuar";

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos el documento donde se va a escribir el xml
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.newDocument();

			Element rootEle = dom.createElement("parametros");
			// creamos un elemento nuevo en la instacia de documento creada.

			e = dom.createElement("brotesTotal");
			e.appendChild(dom.createTextNode(role1));
			rootEle.appendChild(e);

			e = dom.createElement("infeccionRonda");
			e.appendChild(dom.createTextNode(role2));
			rootEle.appendChild(e);

			e = dom.createElement("porcentajeCura");
			e.appendChild(dom.createTextNode(role3));
			rootEle.appendChild(e);

			dom.appendChild(rootEle);
			try {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				// send DOM to file
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
