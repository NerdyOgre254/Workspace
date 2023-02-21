import java.util.Scanner;


public class QuotientWithException 
{
	public static int quotient(int number1, int number2)
	{
		if (number2 == 0)
		{
			throw new ArithmeticException("Divisor cannot be zero");
		}
		return number1 / number2;
	}

	public static void main(String[] args) 
	{
		

	}

}
