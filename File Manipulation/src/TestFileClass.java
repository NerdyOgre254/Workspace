import java.io.*;	//import all java.io libraries

public class TestFileClass 
{
	public static void main(String[] args)
	{
		File file = new File("muckabout.txt");	//create a new file called muckabout.txt
		System.out.println("Does it Exist? " + file.exists());				//check whether the file exists
		System.out.println("The file has " + file.length() + " bytes");		//check the length of the file
		System.out.println("Can it be read? " + file.canRead());			//check if the file can be read
		System.out.println("Can it be written? " + file.canWrite());		//check if the file can be written
		System.out.println("Is it a directory? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("is it absolute? " + file.isAbsolute());
		System.out.println("is it hidden? " + file.isHidden());
		System.out.println("Absolute path is " + file.getAbsolutePath());
		System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
		
	}

}
