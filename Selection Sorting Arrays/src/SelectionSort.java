import java.lang.Math;

public class SelectionSort {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] practiceArray = createArray(10);
		sortArray(practiceArray);
		System.out.println();
		for (int i = 0; i < practiceArray.length; i++)
		{
			System.out.println(practiceArray[i]);
		}
	}
	
	public static int[] createArray(int arrayLength)	//create new array of ARGUMENT length of random integers between 1 and 100
	{
		int[] newArray = new int[arrayLength];
		for(int e: newArray)
		{
			newArray[e] = (int)(Math.random() * 100 + 1);
			System.out.println(newArray[e]);
		}
		return newArray;
	}
	
	//first crack at it, moving the lowest number
	public static void sortArray(int[] unsortedArray)
	{
		//create a new variable to hold temp assignments
		
		int lowest = unsortedArray[0];
		int lowestIndex = 0;
		
		//find the lowest number and its index
		for (int i = 0; i < unsortedArray.length; i++)
		{
			if (unsortedArray[i] < lowest)
			{
				lowest = unsortedArray[i];
				lowestIndex = i;
			}
		}
		
		unsortedArray[lowestIndex] = unsortedArray[0];
		unsortedArray[0] = lowest;
		
		//move the lowest number to the temp variable
		
		//move the first-index number to the index of the lowest number
		
		//move the temp variable to the first index
		
		
	}

}
