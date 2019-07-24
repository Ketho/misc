import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class WoningTest
{
	@Test
	public void testConstructorWoning()
	{
		Adres a = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning w = new Woning(a, 5, 2000);
		
		// test Adres fields
		assertEquals("Mekelweg", w.getAdres().getStraat());
		assertEquals("4", w.getAdres().getHuisnummer());
		assertEquals("2628CD", w.getAdres().getPostcode());
		assertEquals("Delft", w.getAdres().getPlaats());
		
		// test Woning fields
		assertEquals(2000, w.getVraagprijs());
		assertEquals(5, w.getKamers());
	}
	
	@Test
	public void testEquals()
	{
		Adres adr1 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won2 = new Woning(adr2, 5, 2000);
		
		assertEquals(won1, won2);
		
		// not equals
		Adres adr3 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		Woning won3 = new Woning(adr3, 5, 2000);
		assertNotEquals(won1, won3);
	}
	
	@Test
	public void testToString()
	{
		Adres adr1 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		String expected = "Mekelweg 4 2628CD Delft, 5 kamers, prijs 2000";
		
		assertEquals(expected, won1.toString());
	}
	
	@Test
	public void testKostHooguit()
	{
		Adres a = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning w = new Woning(a, 5, 2000);
		
		int prijs1 = 2500;
		assertTrue(w.kostHooguit(prijs1));
		
		int prijs2 = 750;
		assertFalse(w.kostHooguit(prijs2));
	}
	
	@Test
	public void testRead()
	{
		String expected[] = {
			"Emmalaan 23 3051JC Rotterdam, 7 kamers, prijs 300000",
			"Mekelweg 4 2628CD Delft, 250 kamers, prijs 50000000",
			"Javastraat 88 4078KB Eindhoven, 3 kamers, prijs 50000",
			"Javastraat 93 4078KB Eindhoven, 4 kamers, prijs 55000",
			"Cornelis_Drebbelweg 5 2628CM Delft, 50 kamers, prijs 750000",
		};
		
		try
		{
			Scanner scan = new Scanner(new File("TestFileWoning.txt"));
			ArrayList<Woning> woningList = new ArrayList<Woning>();
			
			// read any and all Woning objects
			while (scan.hasNext())
				woningList.add(Woning.read(scan));
			
			for (int i=0; i<woningList.size(); i++)
				assertEquals(expected[i], woningList.get(i).toString());
			
			scan.close(); // done
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadEmpty()
	{
		Scanner scan = new Scanner("");
		ArrayList<Woning> woningList = new ArrayList<Woning>();
		
		// read any and all Woning objects
		while (scan.hasNext())
			woningList.add(Woning.read(scan));
		
		assertEquals(0, woningList.size());
		scan.close(); // done
	}
}
