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


public class ManagementCompany 
{
		
	 static final int MAX_PROPERTY = 5;
	  static int MGMT_WIDTH = 10, count = 0;
	  static int MGMT_DEPTH = 10;

	    private String companyName;
	    private String taxId;
	    private double mgmFee;
	    
	    private Property[] properties;
	    private Plot plot;
	    private int numberOfProperties;
	
	 
 // Constructors
	    public ManagementCompany() 
	    {
	        this.companyName = "";
	        this.taxId = "";
	        this.mgmFee = 0.0;
	        this.properties = new Property[MAX_PROPERTY];
	        this.plot = new Plot(0, 0, 1, 1);
	    }
	    
	    // Constructor 2
	    public ManagementCompany(String companyName, String taxId, double mgmFee) 
	    {
	        this.companyName = companyName;
	        this.taxId = taxId;
	        this.mgmFee = mgmFee;
	        this.properties = new Property[MAX_PROPERTY];
	        this.plot = new Plot(0, 0, 10, 10);
	    }

	 // Constructor 3
	    public ManagementCompany(String companyName, String taxId, double mgmFee, int x, int y, int width, int depth) 
	    {
	    	properties = new Property[MAX_PROPERTY];
	        this.companyName = companyName;
	        this.taxId = taxId;
	        this.mgmFee = mgmFee;
	        this.plot = new Plot(x, y, width, depth);

	    }

	    // Constructor 4
	    public ManagementCompany(ManagementCompany otherCompany) 
	    {
	        this.companyName = otherCompany.companyName;
	        this.taxId = otherCompany.taxId;
	        this.mgmFee = otherCompany.mgmFee;
	        this.properties = new Property[MAX_PROPERTY];
	        this.plot = new Plot(otherCompany.plot);
	        this.numberOfProperties = otherCompany.numberOfProperties;
	        
	       
	    }
	
	// Start of methods
	

    public int addProperty(Property property) 
    {
        if (numberOfProperties >= MAX_PROPERTY) 
        {
            return -1; // Array is full
        }

        if (property == null) 
        {
            return -2; // Property object is null
        }

        if (!plot.encompasses(property.getPlot())) 
        {
            return -3; // Management company does not encompass property plot
        }

        for (int i = 0; i < numberOfProperties; i++) 
        {
            if (properties[i].getPlot().overlaps(property.getPlot())) 
            {
                return -4; // Property plot overlaps with an existing property
            }
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; // Return the index where the property was added
    }

    public int addProperty(String propertyName, String city, double rent, String owner) 
    {
        return addProperty(new Property(propertyName, city, rent, owner));
    }

    
    
    public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) 
    {
        return addProperty(new Property(propertyName, city, rent, owner, x, y, width, depth));
    }
	

    public Property getHighestRentProperty() 
    {
        if (numberOfProperties == 0) 
        {
            return null; // No properties
        }

        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) 
            {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }
	
	public double getMgmFeePer()
	{
        return mgmFee;

	}
	
	
	public String getName()
	{
		return companyName; 
	}
	
	
	public Plot getPlot()
	{
		return plot; 
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	
	public int getPropertiesCount()
	{
        return numberOfProperties;

	}
	
	public String getTaxID()
	{
		return taxId; 
	}
	
	public double getTotalRent() 
	{
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }
	
	public boolean isMangementFeeValid()
	{
        return mgmFee >= 0 && mgmFee <= 100;
	}
	
	public boolean isPropertiesFull() 
	{
        return numberOfProperties >= MAX_PROPERTY;
    }
	
	
	public void removeLastProperty() 
	{
        if (numberOfProperties > 0) 
        {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }


	
	public String toString()
	{
		   String result = "List of the properties for " + companyName + ", taxID: " + taxId + "\n" +
                   "______________________________________________________\n";

   for (int i = 0; i < numberOfProperties; i++) 
   {
       Property property = properties[i];
       result += property.toString() + "\n";
   }

   result += "______________________________________________________\n\n" +
             " total management Fee: " + getMgmFeePer();

   return result;
	}
}
