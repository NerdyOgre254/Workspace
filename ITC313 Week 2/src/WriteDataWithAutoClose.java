import java.io.*;

public class WriteDataWithAutoClose 
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("scores.txt");
		if (file.exists())
		{
			System.out.println("file already exists");
			System.exit(0);
		}
		
		try (PrintWriter output = new PrintWriter(file);)
		{
			output.print("A A A ");
			output.println(90);
			output.print("B B B ");
			output.println(85);
		}
	}
}
