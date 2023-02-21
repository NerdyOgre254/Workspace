import java.util.HashSet;
import java.util.Set;

//this shows the output with one prime number and one nonprime number
public class NoPrimeTest 
{
	public static void main(String[] args) throws PrimeNumberException 
	{
		int firstNumber = 255;	//not a prime number
		int secondNumber = 42;	//not a prime number
		Set<Integer> primeNumberSet = new HashSet<>();
		PrimeNumber p = new PrimeNumber(firstNumber, secondNumber, primeNumberSet);
		System.out.println(p.getProduct());		//expected output: 255 & 42 are not prime
	}
}