package emailValidation;

import java.util.ArrayList;

public class ValidatingEmail {
	
	public static void main(String[] args) {
		
		//List of email id formation
		ArrayList<String> emails = new ArrayList<String>();
		emails.add("kanika.jain@gmail.com");
		emails.add("student_new@yahoo.com");
		emails.add("fes2433@outlook.com");
		emails.add("try-12@gmail.com");
		emails.add("mm@yuhoo..com");
		//Creating object for the CheckEmail class
		CheckEmail obj = new CheckEmail();
		obj.getEmail();
		obj.EmailExist(emails);
		obj.result();
	}

}
