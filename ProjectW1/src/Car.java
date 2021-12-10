
public class Car {
	private int odometer;
	LargeEngine engine;
	String model;

	public Car(String carModel) {
		engine = new LargeEngine();
		model = carModel;
	}

	public int getOdometer() {
		return this.odometer;
	}
}
