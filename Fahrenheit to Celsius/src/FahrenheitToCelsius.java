import java.util.Scanner;

public class FahrenheitToCelsius {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);	//get a new scanner reading keyboard input
		
		System.out.print("Enter degree in Fahrenheit");
		double fahrenheit = input.nextDouble();
		
		//convert to celsius
		double celsius = (5.0/9) * (fahrenheit - 32);
		System.out.print(celsius);
				
		input.close();  //scanner close, stop memory leaks

	}

}
