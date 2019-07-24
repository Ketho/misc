public class Foo
{
	private Foo f;
	private int x = 5;
	
	public Foo(){}
	
	public Foo(Foo _f, int _x)
	{
		f = _f;
		x = _x;
	}
	
	public void print()
	{
		System.out.println("x = "+x);
	}
	
	public Foo getFoo(){return f;}
	public void setFoo(Foo _f){f = _f;}
	
	public int getX(){return x;}
	public void setX(int _x){x = _x;}
}

