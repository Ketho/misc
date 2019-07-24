public class o3
{
	public static void main(String[] args)
	{
		System.out.println("f(x) = 0\t"+bisect(-50, 50));
	}
	
	// f(x) = x^3 + 40x^2 + 10
	public static double func1(double x)
	{
		return Math.pow(x, 3) + 40*Math.pow(x, 2) + 10;
	}
	
	public static double bisect(double left, double right)
	{
		double mid = (left + right) / 2;
		double fmid = func1(mid);
		
		System.out.println(left+"\t"+right+"\t"+mid+"\t"+fmid);
		
		// avoid infinite loop to zero
		if (fmid > 1e-7) // .0000001
			return bisect(left, mid);
		else if (fmid < -1e-7)
			return bisect(mid, right);
		else
			return mid;
	}
}

