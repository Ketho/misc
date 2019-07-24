public class o6
{
	public static void main(String[] args)
	{
		int i = 0; // index of the (special) prime number
		boolean[] b = new boolean[(int) 1e6];
		// prime numbers consisting of only numbers 3 and 4
		// prime number 3 itself might be an exception if you require both 3 AND 4 at least once
		String numbers[] = {"0", "1", "2", "5", "6", "7", "8", "9"};
		
		// Sieve of Eratosthenes (very efficient)
		for (int p=2; p<b.length; p++) // number to be checked
		{
			if (!b[p])
			{
				boolean special = true;
				
				for (String v : numbers)
				{
					// check for anything not 3 and not 4
					if (String.valueOf(p).contains(v))
					{
						special = false;
						break;
					}
				}
				
				if (special)
				{
					i++;
					System.out.println(i+"\t"+p);
				}
				
				for (int j=p*2; j<b.length; j+=p)
					b[j] = true;
			}
		}
	}
}

