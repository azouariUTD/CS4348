import java.util.HashMap;
import java.util.Map;


public class Batch {
	String workingDir;
	Map commands = new HashMap();
	
	String getWorkingDirectory() {
		return workingDir;
	}
	
	
	Map getCommands() {
		return commands;
	}
	
	

}
