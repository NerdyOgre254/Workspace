public class PrimeNumbersMain {

	public static boolean isThisPrime(int potentialPrime)
	{
		boolean isPrime = true;
		//not a prime if 1 or less
		if (potentialPrime == 2)	//exit for 2 and confirm as prime
		{
			System.out.println("2 is the starter prime number, dummy");
			return isPrime;
		}
		else if((potentialPrime < 2) || (potentialPrime % 2 == 0))	//exclude even numbers and numbers less than 2 as not prime  
		{
			System.out.println("numbers 1 and below, and even numbers, cannot be prime");
			isPrime = false;
		}
		else for (int i = 3; i < potentialPrime; i+= 2)	//start at 3, end at the number passed to the method, iterating by 2 each time because there's no point checking even numbers now
		{
			System.out.println("testing " + potentialPrime + " divisble by " + i);
			if (potentialPrime % i == 0)	//if dividing argument int by i produces no remainder it's not a prime
			{
				isPrime = false;
				break;	//no point calculating if you get a divisor early on
			}
		}
		
		
		return isPrime;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(isThisPrime(77));
	}

}
