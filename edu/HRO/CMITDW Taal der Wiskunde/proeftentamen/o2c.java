public class o2c
{
	public static void main(String[] args)
	{
		System.out.println(func1(2));
	}
	
	public static double func1(double x)
	{
		double sum = 0;
		for (int i=3; i<=100; i++)
		{
			sum += i / Math.pow(x, i);
			System.out.println(i+"\t"+sum); // debug
		}
		return sum;
	}
}

