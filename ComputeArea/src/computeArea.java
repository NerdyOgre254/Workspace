import java.util.Scanner;
public class computeArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		double radius;
		double area;
		double perimeter;
		double pi = 3.141592653;

		System.out.println("Enter a radius for perimeter and area: ");	//request for input
		radius = input.nextDouble();	//input moved to radius 
		perimeter = radius * pi * 2;
		area = radius * radius * pi;
		System.out.println("For radius " + radius + " the perimeter is " + perimeter + " and the area is " + area + "cm^2");

			
		input.close();  //closing the scanner for memory leak reasons.

	}

}
