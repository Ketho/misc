public class o2
{
	public static int n = 600; // amount of terms
	public static int i = 2; // start from 3rd term
	
	public static void main(String[] args)
	{
		System.out.println("i\tn-2\tn-1\tn");
		func1(1, 3); // t1 = 1, t2 = 3
	}
	
	// (n * t(n-1)) / t(n-2)
	public static void func1(double a, double b)
	{
		i++;
		double c = (i*b) / a;
		System.out.println(i+"\t"+a+"\t"+b+"\t"+c);
		
		if (i < n)
			func1(b, c);
	}
}

