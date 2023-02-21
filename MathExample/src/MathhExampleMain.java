import java.lang.Math;
import java.util.Scanner;

public class MathhExampleMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Give me an int");
		double newDouble = input.nextFloat();
		
		double newDoubleSquared = Math.pow(newDouble,  2);
		System.out.println(newDoubleSquared);
		input.close();
	}

}
