import java.util.Random;

public class Main
{	
	public static void main(String[] args)
	{
		System.out.println("Hello Pinautomaat");
		
		Random r = new Random();
		
		NXT.OpenConnection();
		
		//NXT.USBSend((r.nextInt(30)+1)*5);
		NXT.USBSend(85);
		
		NXT.CloseConnection();
	}
}

