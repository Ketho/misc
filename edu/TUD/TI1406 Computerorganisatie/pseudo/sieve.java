public class sieve
{
	public static void main(String[] args)
	{
		boolean[] numbertable = new boolean[1000];
		
		// Initialize the number table
		for (int i=0; i<1000; i++)
			numbertable[i] = true;
		
		// The sieve algoritm
		for (int number=2; number<1000; number++)
		{
			// If the number is still in the list it must be prime
			if (numbertable[number])
			{
				// Print the prime number
				System.out.println(number);
				
				// Cross out all multiples of the number
				int multiple = 2*number;
				while (multiple < 1000)
				{
					numbertable[multiple] = false;
					multiple += number;
				}
			}
		}
	}
}

