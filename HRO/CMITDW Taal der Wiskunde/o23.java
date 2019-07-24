// opdracht 2.3; e^3
// Math.pow(Math.E, x) == Math.exp(x)
public class o23
{
	public static void main(String[] args)
	{
		System.out.println(emacht(0, 28)); // 20.08553692318766
		//System.out.println(Math.exp(3)); // cheat
	}
	
	public static double emacht(int a, int b)
	{
		double sum = 0;
		for (int n=a; n<=b; n++)
		{
			sum += Math.pow(3, n) / factorial(n);
			System.out.println(n+"\t"+sum+"\t"+Math.pow(3,n)/factorial(n)+"\t"+(Math.exp(3)-sum));
		}
		return sum;
	}
	
	public static double factorial(int n)
	{
		double sum = 1;
		for (int i=2; i<=n; i++)
			sum *= i;
		return sum;
	}
}

