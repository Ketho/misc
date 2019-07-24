/** Class that contains a Persons name and open dates.
 * Can contain a DateSet object.
 * Can be contained in DatePicker objects.
 */
public class Person
{
	private String name;
	private DateSet dateset; // not shown in UML specification
	
	/** Getter
	 * @return returns the name
	 */
	public String getName() {return name;}
	
	/** Setter
	 * @param s sets the name 
	 */
	public void setName(String s) {name = s;}
	
	/** Getter
	 * @return returns the dateset
	 */
	public DateSet getDateSet() {return dateset;}
	
	/** Setter
	 * @param ds sets the dateset 
	 */
	public void setDateSet(DateSet ds) {dateset = ds;}
	
	// the UML specification states there is a 1-on-1 relation for Person:DateSet
	// but still uses a constructor with just a String argument
	// so you can get NullPointerExceptions since calling setDateSet() is not required...
	/**	Constructor for new instantiated objects
	 * @param nm sets the name
	 */
	public Person(String nm)
	{
		name = nm;
	}
	
	/**	Constructor for new instantiated objects
	 * @param nm sets the name
	 * @param ds sets the dateset
	 */
	public Person(String nm, DateSet ds)
	{
		name = nm;
		dateset = ds;
	}
	
	/**	Adds dates to the DateSet object
	 * @param date adds this date
	 */
	public void add(Date date)
	{
		if (dateset != null)
			dateset.add(date);
	}
	
	/**
	 * @return returns the raw string representation of the object
	 */
	public String toString()
	{
		return name;
	}
	
	/**	
	 * @param	obj compares if the object is of the same type and then compares it
	 * @return	whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		// check if both objects are of the same type
		if (!(obj instanceof Person))
			return false;
		
		// cast Object to Person for the VM
		Person ps = (Person) obj;
		
		boolean isName = (name.equals(ps.name));
		
		boolean isDateSet;
		// conveniently use dateset equals method (provided both exist)
		if (dateset != null && ps.dateset != null)
			isDateSet = (dateset.equals(ps.dateset));
		else
			// only one of the datesets exists
			isDateSet = (dateset == null && ps.dateset == null);
		
		return (isName && isDateSet);
	}
}
