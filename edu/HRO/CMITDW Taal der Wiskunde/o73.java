// opdracht 7.3; puzzel 3
public class o73
{
	public static int list[] = new int[10];
	
	public static void main(String[] args)
	{
		for (int c=2; c<=100; c++)
		{
			clear(list); // clear array
			
			for (int a=2; a<c; a++)
			{
				double b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
				if (b%1 == 0 && !check(list, a))
				{
					insert(list, (int) b); // filter duplicate/mirror values
					System.out.println(a+"\t"+(int) b+"\t"+c);
				}
			}
		}
	}
	
	public static void clear(int t[])
	{
		for (int i=0; i<t.length; i++)
			t[i] = 0;
	}
	
	public static void insert(int t[], int a)
	{
		for (int i=0; i<t.length; i++)
		{
			if (t[i] == 0)
			{
				t[i] = a;
				break;
			}
		}
	}
	
	public static boolean check(int t[], int a)
	{
		for (int v : t)
		{
			if (v == a)
				return true;
		}
		return false;
	}
}

