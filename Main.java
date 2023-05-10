import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		
		Words words = null; //Initializing null variable
		
		String filePath = "/mnt/test/words.txt";
		
		UserFile file = null;
		
		Scanner wordsOfUser;
		
		
		try {
			
			words = new Words(filePath);
			words.WordProcessor(words.fileIN);
			
			file = new UserFile(); 

			
		}
		
		catch(FileNotFoundException e){
		
			System.out.println("File cannot be found." + e.getMessage());
			
		}
		
		finally {
			
			System.out.println(words.hashSet.size());
			
		}
		
		wordsOfUser =  file.userFile.useDelimiter("[^a-zA-Z]+");
		
		words = wordsOfUser.toString().toLowerCase();
	}
}
