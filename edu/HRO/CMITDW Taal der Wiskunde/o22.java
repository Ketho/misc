// opdracht 2.2; Productsymbool
public class o22
{
	public static void main(String[] args)
	{
		System.out.println(product(1, 99));
	}
	
	public static double product(int a, int b)
	{
		double sum = 1;
		for (int i=a; i<=b; i++)
		{
			sum *= (double) i / (i + 1);
			System.out.println(i+"\t"+sum);
		}
		return sum;
	}
}

