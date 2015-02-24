import java.util.Map;

import org.w3c.dom.Element;


public class FileCommand extends Command  {
	String id;
	String path;
	Element elem;
	
	FileCommand(Element elem) {
		this.elem = elem;
		
	}
	
	String describe() {
		return "File Command on file: " + path;
	}
	void execute(String workingDir, Map<String, Command> map) {
		
	}
	void parse(Element elem) {
		 id = elem.getAttribute("id");
		 path = elem.getAttribute("path");
		
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