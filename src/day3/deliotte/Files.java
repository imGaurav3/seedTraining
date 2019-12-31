package day3.deliotte;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Files {

	 void writeDataAsBytes() throws IOException {
		 String fileName = "D:\\javaio.txt";
		 
		 FileOutputStream outStream = new FileOutputStream(fileName, true);
		 outStream.write("This is a NEW line of txt".getBytes());
		 outStream.flush();
		 outStream.close();
	 }
	 
	 void readDataAsByte() throws FileNotFoundException, IOException {
		 String fileName = "D:\\javaio.txt";
		 try(FileInputStream inStream = new FileInputStream(fileName)){
			 int data = inStream.read();
			 while(data != -1) {
				 System.out.println(data);
				 data = inStream.read();
				 
			 }
		 }
	 }
	 
	 void writeDataAsChar() throws IOException {
		 String fileName = "D:\\javaiiio.txt";
		 
		 try(FileWriter writer = new FileWriter(fileName, true)){
			 writer.write("Writing from char file stream".toCharArray());
			 
		 }
	 }
	 
	 void readDataAsChar() throws IOException, IOException {
		 String fileName = "D:\\java.txt";
		 String find = "lorem";
		 String rep = "yoyo";
		 String result = "";
		 String data = "";
		 StringBuilder sb = new StringBuilder();
		 String delimeter = " ";
		 try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			 data = reader.readLine();
			 while(data != null) {
				 //System.out.println(data);
				 sb.append(data);
				 data = reader.readLine();
				 }
			 		 StringTokenizer st = new StringTokenizer(sb.toString(),delimeter,true);
			 		 while(st.hasMoreTokens()) {
			 			 String w = st.nextToken();
			 			 if(w.toLowerCase().equals(find)) {
			 				 result = result + rep;
			 			 }
			 			 else
			 				 result = result + w; 
			 		 	}
	 }
		 System.out.println(result);
		 
}
	 void checkForWord(String word) throws FileNotFoundException {
		 String fileName = "D:\\java.txt";
		 
		 
		 StreamTokenizer st = new StreamTokenizer(new FileReader(fileName));
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Files f = new Files();
		try {
			f.readDataAsChar();
			//System.out.println("Done....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
