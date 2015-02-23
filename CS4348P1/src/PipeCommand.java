import org.w3c.dom.Element;


public class PipeCommand extends Command  {
	String describe() {
		return "Command is";
	}
	void execute(String workingDir) {
		
	}
	void parse(Element elem) {
		
	}
	
	public String getCommandID() {
		return "hello";
	}
	
	public String getWorkingDir() {
		return "Not applicable";
	}

}
