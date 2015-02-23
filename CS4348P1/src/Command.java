import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public abstract class  Command {
	private String workingDir;
	abstract String describe();
	abstract void execute(String workingDir);
	abstract void parse(Element elem);
	
	public void setWorkingDir(String WD) {
		workingDir = WD;
	}
	
	
	String getWorkingDir() {
		return workingDir;
	}
	

	
	
	

}
