package emailValidation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckEmail {
	//Class variables
	Scanner scan = new Scanner(System.in);
	String email;
	boolean result;
	int flag = 0;
	//This function checks the existence of the mail id in the list
	public void EmailExist(ArrayList<String> email) {
		
		if (email.contains(this.email)) {
			this.result = isValid(this.email);
			if (this.result == false) {
				this.flag = 1;
			}
		}
		else {
			System.out.println("Email id doesn't exists!!");;
		}
	}
	
	//this function takes email input from user
	public void getEmail() {
		
		System.out.print("Enter the email id you want to validate : ");
		this.email = scan.nextLine();		
	}
		
	//this function checks if the mail is valid or not
	 private static boolean isValid(String email) 
	    { 
	        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        
	        if (email == null) 
	            return false; 
	        else return pat.matcher(email).matches(); 
	    } 	
	 
	 //this function prints the final output to the user
	 public void result() {
		 
		 if (this.result == true && flag==0) {
			 System.out.println("Emails exists and is valid!!");
		 }
		 else {
			 System.out.println("Email is invalid");
		 }
	 }
	 
}
