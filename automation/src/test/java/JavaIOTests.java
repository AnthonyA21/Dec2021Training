import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.ConfigurationProvider;

public class JavaIOTests {
	@Test
	public void canReadBrowserTypeFromConfigFile() {
		ConfigurationProvider cfgProvider = new ConfigurationProvider();
		String expectedBrowserType = "chrome";
		try {
			HashMap<String, String> configMap =  cfgProvider.getPropertiesFromResourceFile("config.properties");
			Assert.assertEquals(configMap.get("BrowserType"), expectedBrowserType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}