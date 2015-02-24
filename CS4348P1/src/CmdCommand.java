import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CmdCommand extends Command {

	String id;
	String path;
	String args;
	String in;
	String out;
	Element elem;
	String inFile;
	String outFile;

	CmdCommand(Element elem) {
		this.elem = elem;

	}

	public String describe() {
		return "Command " + path;
	}

	public void execute(String workingDir, Map<String, Command> map) {
		List<String> command = new ArrayList<String>();
		
		/*
		
       
		try {
			Command cmd = map.get(out);
		} catch (cmd 
		*/
		
		Command cmd = map.get(out);
		Command cmd2 = map.get(in);
		
		if (cmd == null ) { System.out.println("error"); }

		try {
			outFile = cmd.getPath();
			
		} catch (NullPointerException e4) {
			System.err
					.println("Error Processing Batch Unable to locate OUT FileCommand with id:"
							+ out);
			e4.printStackTrace();
			System.exit(0);

		}
		try {
			inFile = cmd2.getPath();
			
		} catch (NullPointerException e3) {

		}

		command.add(path);
		
		if (!(args == null || args.isEmpty())) {
			StringTokenizer st = new StringTokenizer(args);
			while (st.hasMoreTokens()) {
				String tok = st.nextToken();
				
				command.add(tok);
			}
		}

		if (inFile != null) {
			command.add(inFile);

		}
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(command);
		builder.directory(new File(workingDir));

		builder.redirectError(new File("error.txt"));
		builder.redirectOutput(new File(outFile));

		Process process = null;

		try {
			process = builder.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Program terminated!");

	}

	public void parse(Element elem) {
		id = elem.getAttribute("id");
		path = elem.getAttribute("path");
		args = elem.getAttribute("args");
		in = elem.getAttribute("in");
		out = elem.getAttribute("out");

	}

	public String getCommandID() {
		return id;
	}

	public String getWorkingDir() {
		return "Not applicable";
	}

	public String getPath() {
		return path;
	}

}
