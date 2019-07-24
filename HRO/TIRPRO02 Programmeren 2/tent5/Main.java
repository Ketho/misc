public class Main
{
	public static void main(String[] args)
	{
		Foo x = new Foo(new Foo(), 2);
		Foo y = new Foo();
		x.getFoo().setFoo(new Foo(y, 3));
		y.setFoo(x);
		
		x.getFoo().getFoo().print();
		y.setFoo(x.getFoo());
		y.getFoo().getFoo().getFoo().print();
		
		int i = x.getX() + x.getFoo().getX();
		x.setFoo(x.getFoo().getFoo());
		i += y.getX();
		x.getFoo().setX(3 * x.getX());
		i += y.getFoo().getFoo().getFoo().getFoo().getX();
		System.out.println("i = "+i);
	}
}

