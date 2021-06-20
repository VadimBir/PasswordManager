import java.util.Scanner;
import java.util.Random;

public class PasswdGen extends DriverGUI{
	 
	Scanner userScan = new Scanner(System.in);
	public void Generator() {
		String name="";
		int Length =-1;
		String passwd;
		String copied = "-1";
		String retryGen ="-1";
			
		System.out.println("Please enter a name tag for your password ");	
		name=userScan.nextLine(); 
		while(name.matches(".*\\W+.*")){
		System.out.println("Sorry invalid name tag, only alphanumeric characters are allowed ");
		System.out.println("Please enter a name tag for your password ");
		name=userScan.nextLine(); 
		}
		System.out.println("\n \n Choose the Length of a Password (up to 10000)"); 

// checkers 	
		while (Length<=0 ||Length>10000 ) { // numbers that are very big make a program freeze for a while so I limited it to 10000
			while (!userScan.hasNextInt()) {
			      System.out.println("Input is Invalid Please enter a positive integer");
			      userScan.nextLine();
			}
		    Length=userScan.nextInt();
		    userScan.nextLine();
	    
		    if (Length>10000) {
		    	System.out.println("You can enter only upto 10000");
		    }
		    if (Length<=0) {
		    	System.out.println("Input is Invalid Please enter a positive integer");
		    }
		}
//------------------------------------		
		System.out.println("Length you chose:" + Length);//get only integer from a user 
		passwd=PasswdGen(Length);
		 
		Storing store=new Storing(name, passwd);
		int StoreCond=store.Saver(name, passwd);
		
		if (StoreCond==-1) {
			System.out.println("Sorry this name tag:'"+ name +"' is already used");
			System.out.println("Try to generate password again? (y?)");
				retryGen=userScan.nextLine();
			if (retryGen.equals("y")) {
				Generator();
			}
			return;
		}
		while(!(copied.equals("y"))) {
			System.out.println("Tag:'"+name+"' 	Password:"+passwd);
			System.out.println("Did you copy the password? (y?)");
			copied=userScan.nextLine();
		}
	}
	private String PasswdGen(int x) {  
		
		final String chars ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String passwd;
		Random rand = new Random();
		StringBuilder strBldr = new StringBuilder();
		
		for (int i=0; i<x; i++) {
			int charNum=rand.nextInt(62); 
			char passwdChar=chars.charAt(charNum);
			strBldr.append(passwdChar);
		}
		passwd=strBldr.toString();
		
		return passwd;
		
		 
		
		
		
		
	}

}
