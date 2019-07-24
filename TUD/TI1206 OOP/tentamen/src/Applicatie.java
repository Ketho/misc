import java.util.Locale;
import java.util.Scanner;


/**
 * Main logic class for showing and navigating a command line menu
 */
public class Applicatie
{
	static String[] menu = {
		"1 - Voeg een nieuwe iPhone toe",
		"2 - voeg een nieuwe iPad toe",
		"3 - Print hele catalogus naar scherm (standaard, niet gesorteerd)",
		"4 - Print gesorteerd op type/model",
		"5 - Print gesorteerd op prijs",
		"6 - Schrijf naar file",
		"7 - Sluit programma",
	};
	
	public static void main(String[] args)
	{
		Scanner scanIn = new Scanner(System.in);
		
		// I sadly did not succeed in actually changing the decimal number format
		// this means we are not able to read double number types
		Locale.setDefault(new Locale("nl_NL"));
		
		String fileName;
		Catalogus cat = null;
		
		System.out.println("Wat is het XML bestand dat u wilt uitlezen?");
		do
		{
			fileName = scanIn.next();
			cat = Catalogus.readFile(fileName);
		}
		while(cat == null);
		
		boolean cont = true;
		
		do
		{
			int keuze = ShowMenu(scanIn);
			
			switch (keuze)
			{
				// read gadgets from system.in
				case 1:
					cat.voegToe(iPhone.readInput(scanIn)); break;
				case 2:
					cat.voegToe(iPad.readInput(scanIn)); break;
				
				// print whole catalogus
				case 3:
					System.out.println(cat); break;
				
				case 4:
					System.out.println("Catalogus wordt nu gesorteerd per type/model (alfabetisch) ...");
					Thread tt = new Thread(new ThreadType(cat));
					tt.start(); break;
				case 5:
					System.out.println("Catalogus wordt nu gesorteerd per prijs (laag naar hoog) ...");
					Thread tp = new Thread(new ThreadPrijs(cat));
					tp.start(); break;
				
				// write back to file
				case 6:
					cat.writeFile(fileName);
					System.out.println("De catalogus is nu terug naar het bestand geschreven.");
					break;
				
				// exit program
				case 7:
					cont = false;
					break;
				
				default:
					System.err.println("Dit is niet een juiste optie! Voer een getal [0-7] in.");
					break;
			}
		}
		while(cont);
		
		System.out.println("Applicatie afgesloten.");
	}
	
	/**
	 * keep showing menu until there is a valid input
	 * @param sc The scanner to use
	 * @return returns the choice for the menu
	 */
	public static int ShowMenu(Scanner sc)
	{
		System.out.println("\nMaak uw keuze:");
		
		for (int i=0; i<menu.length; i++)
			System.out.println(menu[i]);
		
		if (sc.hasNextInt())
			return sc.nextInt();
		else
			sc.next(); // skip token for future scans
		
		return -1;
	}
}
