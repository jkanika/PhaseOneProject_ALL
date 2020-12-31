package assessmentPackage;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeScreen {

	public void display() throws IOException {
		System.out.println("***********************************************\n");
		System.out.println("     Welcome to File Handling Application\n");
		System.out.println("***********************************************");
		System.out.println("Developed by - Kanika\n");
		System.out.println("This application provides you with below options\n"
				+ "1. View\t 2. Add\t 3. Delete\t 4. Search files \n");
		chooseMenu();
	}
	
	public void chooseMenu() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("***********************************************\n"
				+ "Press 1 for retrieving the already existing files in ascending order\n"
				+ "Press 2 for File handling operations \n"
				+ "Press 3 for exiting the main application");
		int option = scan.nextInt();
		
		switch(option) {
		
		case(1):
			RetrieveFiles file = new RetrieveFiles();
			file.displayFiles();
			chooseMenu();
			break;
				
		case(2):
			FileHandling obj = new FileHandling();
			obj.Operation();
			chooseMenu();
			break;
			
		default:
			System.out.println("Exiting the main application!");
			break;
		}
	}
}
