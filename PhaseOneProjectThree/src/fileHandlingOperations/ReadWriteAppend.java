package fileHandlingOperations;

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

public class ReadWriteAppend {

	Scanner ask = new Scanner(System.in);
	//private List<String> new;
	private String line;
	private int Operation;

	private void WriteToFile() throws IOException {
		OutputStream os = new FileOutputStream(new File ("C:\\Users\\kanikajain4\\Desktop\\Java\\FileHandling\\newTestData.txt"));
		os.write(this.line.getBytes(), 0 ,this.line.length());
		System.out.println("File written successfully!!!!");
		os.close();
	}

	private void AppendToFile() throws IOException {
		
		File f = new File("C:\\Users\\kanikajain4\\Desktop\\Java\\FileHandling\\newTestData.txt");
		if(f.createNewFile()) {
			OutputStream os = new FileOutputStream(f);
			os.write(this.line.getBytes(), 0 ,this.line.length());
			System.out.println("Successfully appended the data");
			os.close();
		}
		else {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(f, true));
			writer.write("\n");
			writer.write(this.line);
			System.out.println("Successfully appended the data");
			writer.close();
		}
	}

	private void ReadFile() throws IOException {

		File file = new File("C:\\Users\\kanikajain4\\Desktop\\Java\\FileHandling\\newTestData.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader  br = new BufferedReader(isr);
		String readData;
		System.out.println("Following is the data in the file : ");
		while((readData = br.readLine()) != null) {
			System.out.println(readData);
		}
		br.close();
	}

	public void takeInput() {
		System.out.print("Enter the text you want to write/append to the file : ");
		this.line = ask.nextLine();
	}

	public void Operation() throws IOException {
		System.out.println("Press 1 if you want to read the file\n"
				+ "Press 2 if you want to append in an existing file\n"
				+ "Press 3 if you want to write a file\n"
				+ "Press 4 to exit");
		this.Operation = ask.nextInt();
		ask.nextLine();

		switch(this.Operation) {

		case(1):
			ReadFile();
			Operation();
			break;

		case(2):
			takeInput();
			AppendToFile();
			Operation();
			break;

		case(3):
			takeInput();
			WriteToFile();
			Operation();
			break;

		case(4):
			System.out.println("Exiting!");
			break;
		
		default:
			System.out.println("Invalid choice, please choose from the given options");
			Operation();
			break;
		}
	}
}
