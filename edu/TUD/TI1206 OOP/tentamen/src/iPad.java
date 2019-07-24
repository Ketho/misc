import java.io.PrintWriter;
import java.util.Scanner;

public class iPad extends Device
{
	boolean retina;
	boolean internet4g;
	
	public boolean isRetina()
	{
		return retina;
	}
	public void setRetina(boolean retina)
	{
		this.retina = retina;
	}
	
	public boolean isInternet4g()
	{
		return internet4g;
	}
	public void setInternet4g(boolean internet4g)
	{
		this.internet4g = internet4g;
	}
	
	public iPad(String kleur, double prijs, String model, int capaciteit, double grootteScherm, String processor, boolean retina, boolean internet4g)
	{
		super(kleur, prijs, model, capaciteit, grootteScherm, processor);
		this.retina = retina;
		this.internet4g = internet4g;
	}
	
	@Override
	public String toString()
	{
		return "<IPAD>\r\n"
			+"\t<PRIJS>"+super.getPrijs()+"</PRIJS>\r\n"
			+"\t<KLEUR>"+super.getKleur()+"</KLEUR>\r\n"
			+"\t<MODEL>"+super.getModel()+"</MODEL>\r\n"
			+"\t<GEHEUGEN>"+super.getCapaciteit()+"</GEHEUGEN>\r\n"
			+"\t<SCHERMGROOTTE>"+super.getGrootteScherm()+"</SCHERMGROOTTE>\r\n"
			+"\t<PROCESSOR>"+super.getProcessor()+"</PROCESSOR>\r\n"
			+"\t<RETINA>"+retina+"</RETINA>\r\n"
			+"\t<4G>"+internet4g+"</4G>\r\n"
			+"</IPAD>\r\n";
	}
	
	/**
	 * Reads any and all objects from a file
	 * @param fileName the file to read from
	 * @return returns the object back
	 */
	public static iPad readFile(Scanner sc)
	{
		String kleur = null;
		double prijs = 0;
		String model = null;
		int capaciteit = 0;
		double grootte = 0;
		String processor = null;
		boolean retina = false;
		boolean internet4g = false;
		
		for (int i=0; i<8; i++)
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
			else if (key.equals("RETINA"))
				retina = sc.next().equals("YES");
			else if (key.equals("4G"))
				internet4g = sc.next().equals("YES");
			
			sc.nextLine(); // skip closing key and move to next line
		}
		
		return new iPad(kleur, prijs, model, capaciteit, grootte, processor, retina, internet4g);
	}
	
	public static iPad readInput(Scanner sc)
	{
		System.out.println("Wat is de kleur?");
		String kleur = sc.next();
		
		System.out.println("Hoe duur is de iPad?");
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
		
		System.out.println("Zit er een retina scherm in? (ja/nee)");
		boolean retina = sc.next().equals("ja");
		
		System.out.println("Ondersteunt de iPad 4G? (ja/nee)");
		boolean internet4g = sc.next().equals("ja");
		
		return new iPad(kleur, prijs, model, capaciteit, grootte, processor, retina, internet4g);
	}
	
	// I am lazy and reuse the toString method
	public void writeFile(PrintWriter pw)
	{
		pw.print(this);
	}
}
