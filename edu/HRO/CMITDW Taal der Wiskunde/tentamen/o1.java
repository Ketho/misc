public class o1
{
	public static void main(String[] args)
	{
		System.out.println(func1(600)); 
	}
	
	// -(i*2-1)^3 / i -+ ...
	public static double func1(int n)
	{
		double sum = 0;
		boolean op = true;
		
		for (int i=1; i<=n; i++)
		{
			if (op)
				sum -= Math.pow(i*2-1, 3) / i;
			else
				sum += Math.pow(i*2-1, 3) / i;
			
			op = !op; // toggle boolean
			System.out.println(i+"\t"+sum);
		}
		
		return sum;
	}
}

