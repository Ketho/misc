// hoofdstuk 6; Fibonacci
public class x6
{
	public static void main(String[] args)
	{
		// zeroth and first term
		System.out.println("fibonacci 1:");
		System.out.println(0+"\t"+0.0);
		System.out.println(1+"\t"+1.0);
		fibo1(0, 1);
		
		System.out.println("\nfibonacci 2:\n"+10+"\t"+fibo2(10));
	}
	
	public static int i = 1;
	public static int max = 100;
	
	public static void fibo1(double a, double b)
	{
		i++;
		System.out.println(i+"\t"+(a+b));
		if (i < max)
			fibo1(b, a+b);
	}
	
	// might not be very efficient
	public static double fibo2(int v)
	{
		if (v == 0 || v == 1)
			return v;
		else
			return fibo2(v-2) + fibo2(v-1);
	}
}

