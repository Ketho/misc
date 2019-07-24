// opdracht 1.4; PI
// code is echt heel erg slecht :(
public class o14
{
	public static void main(String[] args)
	{
		double num = 1e8;
		System.out.println("algoritme PI1"); PI1(num);
		System.out.println("algoritme PI2"); PI2(num);
		System.out.println("algoritme PI3"); PI3(num);
		System.out.println("algoritme PI4"); PI4(num);
	}
	
	// PI1: pi/4 = 1/1 - 1/3 + 1/5 - 1/7 + ...
	public static void PI1(double n)
	{
		double sum = 0;
		long delta = System.currentTimeMillis();
		boolean op = true;
		
		for (double i=1; i<=n; i++)
		{
			if (op)
				sum += 1 / (i*2-1);
			else
				sum -= 1 / (i*2-1);
			
			op = !op; // toggle boolean
			
			if (Math.log10(i)%1==0 && i>1)
			{
				System.out.println(Math.log10(i)+"\t"+sum+"\t"+(Math.PI/4 - sum)+"\t"+(System.currentTimeMillis()-delta));
				delta = System.currentTimeMillis();
			}
		}
	}
	
	// PI2: (pi^2)/12 = 1/(1^2) - 1/(2^2) + 1/(3^2) - 1/(4^2) + ...
	public static void PI2(double n)
	{
		double sum = 0;
		long delta = System.currentTimeMillis();
		boolean op = true;
		
		for (double i=1; i<=n; i++)
		{
			if (op)
				sum += 1 / Math.pow(i, 2);
			else
				sum -= 1 / Math.pow(i, 2);
			
			op = !op;
			
			if (Math.log10(i)%1==0 && i>1)
			{
				System.out.println(Math.log10(i)+"\t"+sum+"\t"+(Math.pow(Math.PI,2)/12 - sum)+"\t"+(System.currentTimeMillis()-delta));
				delta = System.currentTimeMillis();
			}
		}
	}
	
	// PI3: (pi^2)/6 = 1/(1^2) + 1/(2^2) + 1/(3^2) + 1/(4^2) + ...
	public static void PI3(double n)
	{
		double sum = 0;
		long delta = System.currentTimeMillis();
		
		for (double i=1; i<=n; i++)
		{
			sum += 1 / Math.pow(i, 2);
			
			if (Math.log10(i)%1==0 && i>1)
			{
				System.out.println(Math.log10(i)+"\t"+sum+"\t"+(Math.pow(Math.PI,2)/6 - sum)+"\t"+(System.currentTimeMillis()-delta));
				delta = System.currentTimeMillis();
			}
		}
	}
	
	// PI4: (pi^2)/8 = 1/(1^2) + 1/(3^2) + 1/(5^2) + 1/(7^2) + 1/(9^2) + ...
	public static void PI4(double n)
	{
		double sum = 0;
		long delta = System.currentTimeMillis();
		
		for (double i=1; i<=n; i++)
		{
			sum += 1 / Math.pow(i*2-1, 2);
			
			if (Math.log10(i)%1==0 && i>1)
			{
				System.out.println(Math.log10(i)+"\t"+sum+"\t"+(Math.pow(Math.PI,2)/8 - sum)+"\t"+(System.currentTimeMillis()-delta));
				delta = System.currentTimeMillis();
			}
		}
	}
}

