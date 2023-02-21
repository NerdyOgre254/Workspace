
public class Person 
{
	private String firstName;
	private String lastName;
	private int postcode;
	
	public Person(String firstName, String lastName, int postcode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		setPostcode(postcode);
	}
	
	public void setPostcode(int postcode)
	{
		if ((postcode < 0) || (postcode > 8000))
		{
			throw new IllegalArgumentException("Postcode out of permissible range");
		}
		else
		{
			this.postcode = postcode;
		}
	}
	
	public String toString()
	{
		return firstName + " " + lastName + ", postcode: " + postcode;
	}
}
