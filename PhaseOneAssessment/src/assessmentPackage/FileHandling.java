package assessmentPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class FileHandling {

		Scanner ask = new Scanner(System.in);
		//private List<String> new;
		private String line;
		private int Operation;
		private String[] fileNames;
		private String dirPath= "C:\\Users\\kanikajain4\\Desktop\\Projects\\Assessment\\";
		private String fName;

		private void WriteToFile() throws IOException {
			getFiles();
			for (String Fname : this.fileNames) {
				if(Fname.compareTo(this.fName)==0) {
					System.out.println("File already exists!");
					return;
				}
			}
			takeInput();
			OutputStream os = new FileOutputStream(new File (dirPath.concat(this.fName)));
			os.write(this.line.getBytes(), 0 ,this.line.length());
			System.out.println("File written successfully!!!!\n");
			System.out.println("*****************************************\n");
			os.close();
		}

		private void ReadFile() throws IOException {
			getFiles();
			for (String Fname : this.fileNames) {
				if(Fname.compareTo(this.fName)==0) {
					File file = new File (dirPath.concat(this.fName));
					FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis);
					BufferedReader  br = new BufferedReader(isr);
					String readData;
					System.out.println("Following is the data in the file : ");
					while((readData = br.readLine()) != null) {
						System.out.println(readData);
					}
					System.out.println("***************************************\n");
					br.close();
					return;
				}
			}
			System.out.println("File doesn't exist!");
		}
		
		private void deleteFile() {
			getFiles();
			File file = new File(dirPath.concat(this.fName));
			for (String Fname : this.fileNames) {
				if(Fname.compareTo(this.fName)==0) {
					if(file.delete()) {
						System.out.println("File "+ Fname + " deleted successfully"); 
						System.out.println("*******************************************\n");
						return;
					}
			        else {
			            System.out.println("Failed to delete the file "+Fname);
			            System.out.println("*******************************************\n");
			            return;
			        }
				}
			}
			System.out.println("File not found !!");
			System.out.println("*******************************************\n");
		}
		
		private void getFiles() {
			System.out.print("Enter the file name : ");
			this.fName = ask.nextLine().trim(); 
			System.out.println("\n");
			File dirPath = new File("C:\\Users\\kanikajain4\\Desktop\\Projects\\Assessment");
			this.fileNames = dirPath.list();
		}

		public void takeInput() {
			System.out.print("Enter the text you want to write to the file : ");
			this.line = ask.nextLine();
		}

		public void Operation() throws IOException {
			System.out.println("Press 1 if you want to search and read a file\n"
					+ "Press 2 if you want to add a new file\n"
					+ "Press 3 for deleting a file\n"
					+ "Press 4 to exit");
			this.Operation = ask.nextInt();
			ask.nextLine();

			switch(this.Operation) {

			case(1):
				ReadFile();
				Operation();
				break;

			case(2):
				WriteToFile();
				Operation();
				break;

			case(3):
				deleteFile();
				Operation();
				break;

			case(4):
				System.out.println("\nExiting file handling operations!");
				System.out.println("Entering the main application\n");
				break;
			
			default:
				System.out.println("Invalid choice, please choose from the given options");
				Operation();
				break;
			}
		}
}
