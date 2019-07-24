// opdracht 3.4; Halveringsmethode
// http://en.wikipedia.org/wiki/File:Bisection_method.svg
public class o34
{
	public static void main(String[] args)
	{
		for (int i=1; i<=3; i++)
			System.out.println("f(x) = 0\t"+bisect(-50, 50, i)+"\n");
	}
	
	// http://www.wolframalpha.com/input/?i=x%5E5-3x%5E2-2%3D0
	public static double func1(double x)
	{
		return Math.pow(x, 5) - 3*Math.pow(x, 2) - 2;
	}
	
	// http://www.wolframalpha.com/input/?i=e-abs%283x%29%3D0
	public static double func2(double x)
	{
		return Math.E - Math.abs(3*x);
	}
	
	// http://www.wolframalpha.com/input/?i=%28x%5E2%2B4%29%2F%28x%2B2%29%3D8.5
	public static double func3(double x)
	{
		return (Math.pow(x,2)+4)/(x+2) - 8.5;
	}
	
	public static double bisect(double left, double right, int index)
	{
		double mid = (left + right) / 2;
		double fmid = 0;
		
		// dont know how to pass by function pointer
		if (index == 1)
			fmid = func1(mid);
		else if (index == 2)
			fmid = func2(mid);
		else if (index == 3)
			fmid = func3(mid);
		
		System.out.println(left+"\t"+right+"\t"+mid+"\t"+fmid);
		
		// avoid infinite loop to zero
		if (fmid > 1e-7) // .0000001
			return bisect(left, mid, index);
		else if (fmid < -1e-7)
			return bisect(mid, right, index);
		else
			return mid;
	}
}

