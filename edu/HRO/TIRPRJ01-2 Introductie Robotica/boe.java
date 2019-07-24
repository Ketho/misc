// Boe-Bot with 1 Parallax Ping sensor on a rotating servomotor
// http://www.youtube.com/watch?v=nPFfJZCom1k
import stamp.core.*;
import stamp.peripheral.sensor.Ping;

public class boe
{
	static int leftDefault = 173;
	static int rightDefault = 172; // off -1
	static int rotateDefault = 175; // off +2
	
	static int moveSpeed = 10;
	static int pingSpeed = 20;
	
	static int lowTime = 2000; // no idea what this is for
	static int movetime = 5000;
	static int pingTime = 2300;
	
	static int stopDistance = 35;
	
	static PWM leftPWM = new PWM(CPU.pin12, leftDefault, moveSpeed);
	static PWM rightPWM = new PWM(CPU.pin13, rightDefault, moveSpeed);
	static PWM rotatePWM = new PWM(CPU.pin14, rotateDefault, pingSpeed);
	static Ping range = new Ping(CPU.pin0);
	
	static int L, R, M;
	static boolean isBackward;
	
	public static void main()
	{
		System.out.println("Hello World!");
		
		while (true)
		{
			PingScan();
			
			boolean wallLeft = L>0 && L<stopDistance+30;
			boolean wallRight = R>0 && R<stopDistance+30;
			boolean wallMid = M>0 && M<stopDistance+20;
			boolean isBlocked = wallLeft && wallRight && wallMid;
			
			boolean leftBigger = L>R || L==-1;
			
			System.out.print(wallLeft);
			System.out.print(" ");
			System.out.print(wallRight);
			System.out.print(" ");
			System.out.print(wallMid);
			System.out.print(" ");
			System.out.println(isBlocked);
			
			if (isBlocked)
			{
				if (!isBackward)
				{
					MoveBackward();
					isBackward = true;
					CPU.delay(6500);
				}
				else
				{
					MoveLeft();
					isBackward = false;
					// 360 degrees turn
					CPU.delay(movetime);
					CPU.delay(movetime);
				}
			}
			else if (!wallMid)
				SmartForward();
			else if (!wallLeft && leftBigger)
				SmartTurn("left");
			else if (!wallRight)
				SmartTurn("right");
			
			StandStill();
		}
	}
	
	public static void PingScan()
	{
		R = 0; L = 0; M = 0;
		
		PingRight();
		R = range.getRaw(); // right
		
		PingLeft();
		M = range.getRaw(); // middle
		
		PingLeft();
		L = range.getRaw(); // left
		
		PingRight(); // return to start position
		
		System.out.println("R="+R+"\t  M="+M+"\t  L="+L);
	}
	
	//////////////////
	// wheel servos //
	//////////////////
	
	public static void StandStill()
	{
		leftPWM.update(leftDefault, lowTime);
		rightPWM.update(rightDefault, lowTime);
		System.out.println("# StandStill");
	}
	
	public static void MoveForward(int skew)
	{
		leftPWM.update(leftDefault + moveSpeed + skew, lowTime);
		rightPWM.update(rightDefault - moveSpeed + skew, lowTime);
		System.out.println("# MoveForward");
	}
	
	public static void MoveBackward()
	{
		leftPWM.update(leftDefault - moveSpeed, lowTime);
		rightPWM.update(rightDefault + moveSpeed, lowTime);
		System.out.println("# MoveBackward");
	}
	
	public static void MoveLeft()
	{
		leftPWM.update(leftDefault - moveSpeed, lowTime);
		rightPWM.update(rightDefault - moveSpeed, lowTime);
		System.out.println("# MoveLeft");
	}
	
	public static void MoveRight()
	{
		leftPWM.update(leftDefault + moveSpeed, lowTime);
		rightPWM.update(rightDefault + moveSpeed, lowTime);
		System.out.println("# MoveRight");
	}
	
	public static void SmartForward()
	{
		int i = 0;
		int skew = 0;
		
		if ((L==-1 || L>100) && (R==-1 || R>100))
			skew = 0;
		else if (L > R+10)
			skew = -3;
		else if (R > L+10)
			skew = 3;
		
		MoveForward(skew);
		
		while (true)
		{
			i++;
			if (i > 50) // rescan periodically
				return;
			
			int r = range.getRaw();
			if (r>0 && r<stopDistance)
				return;
		}
	}
	
	public static void SmartTurn(String type)
	{
		if (type == "left")
			MoveLeft();
		else if (type == "right")
			MoveRight();
		
		int lastdist = 0;
		
		while (true)
		{
			insert(turnArray, range.getRaw());
			int avgdist = avg(turnArray);
			
			if (avgdist+10 < lastdist || avgdist > 150)
			{
				clear(turnArray);
				CPU.delay(1000);
				return;
			}
			
			if (turnInt % turnArray.length == 0)
				lastdist = avgdist;
		}
	}

	
	//////////////////////////
	// ping rotation servos //
	//////////////////////////
	
	public static void PingRight()
	{
		rotatePWM.update(rotateDefault - pingSpeed, lowTime);
		//System.out.println("# PingRight");
		CPU.delay(pingTime);
		PingWait();
	}
	
	public static void PingLeft()
	{
		rotatePWM.update(rotateDefault + pingSpeed, lowTime);
		//System.out.println("# PingLeft");
		CPU.delay(pingTime+50); // fix
		PingWait();
	}
	
	public static void PingWait()
	{
		rotatePWM.update(rotateDefault, lowTime);
		//System.out.println("# PingWait");
		CPU.delay(500);
	}
	
	//////////////////////
	// average distance //
	//////////////////////
	
	// averages are more stable and accurate
	public static int turnArray[] = new int[5];
	public static int turnInt = 0;
	
	public static void clear(int t[])
	{
		for (int i=0; i<t.length; i++)
			t[i] = 0;
	}

	public static void insert(int t[], int d)
	{
		if (d == -1) // fix out of bounds
			d = 5000;
		
		t[turnInt % t.length] = d; // overwrite oldest key
		turnInt++;
	}
	
	public static int avg(int t[])
	{
		int sum = 0;
		for (int i=0; i<t.length; i++)
			sum += t[i];
		return sum / t.length;
	}
}

