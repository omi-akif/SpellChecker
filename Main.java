import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		
		Words words = null; //Initializing null variable
		
		String filePath = "/mnt/test/words.txt";
		
//		UserFile file = null;
//		
//		Scanner wordsOfUser;
		
		
		try {
			
			words = new Words();
			
			words.WordProcessor(words.fileIN);
	
		}
		
		catch(FileNotFoundException e){
		
			System.out.println("File cannot be found." + e.getMessage());
			
		}
		
		finally {
			
//			System.out.println(words.hashSet.size());
			
			System.out.println("The program has run!");
			
		}
//		
//		wordsOfUser =  file.userFile.useDelimiter("[^a-zA-Z]+");
//		
//		words = wordsOfUser.toString().toLowerCase();
	}
}
