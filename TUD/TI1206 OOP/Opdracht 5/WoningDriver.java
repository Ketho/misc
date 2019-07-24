import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/** Class that contains the main method controlling the logic for driving
 * the Portefeuille, Woning and Adres classes
 */
public class WoningDriver
{
	/**	Asks the user for a maximum price for a Woning, then returns a list of buyable Woning objects
	 * By reading a (text) file with tokens and creating Woning objects from them and then filtering them by the max price given
	 * @param args Any inline args passed to the main method (unused)
	 */
	public static void main(String[] args)
	{
		Portefeuille port = Portefeuille.read("data.txt");
		
		// ask for the maximum appartment price
		System.out.println("Wat is de maximale prijs?");
		
		// read the max price input
		int maxPrijs = 0;
		Scanner scan = new Scanner(System.in); // use the InputStream
		try
		{
			maxPrijs = scan.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Dit is niet een valide prijs...");
		}
		
		scan.close(); // done
		
		// create a new ArrayList of Woning objects that cost below the max price given
		ArrayList<Woning> woningList = port.woningenTot(maxPrijs);
		
		// now show the buyable Woning objects
		for (int i=0; i<woningList.size(); i++)
			System.out.println(woningList.get(i));

	}
}
