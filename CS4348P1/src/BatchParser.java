import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.Queue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class BatchParser {
	String workingDirectory;

	BatchParser() {

	}

	public Command buildCommand(Element elem) {

		String cmdName = elem.getNodeName();
		if ("wd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing wd");
			Command cmd = new WDCommand(elem);
			cmd.parse(elem);
			workingDirectory = cmd.getWorkingDir();
			return cmd;

			// System.out.println(cmd.describe() + " " );
		} else if ("file".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing file");
			Command cmd = new FileCommand(elem);
			cmd.parse(elem);
			return cmd;
			// System.out.println(cmd.describe() + " " );

		} else if ("cmd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing cmd");
			Command cmd = new CmdCommand(elem);
			cmd.parse(elem);
			return cmd;
			// System.out.println(cmd.describe() + " " );
		} else

			return null;
	}

	public Batch buildBatch(File batchFile) {
		Queue<Command> que = new java.util.LinkedList<Command>();
		String id;
		String workingDir = null;
		Map<String, Command> commands = new HashMap<String, Command>();
		Command cmd = null;
		

		try {
			FileInputStream fis = new FileInputStream(batchFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fis);

			Element pnode = doc.getDocumentElement();
			NodeList nodes = pnode.getChildNodes();
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					cmd = buildCommand(elem);
					id = cmd.getCommandID();

					try {
						que.add(cmd);
						commands.put(id, cmd);
					} catch (Exception e) {
					}

					;
				}
			}
			
			workingDir = workingDirectory;
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		Batch B = new Batch(workingDir, commands,que);
		

		return B;

	}

	private static void parseCommand(Element elem) throws ProcessException {
		String cmdName = elem.getNodeName();

		if (cmdName == null) {
			throw new ProcessException("unable to parse command from "
					+ elem.getTextContent());
		} else if ("wd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing wd");
			// Command cmd = WDCommand.parse(elem);
		} else if ("file".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing file");
			// Command cmd = FileCommand.parse(elem);
		} else if ("cmd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing cmd");
			// Command cmd = CmdCommand.parse(elem);
			// parseCmd(elem); // Example of parsing a cmd element
		} else if ("pipe".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing pipe");
			// Command cmd = PipeCommand.parse(elem);
		} else {
			throw new ProcessException("Unknown command " + cmdName + " from: "
					+ elem.getBaseURI());
		}
	}

	/**
	 * An example of parsing a CMD element THIS LOGIC BELONGS IN INDIVIDUAL
	 * Command subclasses
	 */
	public static void parseCmd(Element elem) throws ProcessException {
		String id = elem.getAttribute("id");
		if (id == null || id.isEmpty()) {
			throw new ProcessException("Missing ID in CMD Command");
		}
		System.out.println("ID: " + id);

		String path = elem.getAttribute("path");
		if (path == null || path.isEmpty()) {
			throw new ProcessException("Missing PATH in CMD Command");
		}
		System.out.println("Path: " + path);

		// Arguments must be passed to ProcessBuilder as a list of
		// individual strings.
		List<String> cmdArgs = new ArrayList<String>();
		String arg = elem.getAttribute("args");
		if (!(arg == null || arg.isEmpty())) {
			StringTokenizer st = new StringTokenizer(arg);
			while (st.hasMoreTokens()) {
				String tok = st.nextToken();
				cmdArgs.add(tok);
			}
		}
		for (String argi : cmdArgs) {
			System.out.println("Arg " + argi);
		}

		String inID = elem.getAttribute("in");
		if (!(inID == null || inID.isEmpty())) {
			System.out.println("inID: " + inID);
		}

		String outID = elem.getAttribute("out");
		if (!(outID == null || outID.isEmpty())) {
			System.out.println("outID: " + outID);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
