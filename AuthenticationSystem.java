package authenticationsystem;

/*
* Author: Melissa Rodriguez
* Creation date: August 12, 2019
* Revision: #1
* Purpose of code: To authenticate a zoo employee's login credentials and authorize
* them to view data that pertains to their role
*/
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class AuthenticationSystem {
    public static void main(String[] args) throws IOException, Exception {
       //Prompt user to quit program at any time
       System.out.println("Enter 'q' at any time to quit program.");
       //Calling method to initiate login
       loginScreen();
    }
    
    public static void loginScreen() throws IOException, Exception {
        Login loginAttempt = new Login();
        int failedAttempts = 0;
        
        //While loop to monitor failed attempts counter
        while (failedAttempts < 3) {
           loginAttempt.inputLogin();
           //If statement to check login success
           if (loginAttempt.loginSuccess){
               break;
           } 
           //If login unsuccessful, add 1 to failed attempts counter
           System.out.println("Incorrect username or password.");
           ++failedAttempts;
        }
        
        //If statement for ending the program if attempt limit reached
        if (failedAttempts == 3) {
           System.out.println("\nToo many failed attempts. Exiting program.");
        } 
        //If limit not reached, continue login
        else {
            loginAttempt.startSession();
        }
        
    }
    
}
