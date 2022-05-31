import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ScoresIO {	
	public static ArrayList <Integer> readScores() {
		ArrayList <Integer> sarray = new ArrayList <Integer>();
		try {
	      File myObj = new File("Scores.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if (data != null && data != "" && data.length() > 0) {
	        sarray.add(Integer.parseInt(data));
	        //System.out.println(data);
	        	}
	        }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	
	return sarray;
	}
public static void addScore(int score) {
	 try {
		 File myObj = new File("Scores.txt");
	      FileWriter myWriter = new FileWriter(myObj, true);
	      myWriter.append( score + "\n");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}
}
