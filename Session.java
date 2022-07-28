package authenticationsystem;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Session {
    String sessionRole = "";
    Scanner inRS = null;
    Scanner scnr = new Scanner(System.in);
    
    public void initSession(String userRole) throws IOException, Exception {
       sessionRole = userRole;
       
       //Open correct file according to user role (file path should be changed as necessary to match its location)
       FileInputStream sessionFile = new FileInputStream("\\authenticationsystem\\" + sessionRole + ".txt");
       inRS = new Scanner(sessionFile);
       
       //While loop to output every line in file
       while(inRS.hasNextLine()){
          String sessionLine = inRS.nextLine();
          System.out.println(sessionLine);
       }
       //Call method to initiate logout prompt
       logOut();
    }
    
    public void logOut() throws IOException, Exception {
       //Prompt user to enter command to quit or return to login screen
       System.out.println("\nEnter 'n' for new user or 'q' to quit.");
       String command = scnr.next();
       
       //If statement to return to login if user inputs n
       if(command.equals("n")){
           AuthenticationSystem.loginScreen();
       }
       //If statement to quit program if user inputs q
       else if(command.equals("q")) {
          System.out.println("\nExiting program. Goodbye.");
       }
    }
}
