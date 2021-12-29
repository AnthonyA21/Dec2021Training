import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTests {
	private ChromeDriver driver;
	private final String testUrl = "https://www.selenium.dev/";

	@Test
	public void canLaunchWebDriver() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, testUrl);
	}

	@Test
	public void canClickButton() {
		WebElement element = driver.findElement(By.cssSelector("a[href = '/documentation/webdriver/']"));
		element.click();
	}

	@BeforeMethod
	public void setup() {
		String driverPath = "C:\\Quintrix\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();

		this.driver.navigate().to(testUrl);
	}
	
	@AfterMethod
	public void cleanup() {
		  this.driver.quit();		
	}
}
