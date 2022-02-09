import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebdriverTests {
	
  private WebDriver driver;

@Test
  public void canLaunchWebdriver() {
	  //Arrange

	  //Act
	  
	  //Assert
	  Assert.assertNotNull(this.driver, "Webdriver did not launch.");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Quintrix\\chromedriver.exe");
	  this.driver = new ChromeDriver();	  
  }

  @AfterMethod
  public void afterMethod() {
	  if (this.driver != null) {
		  this.driver.quit();
	  }
  }
}
