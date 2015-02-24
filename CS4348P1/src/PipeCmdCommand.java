import java.util.Map;

import org.w3c.dom.Element;


public class PipeCmdCommand extends Command  {
	String describe() {
		return "Command is";
	}
	void execute(String workingDir, Map<String, Command> map) {
		
	}
	void parse(Element elem) {
		
	}
	
	public String getCommandID() {
		return "hello";
	}
	
	public String getWorkingDir() {
		return "Not applicable";
	}
	
	public String getPath() {
		return null;
	}

}
