
public class Car extends Vehicle {
	LargeEngine engine;
	String model;

	public Car(String carModel) {
		engine = new LargeEngine();
		model = carModel;
	}
}
