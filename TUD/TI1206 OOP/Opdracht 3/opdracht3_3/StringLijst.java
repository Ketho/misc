package opdracht3_3;

public class StringLijst
{
	private String[] element;
	private int aantal; // current index for the element array
	
	// getters
	public String[] getElement() {return element;}
	public int getSize() {return aantal;}
	
	// constructor
	public StringLijst(int n)
	{
		aantal = 0; // amount/index starts at zero, regardless of (element < 0)
		element = (n > 0) ? new String[n] : new String[0];
	}
	
	// adds the value el into the first free element of String[] element
	public void add(String el)
	{
		// pre: aantal < capaciteit
		if (aantal < element.length)
		{
			element[aantal] = el;
			aantal++;
		}
	}
	
	// returns the value of the element at index i, otherwise returns null
	public String get(int i)
	{
		// pre: 0 <= i < aantal
		return (i>=0 && i<aantal) ? element[i] : null;
	}
	
	// sets the value (of the element at index i) to el
	public void set(int i, String el)
	{
		// pre: 0 <= i < aantal
		if (i>=0 && i<aantal)
			element[i] = el;
	}
	
	// returns the first encountered element index containing a given String value
	// if there is any in the array, otherwise returns -1
	public int index(String el)
	{
		for (int i=0; i<aantal; i++)
		{
			if (element[i] == el)
				return i;
		}
		
		return -1;
	}
	
	// returns whether an array has an element with value == el
	// reuse the index method
	public boolean contains(String el)
	{
		return index(el) != -1;
	}
	
	// compares the object type and the contents of two objects, whether they are equal
	// *use multiple return points for readability
	public boolean equals(Object obj)
	{
		// check if Object other is more specifically, a StringLijst object
		if (!(obj instanceof StringLijst))
			return false; // not the same object type
		
		// cast Object to StringLijst for the VM
		StringLijst lijst = (StringLijst) obj;
		
		// compare the aantal field; any differing capacity is not relevant
		boolean isAantal = (aantal == lijst.aantal);
		boolean isStringArray = true;
		// compare all Strings in both String[] arrays
		for (int i=0; i<aantal; i++)
			if (!element[i].equals(lijst.element[i])) // if not(equals)
				isStringArray = false;
		
		// compared everything now, both objects are equal
		return (isAantal && isStringArray);
	}
	
	// returns the string representation of an StringLijst object
	public String toString()
	{
		String s = "<StringLijst[";
		
		for (int i=0; i<aantal; i++)
		{
			// add prefixing comma only for second and higher elements
			if (i > 0)
				s += ",";
			
			s += element[i];
		}
		
		return s+"]>";
	}
}

