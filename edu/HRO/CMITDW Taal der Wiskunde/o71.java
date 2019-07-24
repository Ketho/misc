// opdracht 7.1; puzzel 1
public class o71
{
	public static void main(String[] args)
	{
		System.out.println("/5\tsquare\tprime");
		
		for (int i=1; i<=1000; i++)
		{
			if (i%5 == 0) // dividable by 5
			{
				if (Math.sqrt(i+1)%1 == 0) // quadratic
				{
					boolean isprime = true;
					for (int j=2; j<i+2; j++)
					{
						if ((i+2)%j == 0) // not prime
						{
							isprime = false;
							break;
						}
					}
					if (isprime)
						System.out.println(i+"\t"+(i+1)+"\t"+(i+2));
				}
			}
		}
	}
}

