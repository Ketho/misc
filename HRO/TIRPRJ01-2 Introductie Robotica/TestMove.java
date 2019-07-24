import stamp.core.*;

public class TestMove
{
	static PWM links = new PWM(CPU.pin13, 173, 2304);
	static PWM rechts = new PWM(CPU.pin12, 173, 2304);
	
	public static void main()
	{
		System.out.println("Hello World!");
		
		while (true)
		{
			left();
			CPU.delay(10000);
			
			right();
			CPU.delay(10000);
			
			forward();
			CPU.delay(10000);
			
			backward();
			CPU.delay(10000);
		}
	}
	
	public static void stop()
	{
		links.stop();
		rechts.stop();
		//System.out.println("stop");
	}
	
	public static void start()
	{
		links.start();
		rechts.start();
		//System.out.println("start");
	}
	
	public static void stand()
	{
		rechts.update(173, 2304);
		links.update(173, 2304);
		System.out.println("stand");
	}
	
	public static void forward()
	{ // -+ 10
		rechts.update(183, 2304);
		links.update(163, 2304);
		System.out.println("forward");
	}
	
	public static void backward()
	{ // -+ 10
		rechts.update(163, 2304);
		links.update(183, 2304);
		System.out.println("backward");
	}
	
	public static void right()
	{ // +10
		rechts.update(183, 2304);
		links.update(183, 2304);
		System.out.println("right");
	}
	
	public static void left()
	{ // -10
		rechts.update(163, 2304);
		links.update(163, 2304);
		System.out.println("left");
	}
}

