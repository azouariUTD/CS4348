import java.util.HashMap;
import java.util.Map;


public class Batch {
	String workingDir;
	Map<String, Command> commands = new HashMap<String, Command>();
	
	String getWorkingDirectory() {
		return workingDir;
	}
	
	
	Map<String, Command> getCommands() {
		return commands;
	}
	
	void addCommand(Command command) {
		
	}
	

}
