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
public class Property 
{
	
	private String propertyName, city, owner; 
	private double rentAmount; 
	private Plot plot;
	
	public Property()
	{
		this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName; 
		this.city = city; 
		this.rentAmount = rentAmount; 
		this.owner = owner; 
        this.plot = new Plot(); 
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{

		this.propertyName = propertyName; 
		this.city = city; 
	    this.rentAmount = rentAmount;
		this.owner = owner; 
	    this.plot = new Plot(x, y, width, depth);
	}	
	
	public Property(Property otherProperty)
	{
		propertyName = otherProperty.propertyName; 
		city = otherProperty.city;
		rentAmount = otherProperty.rentAmount;
		owner = otherProperty.owner; 
	}
	
	public Plot getPlot()
	{
		return plot; 
	}
	
	public String getPropertyName()
	{
		return propertyName; 
	}
	
	public String getCity()
	{
		return city; 
	}
	
	public double getRentAmount()
	{
		return rentAmount; 
	}
	
	public String getOwner()
	{
		return owner; 
	}
	
	public String toString()
	{
	    return "[" + propertyName + "]," + "[" + city + "]," + "[" + owner + "]," + "[" + rentAmount + "]";
	}
		
	
	
}
