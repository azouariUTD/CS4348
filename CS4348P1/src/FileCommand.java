import org.w3c.dom.Element;


public class FileCommand extends Command  {
	String id;//
	String path;
	Element elem;
	FileCommand(Element elem) {
		this.elem = elem;
		
	}
	
	String describe() {
		return "File Command on file: " + path;
	}
	void execute(String workingDir) {
		
	}
	void parse(Element elem) {
		 id = elem.getAttribute("id");
		 path = elem.getAttribute("path");
		
	}

}