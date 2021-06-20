import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PasswdSearch extends PasswdMng{
	public void Search()  {
		folderCheck();
		String input="-1";
		String toFilesPath=DriverGUI.pathGain();
		Scanner userScan = new Scanner(System.in);
		 
		System.out.print("\n Type a Name tag:"); 
		String request=userScan.nextLine();
		 
		while (!(input.equals("b"))) {
			String[] fileNames=PasswdMng.passwdStringArr();
			System.out.println();
//partial search of a name tag
			int j=0; //to count number of found results
			for (int i=0; i<fileNames.length; i++) { 
				String temp=fileNames[i].substring(0, fileNames[i].length()-5);
				if (temp.contains(request)) {
					try {
						j++;
						System.out.println("");
						System.out.println("Name tag:'"+ fileNames[i].substring(0, fileNames[i].length()-5)+"'");//-5 because if .pass file extension
						
						String fname= fileNames[i];
						FileReader fread= new FileReader(toFilesPath+ File.separator +fname);
						Scanner readerScan= new Scanner(fread);
						
						System.out.println("Password:'"+readerScan.nextLine()+"'");  
						System.out.println("");
						fread.close();
						readerScan.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
//------------------------------------
			if (j==0) { //check if there were any prints
				System.out.println("Nothing Found");
			}
			System.out.println("\n \n b: Go back");
			input = userScan.nextLine();
		}
	}
}
