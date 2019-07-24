// opdracht 3.6; Regula falsi
// http://www.wolframalpha.com/input/?i=x%5E5-3x%5E2-2+%3D+0
// http://commons.wikimedia.org/wiki/File:Regula_falsi.gif
public class o36
{
	public static void main(String[] args)
	{
		System.out.println("f(x) = 0\t"+regula(-2, 2));
	}
	
	public static double func1(double x)
	{
		return Math.pow(x, 5) - 3*Math.pow(x, 2) - 2;
	}
	
	public static double regula(double a, double b)
	{
		double fa = func1(a);
		double fb = func1(b);
		
		double c = b - fb * ((b-a) / (fb-fa));
		double fc = func1(c);
		
		System.out.println(a+"\t"+b+"\t"+c+"\t"+fc);
		
		// avoid infinite loop to zero
		if (fc > 1e-7) // .0000001
			return regula(a, c);
		else if (fc < -1e-7)
			return regula(c, b);
		else
			return c;
	}
}

