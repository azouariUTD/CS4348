import org.w3c.dom.Element;
public abstract class  Command {
	
	abstract String describe();
	abstract void execute(String workingDir);
	abstract void parse(Element elem);
	
	
	

}
