import java.io.File;
import java.io.FileInputStream;
public class BatchProcesorMain {
	
	public static void main (String[] args) {
		
		
		String fileName = args[0];
		
		try {
		File f = new File (fileName);
		FileInputStream fis = new FileInputStream(f);
		// TODO pass file to XML Parser returns array list
		// TODO pass array list to command builder case 1 without pipe case 2 with pipe
		// TODO case 1 without pipe create a new objects with the args
		// TODO case 2 with pipe create a new objects with the args.
		
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
