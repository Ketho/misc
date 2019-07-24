import stamp.core.*;

public class TestTerminal
{
	public static void main()
	{
		System.out.println("Hello World!");
		
		while (true)
		{
			// works on Serial Boe-Bot
			// does not work on USB Boe-Bot
			System.out.println(Terminal.getChar());
		}
	}
}

