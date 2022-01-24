package framework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	private WebDriver driver;
	
	public abstract void createDriver();

	protected void setDriver() {
		this.driver = getDriver();
	}
	
	public WebDriver getDriver() {
		ConfigurationProvider cfgProvider = new ConfigurationProvider();
		String browserType = "";
		try {
			HashMap<String, String> configMap =  cfgProvider.getPropertiesFromResourceFile("config.properties");
			browserType = configMap.get("BrowserType");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DriverManager driverManager = DriverManagerFactory.getManager(browserType);

		return driverManager.getDriver();	
	}
	
	public void quitDriver() {
		this.getDriver().quit();
	}

}
