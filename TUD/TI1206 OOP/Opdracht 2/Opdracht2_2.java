class Opdracht2_2
{
	public static void main(String[] args)
	{
		//System.out.println(max(5, 2));
		//System.out.println(abs(-7));
		//System.out.println(kwadraat(4));
		//System.out.println(vierkantswortel(25));
		//System.out.println(afstand(2,3, 3,4));
		testOpdracht2_2();
	}
	
	public static void testOpdracht2_2(){
		System.out.println("max(3.0,-4.0)==3.0 => " + (max(3.0,-4.0)==3.0));
		System.out.println("max(1.0,5.0)==5.0 => " + (max(1.0,5.0)==5.0));
		System.out.println("max(5.0,1.0)==5.0 => " + (max(5.0,1.0)==5.0));
		System.out.println("max(2.5,2.5)== 2.5 => " + (max(2.5,2.5)== 2.5));
		System.out.println("abs(-3.0)==3.0 => " + (abs(-3.0)==3.0));
		System.out.println("abs(0.3)==0.3 => " + (abs(0.3)==0.3));
		System.out.println("abs(kwadraat(3.0)-9.000)<1e-3 => " + (abs(kwadraat(3.0)-9.000)<1e-3));
		System.out.println("abs(kwadraat(-3.2)-10.240)<1e-3 => " + (abs(kwadraat(-3.2)-10.240)<1e-3));
		System.out.println("abs(vierkantswortel(3.0)-1.732)<1e-3 => " + (abs(vierkantswortel(3.0)-1.732)<1e-3));
		System.out.println("abs(vierkantswortel(25.0)-5.000)<1e-3 => " + (abs(vierkantswortel(25.0)-5.000)<1e-3));
		System.out.println("abs(vierkantswortel(3.8)-1.949)<1e-3 => " + (abs(vierkantswortel(3.8)-1.949)<1e-3));
		System.out.println("abs(afstand(2.0,3.0,3.0,3.0)-1.000)<1e-3 => " + (abs(afstand(2.0,3.0,3.0,3.0)-1.000)<1e-3));
		System.out.println("abs(afstand(1.0,3.0,2.5,2.5)-1.581)<1e-3 => " + (abs(afstand(1.0,3.0,2.5,2.5)-1.581)<1e-3));
		System.out.println("abs(afstand(-2.0,3.0,4.0,1.0)-6.324)<1e-3 => " + (abs(afstand(-2.0,3.0,4.0,1.0)-6.324)<1e-3));
		System.out.println("abs(afstand(-2.0,3.0,1.0,4.0)-3.162)<1e-3 => " + (abs(afstand(-2.0,3.0,1.0,4.0)-3.162)<1e-3));
	}
	
	static double max(double x, double y)
	{
		// java ternary operator
		return x > y ? x : y;
	}
	
	static double abs(double x)
	{
		return x < 0 ? -x : x;
	}
	
	static double kwadraat(double x)
	{
		return x*x;
	}
	
	static double vierkantswortel(double x)
	{
		// nu mogen we het wel gebruiken
		return Math.sqrt(x);
	}
	
	// Euclidean distance
	static double afstand(double x1, double y1, double x2, double y2)
	{
		return vierkantswortel(kwadraat(x2-x1) + kwadraat(y2-y1));
	}
}

