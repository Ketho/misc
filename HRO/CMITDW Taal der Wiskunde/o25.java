// opdracht 2.5; Sinus hyperbolicus
// Math.pow(Math.E, x) == Math.exp(x)
// (Math.exp(x) - Math.exp(-x)) / 2 == Math.sinh(x)
public class o25
{
	public static void main(String[] args)
	{
		for (int i=0; i<=10; i++)
			System.out.println(i+"\t"+sinh(i));
	}
	
	public static double sinh(double x)
	{
		return (emacht(x) - emacht(-x)) / 2;
		//return (Math.exp(x) - Math.exp(-x)) / 2; // cheat
		//return Math.sinh(x); // more cheating
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

