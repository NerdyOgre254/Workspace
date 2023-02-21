import java.util.HashSet;
import java.util.Set;

//this shows the output with two prime numbers
public class TwoPrimeTest 
{
	public static void main(String[] args) throws PrimeNumberException 
	{
		int firstNumber = 97;	//prime number 1
		int secondNumber = 41;	//prime number 2
		Set<Integer> primeNumberSet = new HashSet<>();
		PrimeNumber p = new PrimeNumber(firstNumber, secondNumber, primeNumberSet);
		System.out.println(p.getProduct());	//expected output 3977
	}

}
