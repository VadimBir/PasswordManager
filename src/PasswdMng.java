import java.io.File;
import java.util.Scanner;

public class PasswdMng extends DriverGUI {
	 
	public void managerGUI() {
		String input="-1"; 
		PasswdListing lister = new PasswdListing();
		PasswdSearch searcher = new PasswdSearch();
		PasswdDelete deleter = new PasswdDelete();
		Scanner userScan = new Scanner(System.in);
		
		while (!(input.equals("b"))) {
			System.out.println("\n	1. List all passwords ");
			System.out.println("	2. Search for passwords");
			System.out.println("	3. Delete password name tag");
			System.out.println("\n	b. Go Back");
			System.out.println("\n \n \nPlease Select the number");
			input=userScan.nextLine();
			
			switch(input) {
				case "1":
					lister.listing();
					break;
				case "2":
					searcher.Search();
					break;
				case "3":
					deleter.Delete();
					break;
				
			}
		}
	}
	 
	protected static String[] passwdStringArr() {
		String toFilesPath=DriverGUI.pathGain();	
//get files names from a folder into a string array
		File fdir = new File(toFilesPath);
		String[] fileNames = fdir.list();
//------------------------------------
	return fileNames;
	}
}
