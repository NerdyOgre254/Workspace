
public class Point 
{
    private float x;
    private float y;
    
    public Point(float x, float y)
    {
        this.setX(x);
        this.setY(y);
    }
    
    public void setX(float x)
    {
        this.x = x;
    }
    
    public void setY(float y)
    {
        this.y = y;
    }
    
    public float getX()
    {
        return this.x;
    }
    
    public float getY()
    {
        return this.y;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("X=" + getX());
        sb.append(" Y=" + getY());
        return sb.toString();
    }

}
