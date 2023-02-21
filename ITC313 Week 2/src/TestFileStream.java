import java.io.*;

public class TestFileStream 
{
	public static void main(String[] args) throws IOException
	{
		try (FileOutputStream output = new FileOutputStream("temp.dat");)	//create an output stream to the file, also creates the file
		{
			output.write(-1);	//okay I thought I could be a smartass and force an exit but this just gives 255
			for (int i = 1; i <=10; i++)
			{
				output.write(i);	//output values to the file
			}
		}
		try (FileInputStream input = new FileInputStream("temp.dat");)	//create an input stream to the file
		{
			int value;
			while ((value = input.read()) != -1)	//while the value being read into the input stream does not return -1
			{
				System.out.print(value + " ");	//print out the value in console
			}
		}
	}

}
