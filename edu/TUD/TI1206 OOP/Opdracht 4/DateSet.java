import java.util.ArrayList;

/** Class that organizes Date objects.
 * Can contain Date objects.
 * Can be contained in Person objects.
 */
public class DateSet
{
	// not shown in UML specification
	private ArrayList<Date> dateList;
	
	/** Getter
	 * @return returns the ArrayList object
	 */
	public ArrayList<Date> getDateSet() {return dateList;}
	
	/** Setter
	 * @param ps sets the ArrayList object
	 */
	public void setDateSet(ArrayList<Date> ds) {dateList = ds;}
	
	// no constructor actually needed in this case
	/**	Constructor for new instantiated objects, also sets the ArrayList
	 */
	public DateSet()
	{
		dateList = new ArrayList<Date>();
	}
	
	/**	Adds dates to the DateSet object
	 * @param dt adds the date element to ArrayList
	 */
	public void add(Date dt)
	{
		dateList.add(dt);
	}
	
	/**	Returns whether a date is contained in the datelist
	 * @param dt the date to be checked
	 */
	public boolean contains(Date dt)
	{
		return dateList.contains(dt);
	}
	
	// 
	/**	Returns a new ArrayList that contains the intersecting elements of two DateSets
	 * @param ds the dateset to intersect with
	 */
	public DateSet intersection(DateSet ds)
	{
		DateSet intersect = new DateSet();
		
		for (int i=0; i<ds.dateList.size(); i++)
		{
			Date element = ds.dateList.get(i);
			
			if (dateList.contains(element))
				intersect.add(element);
		}
		
		return intersect;
	}
	
	/**
	 * @return returns the string representation of the object
	 */
	public String toString()
	{
		String s = "<DateSet[";
		
		for (int i=0; i<dateList.size(); i++)
		{
			// add prefixing comma only for second and higher elements
			if (i > 0)
				s += ",";
			
			s += dateList.get(i);
		}
		
		return s+"]>";
	}
	
	/**	
	 * @param	obj compares if the object is of the same type and then compares it
	 * @return	whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		// check if both objects are of the same type
		if (!(obj instanceof DateSet))
			return false;
		
		// cast Object to DateSet for the VM
		DateSet ds = (DateSet) obj;
		
		// compare size
		boolean isSize = dateList.size() == ds.dateList.size();
		
		boolean isDateList = true;
		// order of the elements has to be corresponding
		for (int i=0; i<dateList.size(); i++)
		{
			if (!(dateList.get(i).equals(ds.dateList.get(i))))
			{
				isDateList = false;
				break;
			}
		}
		
		// compared everything now, both objects are equal
		return (isSize && isDateList);
	}
}
