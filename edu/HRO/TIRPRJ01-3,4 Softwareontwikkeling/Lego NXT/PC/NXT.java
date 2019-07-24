import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;
 
public class NXT
{
	static NXTConnector conn;
	static DataInputStream inDat;
	static DataOutputStream outDat;
	
	public static void OpenConnection()
	{
		// open connection
		conn = new NXTConnector();
		
		conn.addLogListener(new NXTCommLogListener()
		{
			public void logEvent(String message)
			{
				System.out.println("USBSend Log.listener: "+message);
			}
			
			public void logEvent(Throwable throwable)
			{
				System.out.println("USBSend Log.listener - stack trace: ");
				throwable.printStackTrace();
			}
		});
		
		if (!conn.connectTo("usb://"))
		{
			System.err.println("No NXT found using USB");
			System.exit(1);
		}
		
		// open data stream
		inDat = new DataInputStream(conn.getInputStream());
		outDat = new DataOutputStream(conn.getOutputStream());
	}
	
	public static void USBSend(int i)
	{
		// write
		try
		{
			outDat.writeInt(i);
			outDat.flush();
			Thread.sleep(500);
		}
		catch (IOException ioe)
		{
			System.err.println("IO Exception writing bytes");
		}
		catch (InterruptedException e)
		{
			System.err.println(e);
		}
	}
	
	public static void CloseConnection()
	{
		// close data stream
		try
		{
			inDat.close();
			outDat.close();
			System.out.println("Closed data streams");
		}
		catch (IOException ioe)
		{
			System.err.println("IO Exception Closing connection");
		}
		
		// close connection
		try
		{
			conn.close();
			System.out.println("Closed connection");
		}
		catch (IOException ioe)
		{
			System.err.println("IO Exception Closing connection");
		}
	}
}

