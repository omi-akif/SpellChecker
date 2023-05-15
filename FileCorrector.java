import java.util.*;

public class FileCorrector {


	
	public static TreeSet<String> allRevisedWords = new TreeSet<>();
	

	
	public static TreeSet<String> correctons(String badWord, HashSet<String> providedDictionary) {
		
		allRevisedWords.addAll(FileCorrector.correctorChangeLetter(badWord, providedDictionary));
		allRevisedWords.addAll(FileCorrector.correctDeleteLetter(badWord, providedDictionary));
		allRevisedWords.addAll(FileCorrector.correctInsertLetter(badWord, providedDictionary));
		allRevisedWords.addAll(FileCorrector.correctSpacedLetter(badWord, providedDictionary));
		allRevisedWords.addAll(FileCorrector.correctSwapLetter(badWord, providedDictionary));
		
		return allRevisedWords;
		
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
	
	public static String[] insertSpace(int index, String badWord) throws StringIndexOutOfBoundsException{
		
		String[] seperatedWords = new String[2];
		
		seperatedWords[0] = badWord.substring(0, index);
		
		seperatedWords[1] = badWord.substring(index);
				
		return seperatedWords;
		
	}
	

	
	public static TreeSet<String> correctorChangeLetter(String badWord ,HashSet<String> providedDictionary) {
		
		String aRevisedWord;
		
		TreeSet<String> revisedWords = new TreeSet<>();
		
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
		
		TreeSet<String> revisedWords = new TreeSet<>();
		
		String aRevisedWord;
		
		
		
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
		
		TreeSet<String> revisedWords = new TreeSet<>();
		
		String aRevisedWord;
		
		
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
		
		
		TreeSet<String> revisedWords = new TreeSet<>();
		
		String aRevisedWord;
		
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
		
		TreeSet<String> revisedWords = new TreeSet<>();
		
		String[] aRevisedWord;
		
		for(int i = 0; i <= badWord.length(); i++) {
			
			try {
			
				
				aRevisedWord = FileCorrector.insertSpace(i, badWord);
				
				if(providedDictionary.contains(aRevisedWord[0]) && providedDictionary.contains(aRevisedWord[1])) {
					
					revisedWords.add(aRevisedWord[0]);
					revisedWords.add(aRevisedWord[1]);
					
					
				}
				else if(providedDictionary.contains(aRevisedWord[1])) {
					
					revisedWords.add(aRevisedWord[1]);
					
				}
				else if (providedDictionary.contains(aRevisedWord[0])) {
					
					revisedWords.add(aRevisedWord[1]);
					
				}else {
					continue;
				}
				
				
			}catch(StringIndexOutOfBoundsException e){
				
				break;
				
				
			}
			
		}

		
		return revisedWords;
		
	}
	

}
