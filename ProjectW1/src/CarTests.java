import org.junit.jupiter.api.Test;

class CarTests {

	@Test
	public void canBuildCar() {
		Car testCar = new Car("Corvette");
		testCar.engine.start();
	}

}
