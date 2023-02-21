import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("resource")	//closing system.in scanner stream breaks the main loop
public class RectangleMain 
{
	
	public static void main(String[] args) 
	{
		ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();	//create an ArrayList to store Rectangle objects
		Scanner menuScanner = new Scanner(System.in);
		do
		{
			displayMenu();	
			
			int menuChoice = menuScanner.nextInt();	//get user input
			switch(menuChoice)
			{
			case 1:
				rectangleList.add(addRectangle());
				break;
			case 2:
				showRectangles(rectangleList);
				endProgram();
			case 3:
				endProgram();
			}
		} while(true);	//keeps the program running if 1 is continually entered
		
	}
	
	public static void displayMenu()	//put all the main menu text in one file for ease of integration into main loop
	{
		System.out.println("## Rectangle Program ##\n");
		System.out.println("1. Enter Rectangle Details");
		System.out.println("2. Show All Rectangles");
		System.out.println("3. Exit Program\n");
		System.out.println("Choose an option:\n");
	}
	
	public static void showRectangles(ArrayList<Rectangle> rectangles)
	{
		Collections.sort(rectangles);	//sort using rectangle's compareTo()
		for(Rectangle rect: rectangles)
		{
			System.out.println(rect.toString());	//toString includes formatting to 2 decimal places
		}
	}
	
	public static void endProgram()
	{
		System.exit(0);
	}
	
	public static Rectangle addRectangle()
	{
		boolean validLength = false;	//exit conditions for do/while loops that confirm correct addition of rectangle
		boolean validWidth = false;
		float nextLength = 0.0f;	//used for input to new Rectangle(). Needs to be initialised here with an invalid value to force it into a valid state
		float nextWidth = 0.0f;
		Scanner rectangleScanner = new Scanner(System.in);	//get a keyboard scanner
		do
		{			
			System.out.println("Enter the length of the new rectangle: ");	//ask for the length
			String nextLengthString = rectangleScanner.next();	//save it as a string
			try
			{
				nextLength = Float.parseFloat(nextLengthString);	//try and convert. If it fails because it's not a number, it'll trigger the catch and then jump back to the start?				
				if (nextLength <= 0.0f)
				{
					System.out.println("length must be positive");
				}
				else
				{
					validLength = true;
				}
								
			}
			catch(NumberFormatException nfe)
			{
				System.out.println(nextLengthString + " is not able to be converted to float, enter a valid number");
			}
			
		} while (validLength == false);
		
		do
		{
			System.out.println("Enter the width of the new rectangle: ");
			String nextWidthString = rectangleScanner.next();
			try
			{
				nextWidth = Float.parseFloat(nextWidthString);
				if (nextWidth <= 0.0f)
				{
					System.out.println("width must be positive");
				}
				else
				{
					validWidth = true;
				}
				
			}
			catch (NumberFormatException nfe)
			{
				System.out.println(nextWidthString + " is not able to be converted to float, enter a valid number");
			}
		} while (validWidth == false);
		Rectangle rect = new Rectangle(nextLength, nextWidth);	
		System.out.println("Rectangle added successfully");
		return rect;
		
	}
}