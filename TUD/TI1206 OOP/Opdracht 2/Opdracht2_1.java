class Opdracht2_1
{
	public static void main(String[] args)
	{
		//System.out.println(f1(25));
		
		//for (int i=0; i<4; i++)
		//	System.out.println("stap = "+1/Math.pow(10, i)+"\t"+integraal(0, 1, 1/Math.pow(10, i)));
		
		testOpdracht2_1();
	}
	
	public static void testOpdracht2_1()
	{
		System.out.println("f(3.0) == 1.7320508076 is " + (Math.abs(f1(3.0) - 1.7320508076) <= 1E-9));
		System.out.println("f(9.0) == 3.0 is " + (Math.abs(f1(9.0) - 3.0) <= 1E-9));
		
		System.out.println("integraal(0,50,1) == 239.0358082329 is " + (Math.abs(integraal(0,50,1) - 239.0358082329) <= 1E-9));
		System.out.println("integraal(0,50,0.1) == 235.3421927538 is " + (Math.abs(integraal(0,50,0.1) - 235.34219275381) <= 1E-9));
		System.out.println("integraal(0,50,0.01) == 235.7374085139 is " + (Math.abs(integraal(0,50,0.01) - 235.7374085139) <= 1E-9));
		System.out.println("integraal(0,50,0.001) == 235.7057893690 is " + (Math.abs(integraal(0,50,0.001) - 235.7057893690) <= 1E-9));
	}
	
	// mag geen Math.sqrt gebruiken
	// toepassing methode van Newton-Raphson
	static double f1(double a) // a = x^2
	{
		double x = 1; // initiele waarde
		
		// gebruik abs omdat x afwisselt tussen positief/negatief terwijl het nul nadert
		while (Math.abs(x*x - a) > 1e-10) // lim(x->0) x^2 - a
			// f(n+1) = f(n) - (f(x) / f'(x))
			x -= (x*x - a)/(2*x);
		
		return x; // square root of x^2
	}
	
	// og: ondergrens, bg: bovengrens, stap: interval
	// integraal van de vierkantswortel
	static double integraal(double og, double bg, double stap)
	{
		double v = 0;
		
		for (double i=og; i<=bg; i+=stap)
			v += f1(i);
		
		// ipv telkens te vermenigvuldigen met het interval,
		// doe het eenmalig op het einde
		return v * stap;
	}
}

