import java.util.Scanner;
import java.util.HashSet;

import java.io.File;
import java.io.FileNotFoundException;


public class Words{

	
	private Scanner fileIN;
	
	public HashSet<String> userDictionary = new HashSet<>();//Created a HashSet object
	
	public Words(String filePath) throws FileNotFoundException, NullPointerException{
		
		
		this.fileIN = new Scanner(new File(filePath));
		
	}
	

	
	public void WordProcessor() {
		
		while(this.fileIN.hasNext()){
			
			String tk = this.fileIN.next();
			
			tk = tk.toLowerCase();
			
			userDictionary.add(tk);
			
		}
		
	}
	
	
}
