import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Class that contains a list of Woningen,
 * can read Woningen objects from a (text) file
 * and can filter this list by max price
 */
public class Portefeuille
{
	private ArrayList<Woning> woningList;
	
	/** Getter
	 * @return returns the ArrayList object
	 */
	public ArrayList<Woning> getWoningList() {return woningList;}
	
	/** Setter
	 * @param woningList sets the ArrayList object
	 */
	public void setWoningList(ArrayList<Woning> woningList) {this.woningList = woningList;}
	
	/**	Constructor for new instantiated objects, also sets the ArrayList
	 */
	public Portefeuille()
	{
		woningList = new ArrayList<Woning>();
	}
	
	/**	
	 * Adds a Woning object to the ArrayList woningList, but only if its unique to the ArrayList
	 * @param woning Woning object to add
	 */
	public void voegToe(Woning woning)
	{
		if (!woningList.contains(woning))
			woningList.add(woning);
	}
	
	/**	Returns a filtered ArrayList containing only Woning objects that are under a certain price
	 * @param maxprijs The maximum price the Woning objects have to be under
	 * @return Returns the filtered ArrayList 
	 */
	public ArrayList<Woning> woningenTot(int maxprijs)
	{
		ArrayList<Woning> filterWoning = new ArrayList<Woning>();
		
		for (int i=0; i<woningList.size(); i++)
		{
			// compare if the price is lower than the maximum price
			if (woningList.get(i).kostHooguit(maxprijs))
				filterWoning.add(woningList.get(i));
		}
		
		return filterWoning;
	}
	
	/**	Reads a (text) file with data containing information for the Woning and Adres objects
	 * by using the Scanner class.
	 * Any read objects will be added to the ArrayList in the new Portefeuille object returned
	 * @param infile The file name to read. Has to be in the project root folder
	 * @return returns the Portefeuille object containing any read objects
	 */
	public static Portefeuille read(String infile)
	{
		Portefeuille port = new Portefeuille();
		
		try
		{	
			// create the Scanner for the (text) file to read from
			Scanner scan = new Scanner(new File(infile));
			int numWoning = scan.nextInt(); // get the amount of Woningen objects to be read
			
			// read the Woningen objects and add them to the ArrayList in Portefeuille
			for (int i=0; i<numWoning; i++)
				port.voegToe(Woning.read(scan));
			
			scan.close(); // done, close the Scanner
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return port;
	}
	
	/** Overrides the toString method
	 * @return returns the string representation of the object
	 */
	public String toString()
	{
		String s = "";
		
		for (int i=0; i<woningList.size(); i++)
		{
			// add newline only for second and higher elements
			if (i > 0)
				s += "\n";
			
			s += woningList.get(i);
		}
		
		return s;
	}
	
	/** Overrides the equals method
	 * @param	obj compares if the object is of the same type and then compares it
	 * @return	whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Portefeuille))
			return false;
		
		Portefeuille port = (Portefeuille) obj;
		
		// compare size
		boolean isSize = woningList.size() == port.woningList.size();
		
		boolean isWoningList = true;
		// order of the elements has to be corresponding
		for (int i=0; i<woningList.size(); i++)
		{
			if (!woningList.get(i).equals(port.woningList.get(i)))
			{
				isWoningList = false;
				break;
			}
		}
		
		return (isSize && isWoningList);
	}
}
