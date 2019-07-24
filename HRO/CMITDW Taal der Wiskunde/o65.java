// opdracht 6.5; Priemgetallen; Zeef van Eratosthenes
public class o65
{
	public static void main(String[] args)
	{
		int i = 0; // index of the prime number
		boolean[] b = new boolean[(int) 1e6]; // double -> int
		
		for (int p=2; (p<b.length); p++) // number to be checked
		{
			if (!b[p])
			{
				i++;
				
				if (p <= 100 || p >= 999900) // skip bulk
					System.out.println(i+"\t"+p);
				
				for (int j=p*2; j<b.length; j+=p)
					b[j] = true;
			}
		}
	}
}

