import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BatchParser {
	private FileInputStream fis;
	
	BatchParser (FileInputStream file) {
		
		try {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		
		Element pnode = doc.getDocumentElement();
		NodeList nodes = pnode.getChildNodes();
		
		
		
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public FileInputStream getFis() {
		return fis;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
