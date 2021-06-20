import java.io.File;
import java.util.Scanner;

public class PasswdDelete extends PasswdMng{
	public void Delete() {
		folderCheck();
		 
		Scanner userScan = new Scanner(System.in);
		String toFilesPath=DriverGUI.pathGain();
		String[] fileNames=PasswdMng.passwdStringArr();
 
		System.out.println("Please enter a tag that you want to delete");
			
		String toDelete = userScan.nextLine();
		for (int i=0; i<fileNames.length; i++) { 
			if (toDelete.equals(fileNames[i].substring(0, fileNames[i].length()-5))) { //-5 because if .pass file extension
				File toDel = new File(toFilesPath+File.separator+fileNames[i]);
				toDel.delete();
				System.out.println("Tag was deleted");
				return; //there should be no duplicate because when creating a tag it is checked if it already exists
			}				
		}
		System.out.println("The is no such a tag");
	}
}
