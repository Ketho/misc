import java.util.Comparator;

public class ComparatorType implements Comparator<Product>
{
	public int compare(Product a, Product b)
	{
		String sa = "", sb = "";
		
		// cast to either Hoes or Device first
		if (a instanceof Hoes)
			sa = ((Hoes)a).getType();
		else if (a instanceof Device)
			sa = ((Device)a).getModel();
		
		if (b instanceof Hoes)
			sb = ((Hoes)b).getType();
		else if (b instanceof Device)
			sb = ((Device)b).getModel();
		
		// return string comparison of a to b
		return sa.compareTo(sb);
	}
}
