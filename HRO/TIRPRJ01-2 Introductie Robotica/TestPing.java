import stamp.core.*;
import stamp.peripheral.sensor.Ping;

public class TestPing
{
	static Ping range = new Ping(CPU.pin0);
	
	public static void main()
	{
		System.out.println("Hello World!");
		
		while (true)
			System.out.println(range.getRaw());
	}
}

