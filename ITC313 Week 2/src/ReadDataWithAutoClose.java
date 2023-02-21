import java.util.*;
import java.io.*;

public class ReadDataWithAutoClose {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//create a file instance
		File file = new File("scores.txt");
		
		try (Scanner input = new Scanner(file);)
		{
			while (input.hasNext())
			{
				String firstName = input.next();
				String midName = input.next();
				String lastName = input.next();
				int score = input.nextInt();
				System.out.println(firstName + " " + midName + " " + lastName + " " +  score);
			}
		}

	}

}
