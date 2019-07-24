// opdracht 6.1; reeksen
public class o61
{
	public static void main(String[] args)
	{
		int n = 20;
		reeks1(n);
		reeks2(n);
		reeks3(n);
	}
	
	public static void reeks1(int a)
	{
		System.out.println("// de natuurlijke getallen die niet te delen zijn door 4 of 5");
		int n = 0, i = 0;
		
		while (n < a)
		{
			i++;
			if (i%4 > 0 && i%5 > 0)
			{
				n++;
				System.out.println(n+"\t"+i);
			}
		}
	}
	
	public static void reeks2(int a)
	{
		// http://www.wolframalpha.com/input/?i=1%2C-2%2C4%2C-8%2C16%2C-32%2C...
		System.out.println("\n// 1, -2, 4, -8, 16, -32, ...");
		for (int n=1; n<=a; n++)
			System.out.println(n+"\t"+(int) (Math.pow(-1, n-1) * Math.pow(2, n-1)));
	}
	
	public static void reeks3(int a)
	{
		System.out.println("\n// sqrt(2n - 1)");
		for (int n=1; n<=a; n++)
			System.out.println(n+"\t"+Math.sqrt(2*n - 1));
	}
}

