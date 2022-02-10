import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmpegTests {
	
  private WebDriver driver;

@Test
  public void ensureArtistNameIsCorrect() {
	  //Arrange
	  String expectedName = "Bootsy Collins";
	  
	  //Act
	  //Step 1 - go to home page
	  String artistName = new HomePage(this.driver)
			  .navigate()
			  .clickProductsLink()
			  .clickClassicSeries()
			  .clickSVT810E()
			  .getArtistName();
	  
	  //Assert
	  Assert.assertEquals(artistName, expectedName);
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
