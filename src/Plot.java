/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: A property management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap each other, and each property must be within the limits of the management company’s plot.  Write an application that lets the user create a management company and add the properties managed by the company to its list. Assume the maximum number of properties handled by the company is 5.  
 * Due: 10/23/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Matthew Mucha
*/
public class Plot 
{
	
	private int x, y, width, depth; 
	
	public Plot()
	{
		this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1; 
	}
	
	
	public Plot(int x, int y, int width,int depth)
	{
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth; 
	}
	
	public Plot(Plot otherPlot)
	{
		this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
	}
	
	
	
	public void setX(int x)
	{
		x = this.x; 
	}
	
	public void setY(int y)
	{
		y = this.y; 
	}
	
	public void setWidth(int width)
	{
		width = this.width; 
	}
	
	public void setDepth(int depth)
	{
		depth = this.depth; 
	}
	
	public int getX()
	{
		return x; 
	}
	
	public int getY()
	{
		return y; 
	}
	
	public int getWidth()
	{
		return width; 
	}
	
	public int getDepth()
	{
		return depth; 
	}
	
	
	public boolean overlaps(Plot otherPlot) 
	{
		  int thisX2 = this.x + this.width;
	        int thisY2 = this.y + this.depth;
	        int otherX2 = otherPlot.getX() + otherPlot.getWidth();
	        int otherY2 = otherPlot.getY() + otherPlot.getDepth();

	        return !(thisX2 <= otherPlot.getX() || this.x >= otherX2 ||
	                 thisY2 <= otherPlot.getY() || this.y >= otherY2);
	}
	
	
	public boolean encompasses(Plot otherPlot) 
	{
		int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int otherX2 = otherPlot.getX() + otherPlot.getWidth();
        int otherY2 = otherPlot.getY() + otherPlot.getDepth();

        return (this.x <= otherPlot.getX() && this.y <= otherPlot.getY() &&
                thisX2 >= otherX2 && thisY2 >= otherY2);
	}
	
	public String toString()
	{
		return "[" + this.x + "]," + "[" + this.y + "]," + "[" + this.width + "]," + "[" + this.depth + "]";
	}
	
	
}
