// opdracht 6.2 - 6.4; recursie, somrij, verschilrij
public class o62_64
{
	public static int n = 100; // amount of terms
	public static int i = 2; // start from 3rd term
	public static double sum = 2 + 1; // t(1) + t(2)
	
	// for single line printin
	public static double[] terms = new double[n-2];
	public static double[] delta = new double[n-2];
	public static double[] sigma = new double[n-2];
	
	public static void main(String[] args)
	{
		System.out.println("i\ta; n-2\tb; n-1\tb/a\tb/a - b\tsum");
		System.out.println(1+"\t"+null+"\t"+null+"\t"+2.0+"\t"+null+"\t"+2.0);
		System.out.println(2+"\t"+null+"\t"+2.0+"\t"+1.0+"\t"+-1.0+"\t"+3.0);
		
		func1(2, 1); // table
		
		// for single line printing 
		System.out.print("\ntermen t(n) =\t2.0, 1.0, ");
		for (int i=0; i<n-2; i++)
			System.out.print(terms[i]+", ");
		
		System.out.print("\nverschilrij t(n) =\t-1.0, ");
		for (int i=0; i<n-2; i++)
			System.out.print(delta[i]+", ");
		
		System.out.println("\nsomrij t("+n+") =\t"+sigma[sigma.length-1]);
	}
	
	public static void func1(double a, double b)
	{
		i++;
		sum += b/a;
		double c = b/a;
		System.out.println(i+"\t"+a+"\t"+b+"\t"+c+"\t"+(c-b)+"\t"+sum);
		
		// for single line printing
		terms[i-3] = c;
		delta[i-3] = c - b;
		sigma[i-3] = sum;
		
		if (i < n)
			func1(b, c);
	}
}

