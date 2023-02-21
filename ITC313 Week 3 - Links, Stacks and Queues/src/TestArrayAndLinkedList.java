import java.util.*;

public class TestArrayAndLinkedList 
{
	public static void main(String[] args) 
	{
		List<Integer> arrayList = new ArrayList<>();	//create an Integer List
		arrayList.add(1);	//1 is autoboxed to new Integer(1)
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);	//adds 10 at linked list position 0
		arrayList.add(3, 30);
		
		System.out.println("A list of intergers in the array list:");
		System.out.println(arrayList);
		
		LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green"); //adds the element to the front of the list
		
		System.out.println("Display the linked list forward");
		ListIterator<Object> listIterator = linkedList.listIterator();	//make an Iterator object for linkedList
		while (listIterator.hasNext())
		{
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		
		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious())
		{
			System.out.print(listIterator.previous() + " ");
		}

	}

}
