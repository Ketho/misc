import java.util.Comparator;

public class ComparatorPrijs implements Comparator<Product>
{
	public int compare(Product a, Product b)
	{
		double pa = a.getPrijs();
		double pb = b.getPrijs();
		
		return pa<pb ? -1 : pa == pb ? 0 : 1;
	}
}
