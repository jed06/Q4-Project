import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores {
	public static ArrayList <String> readScores(int numOfScores) {
		ArrayList <String> sarray = new ArrayList <String>();
	try {
	      File myObj = new File("Scores.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        sarray.add(data);
	        System.out.println(data);
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
	      FileWriter myWriter = new FileWriter("Scores.txt");
	      myWriter.write(score);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}

}
