public class Auto
{
	private String license = "99-XX-XX"; // dutch
	private int doors = 4;
	private String color = "White";
	private String brand = "Peugot";
	private String type = "Normal";
	private int speed = 120; // km/h
	
	private double consumption = 5.0; // l/100km
	private int price = 14999; // euro
	
	public void print()
	{
		System.out.println("License plate: "+license);
		System.out.println("Doors: "+doors);
		System.out.println("Color: "+color);
		System.out.println("Brand: "+brand);
		System.out.println("Type: "+type);
		System.out.println("Max velocity: "+speed);
		System.out.println("Fuel consumption: "+consumption);
		System.out.println("Price: "+price);
		System.out.println("--");
	}
	
	///////////////////////
	// getters & setters //
	///////////////////////
	
	public String getLicense(){return license;}
	public void setLicense(String license){this.license = license;}
	
	public int getDoors(){return doors;}
	public void setDoors(int doors){this.doors = doors;}
	
	public String getColor(){return color;}
	public void setColor(String color){this.color = color;}
	
	public String getBrand(){return brand;}
	public void setBrand(String brand){this.brand = brand;}
	
	public String getType(){return type;}
	public void setType(String type){this.type = type;}
	
	public int getSpeed(){return speed;}
	public void setSpeed(int speed){this.speed = speed;}
	
	
	public double getConsumption(){return consumption;}
	public void setConsumption(double consumption){this.consumption = consumption;}
	
	public int getPrice(){return price;}
	public void setPrice(int price){this.price = price;}
}

