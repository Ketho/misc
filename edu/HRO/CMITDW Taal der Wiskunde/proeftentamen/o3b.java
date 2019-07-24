// sum of two powers; filtered for numbers that are powers themselves too
public class o3b
{
	public static int list[] = new int[20];
	
	public static void main(String[] args)
	{
		for (int c=2; c<=10000; c++)
		{
			clear(list); // clear array
			int instances = 0;
			int backup[] = new int[3];
			
			for (int a=2; a<c; a++)
			{
				double b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
				
				if (b%1 == 0 && !check(list, a) && Math.sqrt(c)%1 == 0)
				{
					insert(list, (int) b); // filter duplicate/mirror values
					instances++;
					
					if (instances > 1) // filter non-multiple instances
					{
						if (instances == 2) // show the first instance too now
							System.out.println(backup[0]+"\t"+backup[1]+"\t"+backup[2]);
						System.out.println(a+"\t"+(int) b+"\t"+c);
					}
					
					// dirty hack for remembering first instance
					backup[0] = a; 
					backup[1] = (int) b;
					backup[2] = c;
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

