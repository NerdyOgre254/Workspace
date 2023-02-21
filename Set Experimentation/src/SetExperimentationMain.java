import java.util.*;	//importing everything from java.util, including Set and HashSet
public class SetExperimentationMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Set<Integer> primeNumberSet = new HashSet<>();	//note that it needs to use Integer not int
		primeNumberSet.add(2);	//note that add() doesn't allow for multiple additions to the set
		primeNumberSet.add(3);
		//System.out.println(primeNumberSet);	//testing to show that you can display a whole set with println()
		//isThisPrime(9, primeNumberSet);
		
	}
	
	public static boolean isThisPrime(int potentialPrime, Set<Integer> primeSet)	//specifically need to say Set<Integer>?
	{
		System.out.println(primeSet);	//proving that you can pass a set as argument
		
		if(potentialPrime <2)	//everything less than 2 isn't prime
		{
			System.out.println("Numbers <2 are not prime");
			return false;
		}
		
			for (Integer temp: primeSet)	//foreach loop iterating through primeSet
			{
				if (potentialPrime % temp == 0)
				{
					System.out.println(potentialPrime + " is dvisible by " + temp);		//"this number is divisble by the number we're looking at now!"
					return false;
				}
				else
				{
					System.out.println(potentialPrime + " is not divisble by " + temp);
				}
			}
		
		return true;	//if you get through every negative gate, the result must be prime (assuming I did it right)
	}
	

}
