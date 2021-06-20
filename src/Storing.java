import java.io.*;

public class Storing extends PasswdGen {
		 
	public Storing(String name, String passwd) { 
		
	}

	public int Saver(String x,String  y) {
		folderCheck();
//Idea here is to create a file which would have a file name as a password name tag and inside that file it would be actual password 
		String name = x;
		String passwd = y;
		String toFilePath=DriverGUI.pathGain();
		
		File fileCheck=new File(toFilePath+name+".pass");
		boolean testFile=fileCheck.exists();
//testing file repetition 
		if (testFile==true) {	
			return -1;
		}
//---------------------------
		else {
			//System.out.println("no file");
			try {
				fileCheck.createNewFile(); //file creation
			} catch (IOException e) {
				e.printStackTrace();
			}
			try { // write a password in a file that was just created 
				PrintWriter toFile = new PrintWriter(fileCheck);
				toFile.print(passwd);
				toFile.close();
			} catch (FileNotFoundException e) {	
				e.printStackTrace();
			}
		}
	return 1;
	}
}
 
