import java.util.Scanner;

public class ScannerTestClass {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a byte value");
		byte byteVal = input.nextByte();
		System.out.print(byteVal);
		
		
		input.close();
	}

}
