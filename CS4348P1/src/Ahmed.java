//This is what I do all my testing!

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

;

public class Ahmed {

	public static void main(String[] args) {
		File f = new File(args[0]);
		
		//Queue<TreeNode> que = new java.util.LinkedList<TreeNode>();

		try {
			FileInputStream fis = new FileInputStream(f);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("work/batch4.xml");

			Element pnode = doc.getDocumentElement();
			NodeList nodes = pnode.getChildNodes();
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					System.out.print(elem.getNodeName() + " ");
					System.out.println("id=" + elem.getAttribute("id")
							+ " path=" + elem.getAttribute("path") 
							+ " agrs=" + elem.getAttribute("args")
							+ " in=" + elem.getAttribute("in")
							+ " out=" + elem.getAttribute("out")

					);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
