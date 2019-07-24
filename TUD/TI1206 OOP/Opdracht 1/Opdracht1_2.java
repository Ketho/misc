class Opdracht1_2
{
	public static void main(String[] args)
	{
		int getal1 = 4;
		int getal2 = 7;
		int getal3 = 2;
		int temp;
		
		System.out.println("De waarde van getal1 is "+getal1);
		System.out.println("De waarde van getal2 is "+getal2);
		System.out.println("De waarde van getal3 is "+getal3);
		
		// shift values, use temp variable
		temp = getal3;
		getal3 = getal2;
		getal2 = getal1;
		getal1 = temp;
		
		System.out.println("\nDe waarde van getal1 is "+getal1);
		System.out.println("De waarde van getal2 is "+getal2);
		System.out.println("De waarde van getal3 is "+getal3);
	}
}

