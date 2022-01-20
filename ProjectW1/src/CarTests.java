import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTests {

	@Test
	public void canBuildCar() {
		Car testCar = new Car("Corvette");
		testCar.engine.start();
		Assertions.assertNotNull(testCar.model);
		Assertions.assertEquals("Corvette", testCar.model);
	}
	
	@Test
	public void canDriveBicycle() {
		int miles = 5;
		Bicycle testBicycle = new Bicycle();
		testBicycle.drive(miles);
		Assertions.assertNotNull(testBicycle);
		Assertions.assertEquals(5, testBicycle.getOdometer());
	}
	
	@Test
	public void canDriveCar() {
		int miles = 20;
		Car testCar2 = new Car("Sonata");
		testCar2.drive(miles);
		Assertions.assertNotNull(testCar2);
		Assertions.assertEquals(20, testCar2.getOdometer());
	}
	
	@Test 
	public void canBuildSmallEngine() {
		SmallEngine testSmallEngine = new SmallEngine();
		testSmallEngine.start();
		Assertions.assertEquals(4, testSmallEngine.getCylinderCount());
	}
	
	@Test
	public void canBuildConvertibleCar() {
		ConvertibleCar testConvertibleCar = new ConvertibleCar("Miata");
		testConvertibleCar.engine.start();
		Assertions.assertNotNull(testConvertibleCar);
		Assertions.assertEquals("Miata", testConvertibleCar.model);
	}
	
	@Test
	public void canRaiseTop(){
		ConvertibleCar testConvertibleCar2 = new ConvertibleCar("Celica");
		testConvertibleCar2.raiseTop();
		Assertions.assertNotNull(testConvertibleCar2.getTopStatus());
		Assertions.assertEquals("Up", testConvertibleCar2.getTopStatus());		
	}
	
	@Test
	public void canLowerTop(){
		ConvertibleCar testConvertibleCar3 = new ConvertibleCar("Celica");
		testConvertibleCar3.lowerTop();
		Assertions.assertNotNull(testConvertibleCar3.getTopStatus());
		Assertions.assertEquals("Down", testConvertibleCar3.getTopStatus());			
	}	

}
