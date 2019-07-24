/** Class that contains only date format strings (DD/MM/YYYY).
 * Can be contained in a DateSet object.
 */
public class Date
{
	private String date;
	
	/** Getter
	 * @return returns current date
	 */
	public String getDate() {return date;}
	
	/** Setter
	 * @param dt sets the date
	 */
	public void setDate(String dt) {date = dt;}
	
	/**	Constructor for new instantiated objects
	 * @param dt sets the date
	 */
	public Date(String dt)
	{
		date = dt;
	}
	
	/**
	 * @return returns the raw string representation of the object
	 */
	public String toString()
	{
		return date;
	}
	
	/**
	 * @param obj compares if the object is of the same type and then compares it
	 * @return whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		// check if both objects are of the same type
		if (!(obj instanceof Date))
			return false;
		
		// cast Object to Date for the VM
		Date dt = (Date) obj;
		
		// compare both strings
		return date.equals(dt.date);
	}
}
