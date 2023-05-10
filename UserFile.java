
//import java.util.Scanner;
//import java.util.HashSet;
import javax.swing.*;

import java.io.File;
//import java.io.FileNotFoundException;

public class UserFile {
		
	public File getInputFileNameFromUser(){
		
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
           return null;
        else
           return fileDialog.getSelectedFile();
     }

}
