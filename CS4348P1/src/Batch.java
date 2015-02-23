import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Batch {
	private String workingDir;
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	Batch (String workingDir , Map<String, Command> commands) {
		this.workingDir = workingDir;
		this.commands = commands;
		
	}
	
	public String getWorkingDirectory() {
		return workingDir;
	}
	
	
	public Map<String, Command> getCommands() {
		return commands;
	}
	
	public void addCommand(Command command) {
		List<String> cmd = new ArrayList<String>();
		
		
		
	}
	

}
