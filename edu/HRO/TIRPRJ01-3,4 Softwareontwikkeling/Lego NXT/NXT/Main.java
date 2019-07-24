// http://www.youtube.com/watch?v=nR73DyBPAmg
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.EOFException;

import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

public class Main
{
	public static void main(String [] args)
	{
		System.out.println("Hello Pinauto");
		
		try
		{
			USBReceive();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static void USBReceive() throws IOException
	{
		// setup connection
		USBConnection conn = USB.waitForConnection();
		DataOutputStream dOut = conn.openDataOutputStream();
		DataInputStream dIn = conn.openDataInputStream();
		
		// motor speeds
		Motors.SetSpeed(50, 20, 200);
		
		while (true)
		{
			// receive
			int i = dIn.readInt();
			if (i > 0)
			{
				System.out.println("Received: "+i);
				Motors.GetMoney(i);
			}
			// dummy break
			else if (i == -1)
				break;
		}
		
		// close connection
		// wordt eigenlijk via pc afgesloten ipv hier
        dOut.close();
        dIn.close();
        conn.close();
	}
}

