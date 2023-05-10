import java.util.Scanner;
import java.util.HashSet;

import java.io.File;
import java.io.FileNotFoundException;


public class Words extends UserFile{
	
	public Scanner fileIN;
	
	public HashSet<String> hashSet = new HashSet<>();//Created a HashSet object
	
	public Words(String filePath) throws FileNotFoundException{
		
		fileIN = new Scanner(new File(filePath));
		
	}
	
	public Words() throws FileNotFoundException {
		
		 fileIN = new Scanner(this.getInputFileNameFromUser());
		
	}
	
	
	public void WordProcessor(Scanner file) {
		
		while(file.hasNext()){
			
			String tk = file.next();
			
			tk = tk.toLowerCase();
			
			hashSet.add(tk);
			
		}
		
	}
	
	
	
}
