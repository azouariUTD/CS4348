import java.io.IOException;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public abstract class  Command {
	
	abstract String describe();
	abstract void execute(String workingDir, Map<String, Command> map) throws InterruptedException, IOException;
	abstract void parse(Element elem);
	abstract String getCommandID();
	abstract String getWorkingDir();
	abstract String getPath();
	
	//abstract void set

}
