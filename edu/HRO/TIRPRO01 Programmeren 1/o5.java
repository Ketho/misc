// opdracht 5; Priemgetallen; Zeef van Eratosthenes
public class o5
{
	public static void main(String[] args)
	{
		int i = 0; // index of the prime number
		boolean[] b = new boolean[2000]; // some random high enough number
		
		for (int p=2; (p<b.length && i<200); p++) // number to be checked
		{
			if (!b[p])
			{
				i++;
				System.out.println(i+"\t"+p);
				
				for (int j=p*2; j<b.length; j+=p)
					b[j] = true;
			}
		}
	}
}

