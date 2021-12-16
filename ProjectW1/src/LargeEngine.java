
public class LargeEngine implements IEngine {
	int cylinderCount = 8;
	
	public void start() {
		System.out.println("8 Cylinder Engine Started");
	}

	@Override
	public int getCylinderCount() {
		return this.cylinderCount;
	}
}
