import java.util.Map;

import org.w3c.dom.Element;



public class WDCommand extends Command  {
	private String id;//
	private String path;
	private Element elem;
	
	WDCommand(Element elem) {
		this.elem = elem;
		
	}
	
	public String describe() {
		return "The working directory will be set to " + path;
	}
	void execute(String workingDir, Map<String, Command> map) {
		
	}
	public void parse(Element elem) {
		 id = elem.getAttribute("id");
		 path = elem.getAttribute("path");
		 
		
	}
	
	public String getWorkingDir() {
		return path;
	}
	
	public String getCommandID() {
		return id;
	}


}
