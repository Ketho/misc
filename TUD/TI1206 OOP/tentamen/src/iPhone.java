import java.io.PrintWriter;
import java.util.Scanner;

public class iPhone extends Device
{
	public iPhone(String kleur, double prijs, String model, int capaciteit, double grootteScherm, String processor)
	{
		super(kleur, prijs, model, capaciteit, grootteScherm, processor);
	}
	
	@Override
	public String toString()
	{
		return "<IPHONE>\r\n"
			+"\t<PRIJS>"+super.getPrijs()+"</PRIJS>\r\n"
			+"\t<KLEUR>"+super.getKleur()+"</KLEUR>\r\n"
			+"\t<MODEL>"+super.getModel()+"</MODEL>\r\n"
			+"\t<GEHEUGEN>"+super.getCapaciteit()+"</GEHEUGEN>\r\n"
			+"\t<SCHERMGROOTTE>"+super.getGrootteScherm()+"</SCHERMGROOTTE>\r\n"
			+"\t<PROCESSOR>"+super.getProcessor()+"</PROCESSOR>\r\n"
			+"</IPHONE>\r\n";
	}
	
	/**
	 * Reads any and all objects from a file
	 * @param fileName the file to read from
	 * @return returns the object back
	 */
	public static iPhone readFile(Scanner sc)
	{
		String kleur = null;
		double prijs = 0;
		String model = null;
		int capaciteit = 0;
		double grootte = 0;
		String processor = null;

		
		for (int i=0; i<6; i++)
		{
			sc.next(); // skip whitespace and newline
			String key = sc.next(); // read the xml key
			
			if (key.equals("KLEUR"))
				kleur = sc.next();
			else if (key.equals("PRIJS"))
				prijs = sc.hasNextDouble() ? sc.nextDouble() : (double) sc.nextInt();
			else if (key.equals("MODEL"))
					model = sc.next();
			else if (key.equals("GEHEUGEN"))
				capaciteit = sc.nextInt();
			else if (key.equals("SCHERMGROOTTE"))
				grootte = sc.nextDouble();
			else if (key.equals("PROCESSOR"))
				processor = sc.next();
			
			sc.nextLine(); // skip closing key and move to next line
		}
		
		return new iPhone(kleur, prijs, model, capaciteit, grootte, processor);
	}
	
	public static iPhone readInput(Scanner sc)
	{
		System.out.println("Wat is de kleur?");
		String kleur = sc.next();
		
		System.out.println("Hoe duur is de iPhone? (Alleen ints, graag. Want de Locale klopt niet)");
		double prijs = sc.hasNextDouble() ? sc.nextDouble() : (double) sc.nextInt();
		
		System.out.println("Welke model/generatie?");
		sc.nextLine(); // skip to next line for future nextLine call 
		String model = sc.nextLine();
		
		System.out.println("Wat is de geheugencapaciteit?");
		int capaciteit = sc.nextInt();
		
		System.out.println("Wat is de schermgrootte?");
		double grootte = sc.nextInt();
		
		System.out.println("Welke processor zit in de iPhone?");
		String processor = sc.next();
		
		return new iPhone(kleur, prijs, model, capaciteit, grootte, processor);
	}
	
	// I am lazy and reuse the toString method
	public void writeFile(PrintWriter pw)
	{
		pw.print(this);
	}
}
