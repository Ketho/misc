import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class AdresTest
{
	@Test
	public void testConstructorAdres()
	{
		Adres a = new Adres("Mekelweg", "4", "2628CD", "Delft");
		
		// test fields
		assertEquals("Mekelweg", a.getStraat());
		assertEquals("4", a.getHuisnummer());
		assertEquals("2628CD", a.getPostcode());
		assertEquals("Delft", a.getPlaats());
	}
	
	@Test
	public void testEquals()
	{
		Adres adr1 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		assertEquals(adr1, adr2);
		
		Adres adr3 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		assertNotEquals(adr1, adr3);
	}
	
	@Test
	public void testToString()
	{
		Adres adr1 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		String expected = "Mekelweg 4 2628CD Delft";
		
		assertEquals(expected, adr1.toString());
	}
	
	@Test
	public void testRead()
	{
		String expected[] = {
			"Emmalaan 23 3051JC Rotterdam",
			"Mekelweg 4 2628CD Delft",
			"Javastraat 88 4078KB Eindhoven",
			"Javastraat 93 4078KB Eindhoven",
			"Cornelis_Drebbelweg 5 2628CM Delft",
		};
		
		try
		{
			Scanner scan = new Scanner(new File("TestFileAdres.txt"));
			ArrayList<Adres> adresList = new ArrayList<Adres>();
			
			// read any and all Adres objects
			while (scan.hasNext())
				adresList.add(Adres.read(scan));
			
			for (int i=0; i<adresList.size(); i++)
				assertEquals(expected[i], adresList.get(i).toString());
			
			scan.close(); // done
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
