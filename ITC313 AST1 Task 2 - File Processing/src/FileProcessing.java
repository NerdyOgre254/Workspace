import java.io.*;
import java.util.Scanner;

public class FileProcessing 
{

	public static void main(String[] args) 
	{
		//Step one: ensure that there is a command line argument
		if(args.length == 0)
		{
			throw new IllegalArgumentException("This program needs a filename as command line arugment");
		}
		
		int fileLength = 0;	//variable to hold number of characters 
		File targetFile = new File(args[0]);	//make a File object to hold the 
		fileLength = readText(targetFile);
		if(fileLength >= 0)
		{
			System.out.println("File has " + fileLength + " characters,not including whitespace");
		}
	}

	public static int readText(File inputFile)
	{
		int fileCharLength = -1;	//declaring the return value as an illogical value to pass back to main
		try 
		{
			Scanner inputScan = new Scanner(inputFile);	//Scanner reading from file passed as argument to method
			while (inputScan.hasNext())	//stops reading past EOF
			{
				String nextWord = inputScan.next();	//Scanner defaults to delimiting whitespace, no need to change the delimiter
				fileCharLength += nextWord.length();	//add the 
			}
		} 
		catch (FileNotFoundException fnf) 
		{
			System.out.println("The text file does not exist, ending program.");
		}
		
		return fileCharLength;	//
	}
}