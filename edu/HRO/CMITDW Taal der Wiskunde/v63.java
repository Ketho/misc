// vraag 6.2; recursieve reeksen
public class v63
{
	public static void main(String[] args)
	{
		System.out.println("// n^2 - t(n-1), t(1) = 1");
		System.out.println(1+"\t"+1);
		init(1); reeks1(1);
		
		System.out.println("// t(n-1) + t(n-2), t(1) = 2, t(2) = 1");
		System.out.println(1+"\t"+2);
		System.out.println(2+"\t"+1);
		init(2); reeks2(2, 1);
		
		System.out.println("// S(i=1, n-1, t(i)), t(1) = 1");
		System.out.println(1+"\t"+1);
		init(1); array3[0] = 1; reeks3();
	}
	
	public static int i;
	public static int max = 5;
	
	public static void init(int begin)
	{
		i = begin;
		max = 5; // amount of terms
	}
	
	public static int reeks1(int a)
	{
		i++;
		int c = (int) Math.pow(i, 2) - a;
		System.out.println(i+"\t"+c);
		if (i < max)
			return reeks1(c);
		else
			return c; // dummy return
	}
	
	public static int reeks2(int a, int b)
	{
		i++;
		int c = b+a;
		System.out.println(i+"\t"+c);
		if (i < max)
			return reeks2(b, c);
		else
			return c; // dummy return
	}
	
	public static int[] array3 = new int[max];
	
	// deze is best wel verwarrend met die sigma ..
	public static void reeks3()
	{
		i++;
		int sum = 0;
		
		for (int p=1; p<i; p++)
			sum += array3[p-1];
		
		array3[i-1] = sum;
		System.out.println(i+"\t"+sum);
		
		if (i < max)
			reeks3();
	}
}

