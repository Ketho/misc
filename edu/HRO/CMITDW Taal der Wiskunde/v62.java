// vraag 6.2; reeksen
public class v62
{
	public static void main(String[] args)
	{
		int c = 5;
		reeks1(c);
		reeks2(c);
		reeks3(c);
	}
	
	public static void reeks1(int a)
	{
		System.out.println("// n^2");
		for (int n=1; n<=a; n++)
			System.out.println(n+"\t"+(int) Math.pow(n, 2));
	}
	
	public static void reeks2(int a)
	{
		System.out.println("// 3n-1");
		for (int n=1; n<=a; n++)
			System.out.println(n+"\t"+(3*n - 1));
	}
	
	public static void reeks3(int a)
	{
		System.out.println("// 2^n");
		for (int n=1; n<=a; n++)
			System.out.println(n+"\t"+(int) Math.pow(2, n));
	}	
}

