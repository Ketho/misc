// opdracht 2.1; Factorial
public class o21
{
	public static void main(String[] args)
	{
		for (int i=0; i<=200; i++) // overflow after 171
		{
			System.out.println(i+"\t"+factorial(i));
		}
	}
	
	public static double factorial(int n)
	{
		double sum = 1;
		for (int i=2; i<=n; i++)
			sum *= i;
		return sum;
	}
}

