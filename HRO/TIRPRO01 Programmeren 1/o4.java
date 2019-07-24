// opdracht 4; Binomium van Newton
public class o4
{
	public static void main(String[] args)
	{
		System.out.println(factorial(3)); // 6.0
		System.out.println(binomial(5, 3)); // 10.0
		System.out.println(binomium(2, 1, 2)); // 9.0
	}
	
	public static double factorial(int n)
	{
		double sum = 1;
		for (int i=2; i<=n; i++) // overflow vanaf 171
			sum *= i;
		return sum;
	}
	
	public static double binomial(int a, int b)
	{
		return factorial(a) / (factorial(b) * factorial(a-b));
	}
	
	public static double binomium(int n, int a, int b)
	{
		double sum = 0;
		for (int k=0; k<=n; k++)
			sum += binomial(n, k) * Math.pow(a, k) * Math.pow(b, n-k);
		return sum;
	}
}

