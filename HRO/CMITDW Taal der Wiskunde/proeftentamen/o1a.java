import java.util.Arrays;

public class o1a
{
	public static void main(String[] args)
	{
		int[] numbers = {1, 1, 1, 1, 4, 5, 6, 7, 7, 7};
		
		//explode(numbers);
		System.out.println("average =\t"+average(numbers));
		System.out.println("modus =\t"+mode(numbers));
		System.out.println("median =\t"+median(numbers));
	}
	
	public static double average(int t[])
	{
		double sum = 0;
		for (int v : t)
			sum += v;
		return sum / t.length;
	}
	
	public static int mode(int t[])
	{
		int v = 0, max = 0;
		
		for (int i=0; i<t.length; i++)
		{
			int count = 0;
			for (int j=0; j<t.length; j++)
			{
				if (t[i] == t[j])
					count++;
			}
			
			if (count > max)
			{
				max = count;
				v = t[i];
			}
		}
		
		return v;
	}
	
	public static double median(int t[])
	{
		Arrays.sort(t);
		int med = t.length / 2;
		
		if (t.length%2 == 0)
			return (double) (t[med-1] + t[med]) / 2;
		else
			return t[med];
	}
	
	public static void explode(int t[])
	{
		for (int i=0; i<t.length; i++)
			System.out.println(i+"\t"+t[i]);
	}
}

