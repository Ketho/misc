import java.util.Random;

public class App
{
	public static void main(String[] args)
	{
		// Opdracht 2: 3 car objects
		Auto car1 = new Auto();
		Auto car2 = new Auto();
		Auto car3 = new Auto();
		
		car1.setLicense("12-AB-CD");
		car1.setColor("Blue");
		car1.setConsumption(6.2);
		car1.print();
		
		car2.setDoors(2);
		car2.setBrand("Smart");
		car2.setSpeed(110);
		car2.setPrice(9995);
		car2.print();
		
		car3.setColor("Pink");
		car3.setSpeed(140);
		car3.print();
		
		// Opdracht 3: array of 5 car objects
		Random rnd = new Random();
		Auto[] cars = new Auto[5];
		
		System.out.println("Contents of Auto array:");
		for (int i=0; i<cars.length; i++)
		{
			cars[i] = new Auto();
			cars[i].setSpeed(100 + rnd.nextInt(99)); // different speeds
			System.out.println(i+"\t"+cars[i]); // print contents of array (only the pointers?)
		}
		
		// Opdracht 4: pointer to fastest car object
		Auto fast = FastestCar(cars);
		System.out.println("--\nPointer to fastest car: "+fast);
		System.out.println("Max velocity: "+fast.getSpeed());
	}
	
	public static Auto FastestCar(Auto[] c)
	{
		Auto car = new Auto();
		for (int i=0; i<c.length; i++)
		{
			if (c[i].getSpeed() > car.getSpeed())
				car = c[i];
		}
		return car;
	}
}

