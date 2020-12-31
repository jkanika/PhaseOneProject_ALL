package assessmentPackage;

import java.io.File;

public class RetrieveFiles {
	
	private void sortFiles(String[] fileNames,int size) {
		for(int i=0; i<size;i++) {
			for(int j=i+1; j<size;j++) {
				if(fileNames[i].compareTo(fileNames[j])>0) 
					swap(fileNames,i,j);
			}
		}
	}
	
	private void swap(String[] files,int i,int j) {
		String temp = files[i];
		files[i] = files[j];
		files[j] = temp;
	}

	public void displayFiles() {
		File dirPath = new File("C:\\Users\\kanikajain4\\Desktop\\Projects\\Assessment");
		String[] fileNames = dirPath.list();
		int size = fileNames.length;
		sortFiles(fileNames,size);
		System.out.println("\n");
		for (String name : fileNames) {
			System.out.println(name);
		}
	}
}
