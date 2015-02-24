import java.io.File;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatchProcessorMain {

	public static void main(String[] args) {
		//Batch batch;

		try {

			String fileName = args[0];

			File batchFile = new File(fileName);

			BatchParser batchF = new BatchParser();
			Batch batch = batchF.buildBatch(batchFile);
			executeBatch(batch);


		}

		catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

	public static void executeBatch(Batch batch) {
		Iterator it = batch.getCommands().entrySet().iterator();
		
		
		while (!batch.getCommandsQueue().isEmpty()) {
		Command cmd = batch.getCommandsQueue().poll();
		System.out.println(cmd.describe());
		cmd.execute(batch.getWorkingDirectory());
		}
		
		
		/*
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        Command cmd = (Command) pair.getValue();
	        //System.out.println(cmd.getWorkingDir());
	        
	       
	        System.out.println(cmd.describe());
	        //cmd.execute(batch.getWorkingDirectory());
	        it.remove(); // avoids a ConcurrentModificationException
		}*/
		
		
		
		

	}

}
