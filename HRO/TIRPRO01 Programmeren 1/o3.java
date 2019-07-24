// opdracht 3; Priemgetallen
public class o3
{
	public static void main(String[] args)
	{
		int i = 0; // index of the prime number
		int p = 1; // number to be checked
		
		while (i < 200)
		{
			p++;
			boolean isprime = true;
			
			for (int j=2; j<p; j++)
			{
				if (p%j == 0)
				{
					isprime = false;
					break;
				}
			}
			
			if (isprime)
			{
				i++;
				System.out.println(i+"\t"+p);
			}
		}
	}
}

