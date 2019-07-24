import stamp.core.*;

public class TestDefault
{
	static int leftDefault = 173;
	static int rightDefault = 173;
	static int rotateDefault = 173;
	
	static int lowTime = 2000;
	
	static PWM leftPWM = new PWM(CPU.pin12, leftDefault, lowTime);
	static PWM rightPWM = new PWM(CPU.pin13, rightDefault, lowTime);
	static PWM rotatePWM = new PWM(CPU.pin14, rotateDefault, lowTime);
	
	public static void main()
	{
		System.out.println("Hello World!");
	}
}

