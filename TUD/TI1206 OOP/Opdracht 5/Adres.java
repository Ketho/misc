import java.util.Scanner;

/** Class that represents a home/apartement address.
 * Can be contained in a Woning object.
 */
public class Adres
{
	private String straat;
	private String huisnummer;
	private String postcode;
	private String plaats;
	
	/** Getter
	 * @return returns the street name part of the address
	 */
	public String getStraat() {return straat;}
	
	/** Setter
	 * @param straat sets the street name
	 */
	public void setStraat(String straat) {this.straat = straat;}
	
	/** Getter
	 * @return returns the house number part of the address
	 */
	public String getHuisnummer() {return huisnummer;}
	
	/** Setter
	 * @param huisnummer sets the house number
	 */
	public void setHuisnummer(String huisnummer) {this.huisnummer = huisnummer;}
	
	/** Getter
	 * @return returns the postal code part of the address
	 */
	public String getPostcode() {return postcode;}
	
	/** Setter
	 * @param postcode sets the postal code
	 */
	public void setPostcode(String postcode) {this.postcode = postcode;}
	
	/** Getter
	 * @return returns the city/settlement name part of the address
	 */
	public String getPlaats() {return plaats;}
	
	/** Setter
	 * @param plaats sets the city/settlement name
	 */
	public void setPlaats(String plaats) {this.plaats = plaats;}
	
	/**	Constructor for new instantiated objects
	 * @param straat sets the street name
	 * @param huisnummer sets the house number
	 * @param postcode sets the postal code
	 * @param plaats sets the city/settlement name
	 */
	public Adres(String straat, String huisnummer, String postcode, String plaats)
	{
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.plaats = plaats;
	}
	
	/**	Reads Adres fields from a Scanner object and creates from them a Woning object
	 * @param sc Scanner object to read from
	 * @return returns the Adres object read
	 */
	public static Adres read(Scanner sc)
	{
		// read the Adres tokens
		String straat = sc.next();
		String nr = sc.next();
		String pc = sc.next();
		String plaats = sc.next();
		
		return new Adres(straat, nr, pc, plaats);
	}
	
	/**	
	 * @return returns the string representation of the object
	 */
	public String toString()
	{
		return straat+" "+huisnummer+" "+postcode+" "+plaats;
	}
	
	/**	
	 * @param	obj compares if the object is of the same type and then compares it
	 * @return	whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Adres))
			return false;
		
		Adres adr = (Adres) obj;
		
		boolean isStraat = (straat.equals(adr.straat));
		boolean isHuisnummer = (huisnummer.equals(adr.huisnummer));
		boolean isPostcode = (postcode.equals(adr.postcode));
		boolean isPlaats = (plaats.equals(adr.plaats));
		
		return (isStraat && isHuisnummer && isPostcode && isPlaats);
	}
}
