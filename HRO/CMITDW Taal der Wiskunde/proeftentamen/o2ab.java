public class o2ab
{
	public static void main(String[] args)
	{
		System.out.println(func1(-1));
		System.out.println(func1(1));
		System.out.println(bisect(5, -5)); // for some reason the positive and negative arguments are switched
	}
	
	public static double func1(double x)
	{
		double sum = 0;
		for (int i=3; i<=5; i++)
			sum += i / Math.pow(x, i);
		return sum;
	}
	
	public static double bisect(double left, double right)
	{
		double mid = (left + right) / 2;
		double fmid = func1(mid);
		
		System.out.println(left+"\t"+right+"\t"+mid+"\t"+fmid);
		
		if (fmid > 1 + 1e-7) // avoid infinite loop to zero
			return bisect(left, mid);
		else if (fmid < 1 - 1e-7)
			return bisect(mid, right);
		else
			return mid;
	}
}

