import java.util.Scanner;

class Opdracht1_3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Voer 2 temperaturen in, in graden Celsius en in Fahrenheit:");
		
		double celsius = sc.nextDouble(); // input temp1
		double fahrenheit = sc.nextDouble(); // input temp2
		
		System.out.println("De waarde van de eerste temperatuur is "+celsius+" graden Celsius");
		System.out.println("De waarde van de tweede temperatuur is "+fahrenheit+" Fahrenheit\n");		
		
		System.out.println("De waarde van de eerste temperatuur is "+(9/5.0 * celsius + 32)+" Fahrenheit");
		System.out.println("De waarde van de tweede temperatuur is "+(5/9.0 * (fahrenheit - 32))+" graden Celsius");
		sc.close();
	}
}

