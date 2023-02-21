import java.io.*;	//import all elements of java.io
import java.net.*;	//import all elements of java.net
import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) 
	{
		String firstName;
		String lastName;
		String postcodeString;
		int postcode;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first name ");
		firstName = input.next();
		System.out.println("Enter a last name ");
		lastName = input.next();
		System.out.println("Enter a postcode ");
		postcode = Integer.parseInt(input.next());
		
		Person testPerson = new Person(firstName, lastName, postcode);


	}

}
