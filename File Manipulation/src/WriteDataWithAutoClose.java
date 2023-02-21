import java.io.*;		//sick of writing java.io every time

public class WriteDataWithAutoClose {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		File file = new File("scores2.txt");
		if(file.exists()) 
		{
			System.out.println("File already exists");
			System.exit(0);
		}		
		try (PrintWriter output = new PrintWriter(file))
		{
			output.print("John T Smith ");
			output.println("90");
			output.print("Eric K JOnes ");
			output.println("85");
		}
	}

}
