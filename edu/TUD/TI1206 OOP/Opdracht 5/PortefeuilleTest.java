import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PortefeuilleTest
{
	@Test
	public void testConstructorPortefeuille()
	{
		// create an (empty) Portefeuille object
		Portefeuille port = new Portefeuille();
		assertNotNull(port.getWoningList()); // instantiated ArrayList exists
	}
	
	@Test
	public void testVoegToe()
	{
		Portefeuille port = new Portefeuille();
		
		Adres adr1 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won2 = new Woning(adr2, 5, 2000);
		
		port.voegToe(won1);
		
		// test adding the same Woning object multiple times
		port.voegToe(won2);
		port.voegToe(won2);
		port.voegToe(won2);
		port.voegToe(won2);
		
		// amount of Woning objects has to be 2 and not 5
		assertEquals(2, port.getWoningList().size());
		
		// compare string representations
		String expected1 = "Cornelis Drebbelweg 4 2628CD Delft, 5 kamers, prijs 2000"; 
		String expected2 = "Mekelweg 4 2628CD Delft, 5 kamers, prijs 2000";
		
		assertEquals(expected1, port.getWoningList().get(0).toString());
		assertEquals(expected2, port.getWoningList().get(1).toString());
	}
	
	@Test
	public void testWoningenTot()
	{
		Portefeuille port = new Portefeuille();
		
		Adres adr1 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won2 = new Woning(adr2, 5, 4000);
		
		Adres adr3 = new Adres("Weena", "664", "3012CN", "Rotterdam");
		Woning won3 = new Woning(adr3, 20, 3000);
		
		// add Woning objects
		port.voegToe(won1);
		port.voegToe(won2);
		port.voegToe(won3);
		
		// call the woningenTot method
		ArrayList<Woning> woningList = port.woningenTot(3500);
		
		// amount of Woning objects has to be 2 and not 3
		assertEquals(2, woningList.size());
		
		// compare string representations
		String expected1 = "Cornelis Drebbelweg 4 2628CD Delft, 5 kamers, prijs 2000"; 
		String expected2 = "Weena 664 3012CN Rotterdam, 20 kamers, prijs 3000";
		
		assertEquals(expected1, woningList.get(0).toString());
		assertEquals(expected2, woningList.get(1).toString());
		
		// call the woningenTot method with a negative amount of money
		ArrayList<Woning> woningList2 = port.woningenTot(-3500);
		assertEquals(0, woningList2.size()); // this should be empty
		
		// call the woningenTot method with a low budget
		ArrayList<Woning> woningList3 = port.woningenTot(500);
		assertEquals(0, woningList3.size()); // this should be empty
	}
	
	@Test
	public void testRead()
	{
		// call the Portefeuille.read method
		Portefeuille port = Portefeuille.read("data.txt");
		
		// get reference for faster lookup
		ArrayList<Woning> woningList = port.getWoningList();
		
		// amount of Woning objects has to be 3
		assertEquals(3, woningList.size());
		
		// compare string representations
		String expected1 = "Emmalaan 23 3051JC Rotterdam, 7 kamers, prijs 300000";
		String expected2 = "Javastraat 88 4078KB Eindhoven, 3 kamers, prijs 50000";
		String expected3 = "Javastraat 93 4078KB Eindhoven, 4 kamers, prijs 55000";
		
		assertEquals(expected1, woningList.get(0).toString());
		assertEquals(expected2, woningList.get(1).toString());
		assertEquals(expected3, woningList.get(2).toString());
	}
	
	@Test
	public void testToString()
	{
		Portefeuille port = new Portefeuille();
		
		Adres adr1 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won2 = new Woning(adr2, 5, 4000);
		
		// add Woning objects
		port.voegToe(won1);
		port.voegToe(won2);
		
		// compare string representations
		String expected = "Cornelis Drebbelweg 4 2628CD Delft, 5 kamers, prijs 2000"
			+"\nMekelweg 4 2628CD Delft, 5 kamers, prijs 4000";
		
		assertEquals(expected, port.toString());
	}
	
	@Test
	public void testEquals()
	{
		Portefeuille port1 = new Portefeuille();
		Portefeuille port2 = new Portefeuille();
		
		Adres adr1 = new Adres("Cornelis Drebbelweg", "4", "2628CD", "Delft");
		Woning won1 = new Woning(adr1, 5, 2000);
		
		Adres adr2 = new Adres("Mekelweg", "4", "2628CD", "Delft");
		Woning won2 = new Woning(adr2, 5, 4000);
		
		// add Woning objects
		port1.voegToe(won1);
		port1.voegToe(won2);
		
		port2.voegToe(won1);
		port2.voegToe(won2);
		
		assertEquals(port1, port2);
		
		// not equals
		Portefeuille port3 = new Portefeuille();
		
		Adres adr3 = new Adres("Mekelpark", "4", "2628CD", "Delft");
		Woning won3 = new Woning(adr3, 5, 4000);
		
		port3.voegToe(won1);
		port3.voegToe(won3);
		
		assertNotEquals(port1, port3);
	}
}
