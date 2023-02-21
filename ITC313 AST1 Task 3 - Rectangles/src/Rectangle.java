
public class Rectangle implements Comparable<Rectangle>
{	
	private float length;
	private float width;
	private float area;
	
	//Constructor
	public Rectangle(float length, float width)
	{
		setLength(length);
		setWidth(width);
		this.area = length * width;
	}
	
	//getters
	public float getLength()
	{
		return length;
	}
	
	public float getWidth()
	{
		return width;
	}
	
	public float getArea()
	{
		return area;
	}
	
	//setters
	public void setLength(float length)
	{
		if (length > 0.0f)
		{
			this.length = length;
		}
		else
		{
			throw new IllegalArgumentException(length + " is not a valid measurement");
		}
	}
	
	public void setWidth(float width)
	{
		if (width > 0.0f)
		{
			this.width = width;
		}
		else
		{
			throw new IllegalArgumentException(width + " is not a valid measurement");
		}
	}
	
	//Comparable Interface methods
	public boolean equals(Object o)
	{
		Rectangle rect = (Rectangle) o;		//cast Object as Rectangle
		return (this.length == rect.getLength() && this.width == rect.getWidth());	//testing that both length and width are the same. No need to test Area as it's an attribute created by the other two
	}

	@Override
	public int compareTo(Rectangle rect) //compare using area of rectangle
	{
		if (this.area > rect.getArea())
		{
			return 1;
		}
		else if (this.area < rect.getArea())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		String formattedLength = String.format("%.2f", length);
		String formattedWidth = String.format("%.2f", width);
		String formattedArea = String.format("%.2f", area);
		return "Length: " + formattedLength + "cm, Width: " + formattedWidth + "cm, Area: " + formattedArea + "cm";
	}

}
