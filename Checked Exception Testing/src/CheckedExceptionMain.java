import java.util.*;
public class CheckedExceptionMain {

	public static void main(String[] args) throws PrimeNumberException
	{
		int possiblePrime1 = 5;
		int possiblePrime2 = 8;
		int multiplicationResult = 0;
		Set<Integer> primeNumberSet = new HashSet<>();
		primeNumberSet.add(2);
		primeNumberSet.add(3);
		buildPrimeSet(primeNumberSet, 100);
		try
		{
			multiplicationResult = multiplyPrimes(possiblePrime1, possiblePrime2, primeNumberSet);
		}
		catch (PrimeNumberException PNE)
		{
			PNE.printStackTrace();
		}
		finally
		{
			System.out.println(multiplicationResult);
		}
	}
	
	//build a set of all primes up to a maxValue so that we can linear search our 
	public static void buildPrimeSet(Set<Integer> newSet, int maxValue)
	{
		for (int a = 5; a <= maxValue; a+=2)
		{
			boolean aIsPrime = true;
			for (Integer b: newSet)
			{
				if(a % b == 0 && a != b)	//if a is divisble by b and a is also not b 
				{
					aIsPrime = false;
				}
			}
			if (aIsPrime)
			{
				newSet.add(a);
			}
		}
	}
	
	public static int multiplyPrimes(int firstPrime, int secondPrime, Set<Integer> primeSet) throws PrimeNumberException
	{
		boolean firstIsPrime = false;
		boolean secondIsPrime = false;
		for (int i: primeSet)
		{
			if (i == firstPrime)
			{
				firstIsPrime = true;
			}
			if (i == secondPrime)
			{
				secondIsPrime = true;
			}
		}
		if(firstIsPrime && secondIsPrime)
		{
			return firstPrime * secondPrime;
		}
		else if (!firstIsPrime && secondIsPrime)
		{
			throw new PrimeNumberException(firstPrime + " is not prime");
		}
		else if (firstIsPrime && !secondIsPrime)
		{
			throw new PrimeNumberException(secondPrime + " is not prime");
		}
		else
		{
			throw new PrimeNumberException(firstPrime + " & " + secondPrime + " are not prime");
		}
		
			
	}

}
