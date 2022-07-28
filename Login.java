package authenticationsystem;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Login {
    Scanner scnr = new Scanner(System.in);
    Scanner inFS = null;
    String username = "";
    String inputPassword = "";
    String password = "";
    String userRole = "";
    boolean loginSuccess = false;
    
    public void inputLogin() throws IOException, Exception {
       //Prompt user for username
       System.out.println("\nEnter username: ");
       String username = scnr.nextLine();
       //If statement to quit program if user inputs 'q'
       if (username.equals("q")) {
          System.out.println("\nExiting program. Goodbye.");
          System.exit(0);
       }
       
       //Prompt user for password       
       System.out.println("Enter password: ");
       String inputPassword = scnr.nextLine();
       //If statement to quit program if user inputs 'q'
       if (inputPassword.equals("q")) {
          System.out.println("\nExiting program. Goodbye.");
          System.exit(0);
       }
       
       //Call class to obtain hashed password
       password = MD5Digest.hashPassword(inputPassword);
       //Call method to compare credentials with those on file
       compareCredentials();
    }
    
    public void compareCredentials() throws IOException {
       //Open file with credentials (file path should be changed as necessary to match its location)
       FileInputStream credFile = new FileInputStream("\\authenticationsystem\\credentials.txt");
       inFS = new Scanner(credFile);
       String fileLine = "";
       
       //While loop to find matching credentials in file
       while(inFS.hasNextLine()){
          fileLine = inFS.nextLine();
          
          //If statement statement that checks both username and hashed password match
          if(fileLine.startsWith(username) && fileLine.contains(password)) {
             //If credentials match, call method to obtain user's role
             setRole(fileLine);
          }
       }
    }
    
    public void setRole(String fileLine) {
       int lastTab = fileLine.lastIndexOf("\t");
       //Set user role to the last word on user's file line
       userRole = fileLine.substring(lastTab + 1, fileLine.length());
       //Once user role is set, login is succesful
       loginSuccess = true;
    }
    
    public void startSession() throws IOException, Exception {
       //Create an object to start a new session
       Session mySession = new Session();
       
       //Start a new session for this user
       mySession.initSession(userRole);
    }
}
