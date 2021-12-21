
public class ConvertibleCar extends Car {
	SmallEngine engine;
	String topStatus;
	
	public ConvertibleCar(String carModel) {
		super(carModel);
		this.engine = new SmallEngine();
		this.topStatus = "";
	}
	
	public String getTopStatus() {
		return topStatus;
	}	

	public void raiseTop() {
		if (!topStatus.equals("Up")) {
			topStatus = "Up";
		} else {
			System.out.println("Top already raised");
		}
	}

	public void lowerTop() {
		if (!topStatus.equals("Down")) {
			topStatus = "Down";
		} else {
			System.out.println("Top already lowered");
		}
	}

}
