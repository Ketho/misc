// vraag 2.3; Productsymbool
public class v23
{
	public static void main(String[] args)
	{
		System.out.println("product 1 =\t"+product1(2, 5));
		System.out.println("product 2 =\t"+product2(1, 3));
		System.out.println("product 3 =\t"+product3(-100, 100));
	}
	
	public static int product1(int a, int b)
	{
		int sum = 1;
		for (int i=a; i<=b; i++)
		{
			sum *= i - 1;
			System.out.println(i+"\t"+sum);
		}
		return sum;
	}
	
	public static int product2(int a, int b)
	{
		int sum = 1;
		for (int i=a; i<=b; i++)
		{
			sum *= Math.pow(2, i);
			System.out.println(i+"\t"+sum);
		}
		return sum;
	}
	
	public static double product3(int a, int b)
	{
		double sum = 1;
		for (int i=a; i<=b; i++)
		{
			sum *= 100 * i;
			System.out.println(i+"\t"+sum);
		}
		return sum;
	}
}

