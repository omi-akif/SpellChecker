import java.util.*;

public class FileCorrector {

	
	//Need to use seperate variable for all revised words
	
	public static TreeSet<String> revisedWords = new TreeSet<>();
	
	protected static String aRevisedWord;
	

	
	public static TreeSet<String> correctons(String badWord, HashSet<String> providedDictionary) {
		
		
		FileCorrector.correctorChangeLetter(badWord, providedDictionary);
		FileCorrector.correctDeleteLetter(badWord, providedDictionary);
		FileCorrector.correctInsertLetter(badWord, providedDictionary);
		FileCorrector.correctSpacedLetter(badWord, providedDictionary);
		FileCorrector.correctSwapLetter(badWord, providedDictionary);
		
		
		
		return revisedWords;
		
	}
	
	
	
	public static String changeLetter(int index, char correctLetter,String badWord) throws StringIndexOutOfBoundsException{
		
		
		badWord = badWord.substring(0, index) + correctLetter + badWord.substring(index + 1);
		
		return badWord;

		
	}
	
	
	public static String deleteLetter(int index, String badWord) throws StringIndexOutOfBoundsException {
		
		badWord = badWord.substring(0, index) + badWord.substring(index + 1);
		
		return badWord;
		
	}
	
	public static String insertLetter(int index, String badWord, char insertChar) throws StringIndexOutOfBoundsException{
		
		
		badWord = badWord.substring(0, index) + insertChar + badWord.substring(index);
		
		return  badWord;
		
	}
	
	
	public static String swapLetter(int index, String badWord) throws  StringIndexOutOfBoundsException{
		
		
		badWord = badWord.substring(0, index) + badWord.substring(index + 1, index + 2) + badWord.substring(index, index + 1) + badWord.substring(index + 2);
//		String revisedWord = testWord.substring(0, 3) + testWord.substring(4, 5) +testWord.substring(3, 4) + testWord.substring(5);
		
//		revisedWord = badWord.substring(0, index) + swappedChar + badWord.
		return badWord;
		
	}
	
	public static String insertSpace(int index, String badWord) throws StringIndexOutOfBoundsException{
		
		badWord = badWord.substring(0, index) + " " + badWord.substring(index);
				
		return badWord;
		
	}
	
	
//	public static char seqCharInsertion(){
//	
//		char englishAlphabets[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//	
//		int i = 0;
//		
//		i++;
//		
//		return englishAlphabets[i];
//	
//	}
	
	public static TreeSet<String> correctorChangeLetter(String badWord ,HashSet<String> providedDictionary) {
		
		
		for(int i = 0; i <= badWord.length(); i++) {
			
			
			for(char ch = 'a'; ch <= 'z'; ch++) {
				
				try {
					
					 aRevisedWord = FileCorrector.changeLetter(0, ch, badWord);
					  
					  if(providedDictionary.contains(aRevisedWord)) {
						  
						  revisedWords.add(aRevisedWord);
						  
					  }else {
						  
						  continue;
						  
					  }
					
				}catch(StringIndexOutOfBoundsException e) {
					
					
					break;
					
					
				}
			
				 
				
			}
			
		}
		
		return revisedWords;
	
	}
	
	
	public static TreeSet<String> correctDeleteLetter(String badWord, HashSet<String> providedDictionary){
		
		for(int i = 0; i <= badWord.length(); i++) {
			
			try {
				
				aRevisedWord = FileCorrector.deleteLetter(i,badWord);
				
				if(providedDictionary.contains(aRevisedWord)) {
					  
					  revisedWords.add(aRevisedWord);
					  
				  }else {
					  
					  continue;
					  
				  }
				
			}
			catch(StringIndexOutOfBoundsException e){
				
				break;
				
			}
			
		}
		
		return revisedWords;
		
		
	}
	
	
	public static TreeSet<String> correctInsertLetter(String badWord, HashSet<String> providedDictionary){
		
		
		for(int i = 0; i <= badWord.length();i++) {
			
			for(char ch = 'a'; ch <= 'z'; ch++) {
				
				try {
					
					aRevisedWord = FileCorrector.insertLetter(i, badWord, ch);
					
					if(providedDictionary.contains(aRevisedWord)) {
						
						revisedWords.add(aRevisedWord);
						
					}
					else {
						continue;
					}
					
					
				}
				catch(StringIndexOutOfBoundsException e){
					
					break;
					
				}
				
				
				
			}
			
		}
		
//		
		
		return revisedWords;
		
	}
	
	public static TreeSet<String> correctSwapLetter(String badWord, HashSet<String> providedDictionary){
		
		
		for(int i= 0; i <= badWord.length(); i++) {
			try {
				
				aRevisedWord = FileCorrector.swapLetter(i, badWord);
				
				if(providedDictionary.contains(aRevisedWord)) {
					
					revisedWords.add(aRevisedWord);
					
				}
				else {
					
					continue;
					
				}
				
			}
			catch(StringIndexOutOfBoundsException e){
				
				break;
				
			}
			
			
		}
		
		
		return revisedWords;
		
	}
	
	
	public static TreeSet<String> correctSpacedLetter(String badWord, HashSet<String> providedDictionary){
		
		for(int i = 0; i <= badWord.length(); i++) {
			
			try {
			
				
				aRevisedWord = FileCorrector.insertSpace(i, badWord);
				
				if(providedDictionary.contains(aRevisedWord)) {
					
					revisedWords.add(aRevisedWord);
					
				}
				else {
					
					continue;
					
				}
				
			}catch(StringIndexOutOfBoundsException e){
				
				break;
				
				
			}
			
		}

		
		return revisedWords;
		
	}
	

}
