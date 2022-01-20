
public abstract class Vehicle {
	protected int odometer;

	public int getOdometer() {
		return odometer;
	}
	
	public void drive(int miles) {
		odometer += miles;
	}	

}
