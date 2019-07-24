import java.util.ArrayList;

/** Class that handles Person objects and their DateSet objects.
 * It can compare the open dates between Person objects. 
 * Can contain Person objects.
 */
public class DatePicker
{
	// constructor not shown in UML specification
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	/** Getter
	 * @return returns the ArrayList object
	 */
	public ArrayList<Person> getPerson() {return personList;}
	
	/** Setter
	 * @param ps sets the ArrayList object
	 */
	public void setPerson(ArrayList<Person> ps) {personList = ps;}
	
	/** Adds a Person object to the ArrayList
	 * @param p adds the person object
	 */
	public void add(Person p)
	{
		personList.add(p);
	}
	
	/** Shows a set of dates that are common between a group of persons
	 * If there is only 1 person then just return their DateSet
	 * @return returns a DateSet with the intersecting dates
	 */
	public DateSet commonDates()
	{
		DateSet intersect = new DateSet();
		
		// size == 0; return an empty DateSet object
		// size == 1; return all dates from a single person
		if (personList.size() >= 1)
		{
			intersect = personList.get(0).getDateSet();
			
			// 2 persons and more
			for (int i=1; i<personList.size(); i++)
			{
				DateSet ds = personList.get(i).getDateSet();
				intersect = ds.intersection(intersect);
			}
		}
		
		return intersect;
	}
	
	/**
	 * @return returns the string representation of the object
	 */
	public String toString()
	{
		String s = "<DatePicker[";
		
		for (int i=0; i<personList.size(); i++)
		{
			// add prefixing comma only for second and higher elements
			if (i > 0)
				s += ",";
			
			s += personList.get(i);
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
		if (!(obj instanceof DatePicker))
			return false;
		
		DatePicker dp = (DatePicker) obj;
		
		// compare size
		boolean isSize = (personList.size() == dp.personList.size());
		
		boolean isPersonList = true;
		// order of the elements has to be corresponding
		for (int i=0; i<personList.size(); i++)
		{
			if (!(personList.get(i).equals(dp.personList.get(i))))
			{
				isPersonList = false;
				break;
			}
		}
		
		// compared everything now, both objects are equal
		return (isSize && isPersonList);
	}
}
