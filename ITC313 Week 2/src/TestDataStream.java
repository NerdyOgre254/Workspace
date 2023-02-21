import java.io.*;

public class TestDataStream 
{
	/* 
	 * External File -> FileInputStream(0100110...) -> DataInputStream (int, double, string)
	 * 
	 * DataOutputStream -> FileOutputStream -> External File
	 */

	public static void main(String[] args) throws IOException
	{
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));)	//create an output stream for file temp.dat
		{
			//write the student scores to the file
			output.writeUTF("John");
			output.writeDouble(85.5);
			output.writeUTF("Jim");
			output.writeDouble(195.5);
			output.writeUTF("George");
			output.writeDouble(105.25);			
		}
		
		try (DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));)
		{
			//read the test scores from the file
			System.out.println(input.readUTF() + " " + input.readDouble());
			System.out.println(input.readUTF() + " " + input.readDouble());
			System.out.println(input.readUTF() + " " + input.readDouble());
		}
	}

}
