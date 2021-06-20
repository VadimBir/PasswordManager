import java.io.*;
import java.util.Scanner;

public class PasswdListing  extends PasswdMng{
	public void listing() {
		folderCheck();
		Scanner userScan = new Scanner(System.in);
		String toFilesPath=DriverGUI.pathGain();
		String input="-1";
		int i=0;
		String[] fileNames=PasswdMng.passwdStringArr();
		 
		while (!(input.equals("b"))) {
// lists and prints the Password name tag (file name) and password (content of file) from an array 
			try { 
				for (i=0; i<fileNames.length;i++) {
					String fname= fileNames[i];
					FileReader fread= new FileReader(toFilesPath+ File.separator +fname);
					Scanner readerScan = new Scanner(fread); //scan to scan file
					
					System.out.println("");
					System.out.println("Name tag:'"+fileNames[i].substring(0, fileNames[i].length()-5)+"'");//-5 because if .pass file extension
					System.out.println("Password:'"+readerScan.nextLine()+"'");  
					System.out.println("");
// ------------------------------------------------
					fread.close();
					readerScan.close();
				} 
			}catch (IOException e) {
				e.printStackTrace();
				}
//------------------------------------
			if (i==0) {
				System.out.println("List is empty");
			}
			System.out.println("\n \n b: Go back");
			input = userScan.nextLine();	
		}		
	}
}

			
	

