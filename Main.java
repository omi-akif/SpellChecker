import java.io.FileNotFoundException;
import java.util.*;

public class Main extends UserFile{
	
	public static void main(String[] args){
		
		Words userWords = null; // These are dictionary words

		
		String filePath = "/mnt/test/words.txt"; // Default file path
		
		UserFile readFile = new UserFile();
		
		Scanner userFile = null;
		
		HashSet<String> badWords;
		
		TreeSet<String> suggestions = new TreeSet<>();
	
		
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

			userFile.useDelimiter("[^a-zA-Z]+");

			
			badWords = readFile.getNoMatchStrings(userFile, userWords);
			

			
			
			
			for(String aBadWord : badWords) {
				
				suggestions = FileCorrector.correctons(aBadWord, userWords.userDictionary);
				
				UserFile.printSingleLineReviseWords(aBadWord, suggestions);
				
			}
			
			
		}
		

	
	}
}
