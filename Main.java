import java.io.FileNotFoundException;
//import java.io.File;
import java.util.*;

public class Main extends UserFile{
	
	public static void main(String[] args){
		
		Words userWords = null; //Initializing null variable

		
		String filePath = "/mnt/test/words.txt";
		
		UserFile readFile = new UserFile();
		
		Scanner userFile = null;
		
		HashSet<String> noMatchWords;
		

	
		
		try {
			
			
			userWords = new Words(filePath);
			
			userWords.WordProcessor();
		
			
			userFile = new Scanner(readFile.getInputFileNameFromUser());
			
	
		}
		
		catch(FileNotFoundException e){
		
			System.out.println("File cannot be found." + e.getMessage());
			
		}
		
		catch(NullPointerException n) {
			
			System.out.println("You did not select anything!");
		}
	
		finally {
			

			
			System.out.println();
			
		}
		 
		
		userFile.useDelimiter("[^a-zA-Z]+");

		
		noMatchWords = readFile.getNoMatchStrings(userFile, userWords);
		
		noMatchWords.forEach((elements) -> {
			
			System.out.println(elements);
		
		});
		
		
	
	}
}
