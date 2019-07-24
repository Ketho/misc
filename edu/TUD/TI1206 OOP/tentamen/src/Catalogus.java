import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class that controls an ArrayList of products.
 * Can read, write from file, and read from user input
 */
public class Catalogus
{
	private ArrayList<Product> productList;

	/** getter
	 * @return returns an ArrayList
	 */
	public ArrayList<Product> getProductList()
	{
		return productList;
	}
	/** setter
	 * @param productList sets an ArrayList
	 */
	public void setProductList(ArrayList<Product> productList)
	{
		this.productList = productList;
	}
	
	/** 
	 * Constructor
	 */
	public Catalogus()
	{
		this.productList = new ArrayList<Product>();
	}
	
	public void voegToe(Product p)
	{
		if (!productList.contains(p))
			productList.add(p);
	}
	
	@Override
	public String toString()
	{
		String s = "<CATALOGUS>\r\n";
		
		for (int i=0; i<productList.size(); i++)
			s += productList.get(i);
		
		return s+"</CATALOGUS>";
	}
	
	/**
	 * Reads any and all objects from a file
	 * @param fileName the file to read from
	 * @return returns the object back
	 */
	public static Catalogus readFile(String fileName)
	{
		Catalogus cat = null;
		Scanner scanFile;
		
		try
		{
			scanFile = new Scanner(new File(fileName));
			cat = new Catalogus();
			
			while (scanFile.hasNext())
			{
				String s = scanFile.next();
				scanFile.useDelimiter("<|>"); // use delimiter to match xml keys and values
				
				if (s.equals("<HOESJE>"))
					cat.voegToe(Hoes.readFile(scanFile));
				else if (s.equals("<IPHONE>"))
					cat.voegToe(iPhone.readFile(scanFile));
				else if (s.equals("<IPAD>"))
					cat.voegToe(iPad.readFile(scanFile));
				
				scanFile.reset(); // reset to default delimiters
			}
			
			scanFile.close();
		}
		catch (IOException e)
		{
			System.err.println("Dit is een onjuiste bestandsnaam! "+e.getMessage());
		}
		
		return cat;
	}
	
	// if I was lazy I would just use toString here as well
	public void writeFile(String fileName)
	{
		try
		{
			PrintWriter pw = new PrintWriter(fileName);
			
			pw.println("<CATALOGUS>");
			
			for (int i=0; i<productList.size(); i++)
			{
				Product p = productList.get(i);
				if (p instanceof Hoes)
					((Hoes)p).writeFile(pw);
				else if (p instanceof iPhone)
					((iPhone)p).writeFile(pw);
				else if (p instanceof iPad)
					((iPad)p).writeFile(pw);
			}
			
			pw.println("</CATALOGUS>");
			
			pw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
