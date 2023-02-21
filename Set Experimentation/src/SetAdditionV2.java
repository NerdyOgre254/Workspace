import java.util.*;	//import Set and HashSet
public class SetAdditionV2 {

	public static void main(String[] args) 
	{
		//build our definitely prime numbers set [2,3]
		Set<Integer> primeNumbers = new HashSet<>();
		primeNumbers.add(2);
		primeNumbers.add(3);
		
		//target number for testing
		int highest = 50000;
		
		for (int a = 5; a <= highest; a+=2)
		{
			boolean aIsPrime = true;
			for (Integer b: primeNumbers)
			{
				if(a % b == 0 && a != b)	//if a is divisble by b and a is also not b 
				{
					aIsPrime = false;
				}
			}
			if (aIsPrime)
			{
				primeNumbers.add(a);
			}
		}

		System.out.println(primeNumbers);
	}

}
