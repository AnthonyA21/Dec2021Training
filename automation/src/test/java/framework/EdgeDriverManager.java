package framework;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "edgedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", driverFile.toFile().getAbsolutePath());

		this.setDriver();
	}

}
