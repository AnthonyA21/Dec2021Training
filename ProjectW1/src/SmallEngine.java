
public class SmallEngine implements IEngine {
	int cylinderCount = 4;
	
	public void start() {
		System.out.println("4 Cylinder Engine Started");
	}

	@Override
	public int getCylinderCount() {
		return this.cylinderCount;
	}

}
