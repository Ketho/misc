// opdracht 5.2; variantie, standaarddeviatie
import java.util.Random;

public class o52
{
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int[] len = new int[300]; // number of lengths
		
		for (int i=0; i<len.length; i++)
			len[i] = 160 + rnd.nextInt(40); // 160 to 199
		
		explode(len);
		
		double var = variance(len);
		
		System.out.println("variance =\t"+var);
		System.out.println("standard deviation =\t"+Math.sqrt(var));
	}
	
	public static double average(int t[])
	{
		double sum = 0;
		for (int v : t)
			sum += v;
		return sum / t.length;
	}
	
	public static double variance(int t[])
	{
		double avg = average(t);
		double sum = 0;
		for (int v : t)
			sum += Math.pow(v-avg, 2);
		return sum / t.length;
	}
	
	public static void explode(int t[])
	{
		for (int i=0; i<t.length; i++)
			System.out.println(i+"\t"+t[i]);
	}
}

