import org.w3c.dom.Element;


public class CmdCommand extends Command {
	
	String id = null;
	String path = null;
	String args= null;
	String in = null;
	String out = null;
	Element elem;
	CmdCommand(Element elem) {
		this.elem = elem;
		
	}
	
	String describe() {
		return "Command " + path;
	}
	void execute(String workingDir) {
		
	}
	void parse(Element elem) {
		 id = elem.getAttribute("id");
		 path = elem.getAttribute("path");
		 args = elem.getAttribute("args");
		 in = elem.getAttribute("in");
		 out = elem.getAttribute("out");
		
	}

}
