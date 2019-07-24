import lejos.nxt.Motor;

public class Motors
{
	static int roundsA = 0;
	
	static void GetMoney(int v)
	{
		try
		{
			int bedrag = (int) v;
			
			int b50, b20, b10, b5;
			int mod50, mod20, mod10, mod5;
			
			b50 = bedrag/50;
			mod50 = bedrag%50;
			
			b20 = mod50/20;
			mod20 = mod50%20;
			
			b10 = mod20/10;
			mod10 = mod20%10;
			
			b5 = mod10/5;
			mod5 = mod10%5;
			
			System.out.println(b50+", "+b20+", "+b10+", "+b5);
			
			// set motor B to start position
			BackwardB(1000);
			
			if (b50 > 0)
			{
				System.out.println("Rotate 0 (50e)");
				RotateA(0);
				MoveB(b50);
			}
			
			// eerst optillen
			else
			{
				System.out.println("Optillen ..");
				//Motor.B.setSpeed(20);
				ForwardB(2100);
			}
			if (b20 > 0)
			{
				System.out.println("Rotate 90 (20e)");
				RotateA(90);
				MoveB(b20);
			}
			if (b10 > 0)
			{
				System.out.println("Rotate 180 (10e)");
				RotateA(180);
				MoveB(b10);
			}
			if (b5 > 0)
			{
				System.out.println("Rotate 270 (5e)");
				RotateA(270);
				MoveB(b5);
			}
			
			// continue to beginning position
			RotateA(360);
			System.out.println("Rotate 360");
			
			// return B to beginning position
			Motor.B.setSpeed(50);
			BackwardB(500);
			
			// wait for money before moving it
			Thread.sleep(500);
			RotateC();
			
			// increase rotation counter
			roundsA++;
			
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}
	
	public static void SetSpeed(int a, int b, int c)
	{
		Motor.A.setSpeed(a);
		Motor.B.setSpeed(b);
		Motor.C.setSpeed(c);
	}
	
	// rotate money
	public static void RotateA(int v) throws InterruptedException
	{
		Motor.A.rotateTo(v+(roundsA*360));
		Thread.sleep(500);
	}
	
	// pickup money from rotation
	public static void MoveB(int times)
	{
		try
		{
			for (int i=0; i<times; i++)
			{
				// beweeg wiel naar het geld
				Motor.B.setSpeed(20);
				BackwardB(1000);
				
				// geld uitdraaien
				Motor.B.setSpeed(400);
				BackwardB(800);
				Thread.sleep(500);
				
				// optillen
				Motor.B.setSpeed(20);
				ForwardB(2100);
				
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}
	
	public static void ForwardB(int v) throws InterruptedException
	{
		Motor.B.forward();
		Thread.sleep(v);
		Motor.B.stop();
	}
	
	public static void BackwardB(int v) throws InterruptedException
	{
		Motor.B.backward();
		Thread.sleep(v);
		Motor.B.stop();
	}
	
	// move money to customer
	public static void RotateC()
	{
		Motor.C.rotateTo(-90);
		Motor.C.rotateTo(0);
	}
}

