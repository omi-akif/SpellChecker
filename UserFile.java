
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.*;


import java.io.File;
import java.io.FileNotFoundException;

public class UserFile {

//	static Iterator<String> revisedWordsIterator = new revisedWords.iterator();
	
	static Iterator<String> reviseWordsIterator;
	
	
	private HashSet<String> badWords =  new HashSet<>(); 
		
	public File getInputFileNameFromUser() throws FileNotFoundException{
		
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
           return null;
        else
           return fileDialog.getSelectedFile();
     }
	
	public HashSet<String> getNoMatchStrings(Scanner inputFile, Words userWords) throws NullPointerException{
		
		String nowWord;
		
		
		while(inputFile.hasNext()) {
			
			nowWord = inputFile.next();
			
			nowWord = nowWord.toLowerCase();
			
			if(!userWords.userDictionary.contains(nowWord)) //Checks if the input string is in the hashSet
			
				badWords.add(nowWord);

		}
		
		return badWords;
		
	}
	
	public void printBadWords(HashSet<String> badWords){
		
		badWords.forEach(word -> {
			System.out.println(word);
		});
		
	}
	
	public static void printSingleLineReviseWords(String badWord, TreeSet<String> revisedWords) {
		
		reviseWordsIterator = revisedWords.iterator();
		
		System.out.print(badWord + ": ");
		
		if(revisedWords.isEmpty()) {
			
			System.out.print(": (no suggestions)");
			
		}else  {
		
			
			
			String firstWord = reviseWordsIterator.next();
			
			System.out.print(firstWord);
			
			while(reviseWordsIterator.hasNext()) {
				
				String aBadWord = reviseWordsIterator.next();
				
				System.out.print(", " + aBadWord);
				
			}
			
			
			
		}
		
		System.out.println();
		
	}
	

}
