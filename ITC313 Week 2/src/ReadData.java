import java.util.*;
import java.io.*;

public class ReadData {

	public static void main(String[] args) throws Exception
	{
		//create a file instance
		File file = new File("scores.txt");
		
		//make a Scanner
		Scanner input = new Scanner(file);
		
		//read data from the file
		while (input.hasNext())
		{
			String firstName = input.next();
			String midName = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + midName + " " + lastName + " " +  score);
		}
		
		input.close();
	}

}
