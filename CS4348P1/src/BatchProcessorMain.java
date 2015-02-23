import java.io.File;

import java.io.FileInputStream;

public class BatchProcessorMain {

	public static void main(String[] args) {
		//Batch batch;

		try {

			String fileName = args[0];

			File batchFile = new File(fileName);

			BatchParser batchF = new BatchParser();
			Batch batch = batchF.buildBatch(batchFile);


		}

		catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

	public void executeBatch(Batch batch) {

	}

}
