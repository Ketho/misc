// opdracht 5.1; gemiddelde, modus, mediaan
// http://stackoverflow.com/questions/4191687/how-to-calculate-mean-median-mode-and-range-from-a-set-of-numbers
import java.util.Arrays;
import java.util.Random;

public class o51
{
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int[] len = new int[300]; // number of lengths
		
		for (int i=0; i<len.length; i++)
		{
			len[i] = 160 + rnd.nextInt(40); // 160 to 199
		}
		
		explode(len);
		
		System.out.println("average =\t"+average(len));
		System.out.println("modus =\t"+mode(len));
		System.out.println("median =\t"+median(len));
		
		//explode(len); // array is sorted now
	}
	
	public static double average(int t[])
	{
		double sum = 0;
		for (int v : t) // trying out the for-each loop
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

