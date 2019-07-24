import java.util.Collections;

public class ThreadType implements Runnable
{
	private Catalogus cat;
	
	public ThreadType(Catalogus cat)
	{
		this.cat = cat;
	}
	
	@Override
	public void run()
	{
		FilterType();
		
		System.out.println("... de catalogus is nu gesorteerd per type/model!");
		System.out.println(cat);
	}

	// synchronization of method
	public synchronized void FilterType()
	{
		Collections.sort(cat.getProductList(), new ComparatorType());
	}
}
