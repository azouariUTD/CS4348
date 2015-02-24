import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CmdCommand extends Command {
	
	String id = null;
	String path = null;
	String args= null;
	String in = null;
	String out = null;
	Element elem;
	String inFile;
	String outFile;
	CmdCommand(Element elem) {
		this.elem = elem;
		
	}
	
	public String describe() {
		return "Command " + path;
	}
	public void execute(String workingDir , Map<String, Command> map)  {
		List<String> command = new ArrayList<String>();
		Command cmd = map.get(out);
		outFile = cmd.getWorkingDir();
		//infile = quick access through the hashmap
		//Add in and out 
		//Get object with in id ==> file name
		System.out.println("This is==>in:" + in);
		command.add(path);
		command.add(args);
		command.add(in);
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

}
