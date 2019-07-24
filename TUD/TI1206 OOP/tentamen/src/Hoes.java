import java.io.PrintWriter;
import java.util.Scanner;

public class Hoes extends Product
{
	private String type;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Constructor
	 */
	public Hoes(String kleur, double prijs, String type)
	{
		super(kleur, prijs);
		this.type = type;
	}
	
	@Override
	public String toString()
	{
		return "<HOESJE>\r\n"
			+"\t<PRIJS>"+super.getPrijs()+"</PRIJS>\r\n"
			+"\t<KLEUR>"+super.getKleur()+"</KLEUR>\r\n"
			+"\t<TYPE>"+type+"</TYPE>\r\n"
			+"</HOESJE>\r\n";
	}
	
	/**
	 * Reads any and all objects from a file
	 * @param fileName the file to read from
	 * @return returns the object back
	 */
	public static Hoes readFile(Scanner sc)
	{
		String kleur = null;
		double prijs = 0;
		String model = null;
		
		for (int i=0; i<3; i++)
		{
			sc.next(); // skip whitespace and newline
			String key = sc.next(); // read the xml key
			
			if (key.equals("KLEUR"))
				kleur = sc.next();
			// scan for int or double since we are not sure whether there is a dot in the number
			// apparently the BlackBoard version has ints and the paper version has doubles...
			else if (key.equals("PRIJS"))
				prijs = sc.hasNextDouble() ? sc.nextDouble() : (double) sc.nextInt();
			else if (key.equals("TYPE"))
				model = sc.next();
			
			sc.nextLine(); // skip closing key and move to next line
		}
		
		return new Hoes(kleur, prijs, model);
	}
	
	public static Hoes readInput(Scanner sc)
	{
		System.out.println("Wat is de kleur?");
		String kleur = sc.next();
		
		System.out.println("Hoe duur is de hoes?");
		double prijs = sc.hasNextDouble() ? sc.nextDouble() : (double) sc.nextInt();
		
		System.out.println("Voor welk type (iPhone/iPad) is de hoes?");
		String type = sc.next();
		
		return new Hoes(kleur, prijs, type);
	}
	
	// I am lazy and reuse the toString method
	public void writeFile(PrintWriter pw)
	{
		pw.print(this);
	}
}
