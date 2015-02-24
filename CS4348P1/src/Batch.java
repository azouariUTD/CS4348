import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Batch {
	private String workingDir;
	private Map<String, Command> commands = new HashMap<String, Command>();
	Queue<Command> que;
	
	Batch (String workingDir , Map<String, Command> commands, Queue<Command> que) {
		this.workingDir = workingDir;
		this.commands = commands;
		this.que = que;
		
	}
	
	public String getWorkingDirectory() {
		return workingDir;
	}
	
	public Queue<Command> getCommandsQueue() {
		return que;
	}
	public Map<String, Command> getCommands() {
		return commands;
	}
	
	public void addCommand(Command command) {
		List<String> cmd = new ArrayList<String>();
		//Set all the in out etc....
		
		
	}
	

}
