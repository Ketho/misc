// opdracht 2.4; e^x
// Math.pow(Math.E, x) == Math.exp(x)
public class o24
{
	public static double[] t = {
		0,
		4,
		-1, // 1/e
		.5, // Math.sqrt(e)
	};
	
	public static void main(String[] args)
	{
		for (int i=0; i<=3; i++)
		{
			System.out.println(t[i]+"\t"+emacht(t[i]));
			//System.out.println(t[i]+"\t"+Math.exp(t[i])); // cheat
		}
	}
	
	public static double emacht(double x)
	{
		double sum = 0;
		for (int n=0; n<=50; n++) // 25 to 50 iterations is sufficient
			sum += Math.pow(x, n) / factorial(n);
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

