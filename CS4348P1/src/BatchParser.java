import java.io.FileInputStream;
public class BatchParser {
	private FileInputStream fis;
	
	BatchParser (FileInputStream fis) {
		this.fis = fis;
		
		
	}
	
	public FileInputStream getFis() {
		return fis;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
