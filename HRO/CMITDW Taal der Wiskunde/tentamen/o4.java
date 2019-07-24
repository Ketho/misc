import java.util.Arrays;

public class o4
{
	public static void main(String[] args)
	{
		int[] array = new int[600]; // number of ratings
		
		for (int i=0; i<array.length; i++)
			array[i] = 1 + (int) (120 + Math.round(100 * Math.sin(i))) % 5; // 1 to 5
		
		//explode(array);
		//verifymode(array, 1, 5);
		
		System.out.println("average = "+average(array));
		System.out.println("mode = "+mode(array));
		System.out.println("median = "+median(array));
		
		double var = variance(array);
		System.out.println("variance = "+var);
		System.out.println("standard deviation = "+Math.sqrt(var));
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
	
	public static double variance(int t[])
	{
		double avg = average(t);
		double sum = 0;
		for (int v : t)
			sum += Math.pow(v-avg, 2);
		return sum / t.length;
	}
	
	// debug methods
	public static void explode(int t[])
	{
		for (int i=0; i<t.length; i++)
			System.out.println(i+"\t"+t[i]);
	}
	
	public static void verifymode(int t[], int a, int b)
	{
		for (int i=a; i<=b; i++)
		{
			int sum = 0;
			for (int v : t)
			{
				if (v == i)
					sum++;
			}
			System.out.println("mode "+i+" = "+sum);
		}
	}
}

