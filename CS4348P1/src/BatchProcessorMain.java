import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

	public static void executeBatch(Batch batch) throws InterruptedException, IOException {
		//Iterator it = batch.getCommands().entrySet().iterator();
		
		
		while (!batch.getCommandsQueue().isEmpty()) {
		Command cmd = batch.getCommandsQueue().poll();
		System.out.println(cmd.describe());
		cmd.execute(batch.getWorkingDirectory() , batch.getCommands());
		}
		
		System.out.println("Finished Batch");
		
		
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
