import java.util.*;

public class PrimeNumber 
{
	private int product;
	
	public PrimeNumber(int firstNumber, int secondNumber, Set<Integer> buildSet) throws PrimeNumberException
	{
		//build a prime set from the bigger of the two numbers
		if (firstNumber < secondNumber)
		{
			buildPrimeSet(buildSet, secondNumber);
		}
		else
		{
			buildPrimeSet(buildSet, firstNumber);
		}
		product = primeProduct(firstNumber, secondNumber, buildSet);
	}
	
	public int getProduct()
	{
		return product;
	}
	
	//this method takes two numbers, identifies if they are in the provided set of prime numbers, and throws out exceptions 
	//if one or both are not prime numbers
	public static int primeProduct(int firstPrime, int secondPrime, Set<Integer> primeSet) throws PrimeNumberException
	{
		//start with false until we can prove true
		boolean isFirstPrime = false;
		boolean isSecondPrime = false;
		
		//iterate through the provided primeSet, using a linear search to see if they're in that set
		for (int i: primeSet)
		{
			if (i == firstPrime)
			{
				isFirstPrime = true;
			}
			if (i == secondPrime)
			{
				isSecondPrime = true;
			}
		}
		
		//after searching through the primeSet we know whether each number is prime or not, and we can send our exception
		if(isFirstPrime && isSecondPrime)
		{
			return firstPrime * secondPrime;
		}
		else if (!isFirstPrime && isSecondPrime)
		{
			throw new PrimeNumberException(firstPrime + " is not a prime number");
		}
		else if (isFirstPrime && !isSecondPrime)
		{
			throw new PrimeNumberException(secondPrime + " is not prime");
		}
		else
		{
			throw new PrimeNumberException(firstPrime + " & " + secondPrime + " are not prime");
		}
		
	}
	
	//this method takes a maximum value and from that builds a set of all prime numbers
	public static void buildPrimeSet(Set<Integer> newSet, int maxValue)
	{
		//2 and 3 are the first two primes and these are used to build the remaining set up to maxValue
		newSet.add(2);
		newSet.add(3);
		
		//for each new number 'a' up to our maxValue, test whether every number 'b' in the set before it is a divisor. 
		//Assume it is prime until a divisor shows otherwise
		for (int a = 5; a <= maxValue; a += 2)	//note the +2 iterator, prevents testing even numbers which we know to be nonprime 
		{
			boolean aIsPrime = true;
			for (Integer b: newSet)
			{
				if(a % b == 0 && a != b)	//if a is divisible by b then it's not prime and if a is also not b
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

}
