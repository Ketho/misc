import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest
{
	@Test
	public void testConstructorPerson()
	{
		Person ps = new Person("Sophia");
		assertEquals("Sophia", ps.getName());
	}
	
	@Test
	public void testSetDateSet()
	{
		Person ps = new Person("Sarah");
		DateSet ds = new DateSet();
		
		ps.setDateSet(ds);
		
		assertEquals(ds, ps.getDateSet());
	}
	
	@Test
	public void testAdd()
	{
		Person ps = new Person("Summer");
		DateSet ds = new DateSet();
		Date dt = new Date("4/7/2014");
		
		ps.setDateSet(ds);
		ps.add(dt);
		
		// first object is a DateSet object
		// second object is a ArrayList<Date> object
		assertEquals("4/7/2014", ps.getDateSet().getDateSet().get(0).toString());
	}
	
	@Test
	public void testToString()
	{
		Person ps = new Person("Seira");
		assertEquals("Seira", ps.toString());
	}
	
	@Test
	public void testEquals()
	{
		Person ps1 = new Person("Sona");
		Person ps2 = new Person("Sona");
		
		assertEquals(ps1, ps2);
	}
	
	// only one Person contains a DateSet
	@Test
	public void testNotEquals()
	{
		Person ps1 = new Person("Shana");
		Person ps2 = new Person("Shana");
		
		DateSet ds1 = new DateSet();
		ps1.setDateSet(ds1);
		
		assertNotEquals(ps1, ps2);
	}
}
