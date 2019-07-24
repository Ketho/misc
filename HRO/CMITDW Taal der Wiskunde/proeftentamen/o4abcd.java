public class o4abcd
{
	public static int n = 20; // amount of terms
	public static int i = 3; // start from 4th term
	
	public static void main(String[] args)
	{
		System.out.println("i\tn-3\tn-2\tn-1\tn\tisprime\tsum digits");
		func1(1, 1, 1); // t1 = 1, t2 = 1, t3 = 1
	}
	
	// (n * t(n-1)) / t(n-2)
	public static void func1(int a, int b, int c)
	{
		i++;
		int d = (c + b + a);
		System.out.println(i+"\t"+a+"\t"+b+"\t"+c+"\t"+d+"\t"+isprime(d)+"\t"+sumdigits(d));
		
		if (i < n)
			func1(b, c, d);
	}
	
	public static boolean isprime(int v)
	{
		for (int i=2; i<v; i++)
		{
			if (v%i == 0)
				return false;
		}
		return true;
	}
	
	public static int sumdigits(int d)
	{
		int sum = 0;
		// this is probably real ugly
		for (int i=1; i<=Math.log10(d)+1; i++)
		{
			int p = (int) Math.pow(10, i);
			int rest = d%p; // remainder
			d -= rest; // new number
			sum += rest / (p/10); // add digit
		}
		return sum;
	}
}

