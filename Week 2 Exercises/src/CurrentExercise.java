import java.util.*;
import java.lang.*;
import java.io.*;

public class CurrentExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File targetDir = new File(args[0]);
		if(targetDir.isDirectory())
		{
			File[] targetDirFiles = targetDir.listFiles();
			
			for (int i = 0; i < targetDirFiles.length; i++)
			{
				System.out.println(targetDirFiles[i].getName());
			}
		}

	}

}
