// Vadim Biryukov || Final Project Object Oriented Programming 1 || Password Manager




import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DriverGUI {

	public static void main(String[] args) {
		folderCheck();
		PasswdGen passwdGen=new PasswdGen();
		PasswdMng passwdMng=new PasswdMng();
		
		String input="-1";
		Scanner userScan = new Scanner(System.in);
		
		while (!(input.equals("q"))) {
			
			System.out.println("\n	1. Password Generator");
			System.out.println("	2. Manage Passwords");
			System.out.println("\n	q. Quite");
			System.out.println("\n \n \nPlease Select the number");
			input=userScan.nextLine();
				
			switch(input) {
				case "1":
					passwdGen.Generator(); 
					break;
				case "2":
					passwdMng.managerGUI();
					break;
			}
		}
		System.out.println("Exited");
	}
	 
	protected static void folderCheck() { //check if there is a folder that has or would have passwords 
		final String folderName="passwds";
		
		File folderCheck=new File(folderName);
		boolean testFolder=folderCheck.exists();
		
		if (testFolder==false) { //checks if folder exists
			new File(folderName).mkdirs();			
		}
	}
	 
	protected static String pathGain() { 
		String curPath;
		final String folderName="passwds";		
		Path directoryPath = Paths.get("");
		curPath =directoryPath.toAbsolutePath().toString();
//assign folder path 
				String toFilePath=curPath+ File.separator +folderName+ File.separator; //path to inward the folder
//------------------------------
		return toFilePath;
	}
}
