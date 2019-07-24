// sum of two powers; filtered for _exactly_ 3 instances
// actually could also just manually filter instead of writing excessive code ><
public class o3c
{
	public static int list[] = new int[20];
	
	public static void main(String[] args)
	{
		for (int c=2; c<=1000; c++)
		{
			clear(list); // clear array
			int cache[][] = new int[3][3]; // 3 arrays/instances with 3 indices each
			int instances = 0;
			boolean isThree = false;
			
			for (int a=2; a<c; a++)
			{
				double b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
				
				if (b%1 == 0 && !check(list, a))
				{
					insert(list, (int) b); // filter duplicate/mirror values
					
					instances++;
					isThree = (instances==3) ? true : false;
					
					if (instances <= 3)
					{
						cache[instances-1][0] = a;
						cache[instances-1][1] = (int) b;
						cache[instances-1][2] = c;
					}
				}
			}
			
			if (isThree) // now print the data
			{
				for (int[] v : cache)
					System.out.println(v[0]+"\t"+v[1]+"\t"+v[2]);
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

