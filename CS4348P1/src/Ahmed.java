import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ahmed {

	public static void main(String[] args) {
		File f = new File(args[0]);

		try {
			FileInputStream fis = new FileInputStream(f);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(args[0]);

			//Element pnode = doc.getDocumentElement();
			NodeList nodes = doc.getElementsByTagName(tagname)
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
