package framework;

public class DriverManagerFactory extends TestBase {
	
	public static DriverManager getManager(String browserType) {
        DriverManager driverManager = null;

		if (browserType.equals("chrome")) {
			driverManager = new ChromeDriverManager();
		} else if (browserType.equals("edge")) {
			driverManager = new EdgeDriverManager();
		}
		
        return driverManager;
	}

}