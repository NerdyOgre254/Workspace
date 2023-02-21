
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] sampleList = {1, 3, 4, 5, 6, 7, 8, 9, 10};
		int outNum = binarySearch(sampleList, 2);
		System.out.println(outNum);

	}
	
	public static int binarySearch(int[] list, int key)
	{
		int low = 0;
		int high = list.length - 1;
		
		while(high >= low)
		{
			int mid = (low + high) / 2;
			if (key < list[mid])	//if key is less than middle of array
			{
				high = mid - 1;	//make the high point the midpoint and keep low the same
			}
			else if (key == list[mid])	//if the key is the midpoint
			{
				return mid;		//return the midpoint
			}
			else	//last case: key is more than mid
			{
				low = mid++; //move the low point to just above the mid
			}
			
		}
		
		return -low - 1;	//return the index of the matching key
	}
	
}
