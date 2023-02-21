
public class WriteData {

	public static void main(String[] args) throws java.io.IOException 
	{
		java.io.File file = new java.io.File("scores.txt");
		if (file.exists())
		{
			System.out.println("File already exists");
			System.exit(1);
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		output.print("A A A");
		output.println(90);
		output.print("B B B");
		output.print(85);
		
		output.close();
		

	}

}
