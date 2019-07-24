import java.util.Scanner;

/** Class that represents an appartment/home
 * and shows for what amount of money it can be bought.
 * Contains an Adres object.
 */
public class Woning
{
	private Adres adres;
	private int kamers;
	private int vraagprijs;
	
	/** Getter
	 * @return returns the house address
	 */
	public Adres getAdres() {return adres;}
	
	/**	Setter
	 * @param adres sets the house address
	 */
	public void setAdres(Adres adres) {	this.adres = adres;}
	
	/** Getter
	 * @return returns the amount of rooms in the house
	 */
	public int getKamers() {return kamers;}
	
	/** Setter
	 * @param kamers amount of rooms to set
	 */
	public void setKamers(int kamers) {this.kamers = kamers;}
	
	/** Getter
	 * @return returns the listed selling price of the house
	 */
	public int getVraagprijs() {return vraagprijs;}
	
	/** Setter
	 * @param vraagprijs sets the selling price of the house
	 */
	public void setVraagprijs(int vraagprijs) {	this.vraagprijs = vraagprijs;}
	
	/**	Constructor for instantiated objects
	 * @param	adres sets the house address
	 * @param	kamers sets amount of rooms
	 * @param	vraagprijs sets listed selling price
	 */
	public Woning(Adres adres, int kamers, int vraagprijs)
	{
		this.adres = adres;
		this.kamers = kamers;
		this.vraagprijs = vraagprijs;
	}
	
	/** Shows if a house can be bought for a certain amount of money
	 * @param	prijs the amount of money to compare with
	 * @return	returns whether the listed selling price is lower (or equal) than the argument
	 */
	public boolean kostHooguit(int prijs)
	{
		return vraagprijs <= prijs;
	}
	
	/**	Reads Woning fields (including an Adres object) from a Scanner object
	 * and creates from them a Woning object
	 * @param sc Scanner object to read from
	 * @return returns the Woning object read
	 */
	public static Woning read(Scanner sc)
	{
		// first read the Adres tokens
		Adres adr = Adres.read(sc);
		
		// read the Woning tokens
		int kamers = sc.nextInt();
		sc.next(); // skip "kamers" token
		sc.next(); // skip "prijs" token
		int prijs = sc.nextInt();
		
		return new Woning(adr, kamers, prijs);
	}
	
	/** Overrides the toString method
	 * @return returns the string representation of the object
	 */
	public String toString()
	{
		return adres+", "+kamers+" kamers, prijs "+vraagprijs;
	}
	
	/** Overrides the equals method
	 * @param	obj compares if the object is of the same type and then compares it
	 * @return	whether both objects are equal
	 */
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Woning))
			return false;
		
		Woning won = (Woning) obj;
		
		boolean isAdres = (adres.equals(won.adres));
		boolean isKamers = (kamers == won.kamers);
		boolean isVraagprijs = (vraagprijs == won.vraagprijs);
		
		return (isKamers && isVraagprijs && isAdres);
	}
}
