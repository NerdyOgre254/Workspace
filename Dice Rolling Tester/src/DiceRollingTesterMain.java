import java.lang.Math;
import java.lang.Character;
public class DiceRollingTesterMain {

	public static void main(String[] args) 
	{
		//testing whether math.random rolls the maximum less than the minimum due to truncating decimals: 1 occupies range 1 - 1.9999, 6 might only happen on 6?
		int diceroll;
		int rollOne = 0;
		int rollTwo = 0;
		int rollThree = 0;
		int rollFour = 0;
		int rollFive = 0;
		int rollSix = 0;
		
		for (int count = 1; count < 10000; count++)
		{
			diceroll = (int)((Math.random() * 6) + 1);
			switch(diceroll)
			{
				case 1:
					rollOne++;
					break;
				case 2:
					rollTwo++;
					break;
				case 3:
					rollThree++;
					break;
				case 4:
					rollFour++;
					break;
				case 5:
					rollFive++;
					break;
				case 6:
					rollSix++;
					break;
			}
		}
		
		System.out.println(rollOne);
		System.out.println(rollTwo);
		System.out.println(rollThree);
		System.out.println(rollFour);
		System.out.println(rollFive);
		System.out.println(rollSix);
		
		//answer appears to be no. 
	}

}
