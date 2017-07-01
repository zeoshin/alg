package inheritance;

public class Car extends Vehicle {
	@Override
	public void print() {
		System.out.println("Car");
	}
	public void print2() {
		System.out.println("Car 2");
	}

	public static void main(String[] args) {
		Vehicle v1 = new Car();
		v1.print();
		// v1.print2(); ERROR
		Car v2 = new Car();
		v2.print();
		v2.print2();
		
		// Car v3 = new Vehicle(); ERROR
		
		Vehicle v4 = new Vehicle();
		// v4.print2(); ERROR
		((Car) v4).print2();
	}
}
