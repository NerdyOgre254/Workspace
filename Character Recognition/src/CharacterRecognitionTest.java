import java.lang.Math;
import java.lang.Character;
import java.util.Scanner;

public class CharacterRecognitionTest {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean mainLoop = true;
		String leaveLoop;
		while (mainLoop)
		{
			//do a thing
			
			
			System.out.print("Would you like to continue? Y or N ");
			leaveLoop = input.next();
			leaveLoop = leaveLoop.toUpperCase();	//remember when using toUpperCase you need to assign it to a variable. like itself for example
			
			if(leaveLoop.charAt(0) == 'N')
			{
				mainLoop = false;
			}
		}
		input.close();
	}

}
