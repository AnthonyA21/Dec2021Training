package seleniumDev.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import seleniumDev.pages.HomePage;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SeleniumTests extends TestBase {
	private final String homeUrl = "https://www.selenium.dev/";
	private final String documentationUrl = "https://www.selenium.dev/documentation/webdriver/";

	@Test
	public void canLaunchDriver() {
		Assert.assertNotNull(this.getDriver(), "the webdriver was not launched.");
	}
	
	@Test
	public void canNavigateToSite() {
		String expectedUrl = homeUrl;
		
		new HomePage(this.getDriver()).navigate();
		
		String actualUrl = this.getDriver().getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl, "driver did not navigate to the url.");
	}
	
	@Test
	public void canClickOnElement() {
		String expectedUrl = documentationUrl;
		
		String actualUrl = new HomePage(getDriver())
				.navigate()
				.viewHomepageDocumentation()
				.getCurrentUrl();	
		
		Assert.assertEquals(expectedUrl, actualUrl, "documentation page was not displayed after clicking button.");
	}
	
	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
}