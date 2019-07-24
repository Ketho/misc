import java.util.Collections;

public class ThreadPrijs implements Runnable
{
	private Catalogus cat;
	
	public ThreadPrijs(Catalogus cat)
	{
		this.cat = cat;
	}
		
	@Override
	public void run()
	{
		FilterPrijs();
		
		System.out.println("... de catalogus is nu gesorteerd per prijs!");
		System.out.println(cat);
	}
	
	// synchronization of method
	public synchronized void FilterPrijs()
	{
		Collections.sort(cat.getProductList(), new ComparatorPrijs());
	}
}
