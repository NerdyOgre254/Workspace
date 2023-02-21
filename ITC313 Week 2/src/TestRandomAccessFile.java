import java.io.*;

public class TestRandomAccessFile 
{
	public static void main(String[] args) throws IOException 
	{
		try	(
			RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");	
			)
		{
			//clear the file to destroy old contents if it exists
			inout.setLength(0);
			
			//write new integers for the file
			for (int i = 0; i < 200; i++)
			{
				inout.writeInt(i);
			}
			
			//display current file length
			System.out.println("Current file length is " + inout.length());
			
			//retrieve the first number
			inout.seek(0);	//move the file pointer to the beginning
			System.out.println("The first number is " + inout.readInt());	//note that readInt advances the file pointer
			
			//retrieve the second number
			inout.seek(1 * 4);	//moves the file pointer to the second number
			System.out.println("The second number is " + inout.readInt());
			
			//retrieve the tenth number
			inout.seek(9 * 4);
			System.out.println("the tenth number is " + inout.readInt());
			
			//modify the eleventh number
			inout.writeInt(555);
			
			//append a new number
			inout.seek(inout.length());
			inout.writeInt(999);
			
			//display the new length
			System.out.println("The new length is " + inout.length());
			
			//retrieve the new eleventh number
			inout.seek(10*4);
			System.out.println("the eleventh number is " + inout.readInt());
		}
	}

}
