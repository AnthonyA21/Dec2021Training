package theInternet;

import org.testng.annotations.Test;

import theInternet.pages.ForgotPasswordPage;
import theInternet.pages.InternalServerErrorPage;

import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewPasswordTests {
	private WebDriver driver;

	@Test
	public void canEnterValueInForgotPasswordFieldAndClickPassword() {
		String emailAddress = "foo@bar.com";
		String expectedResultText = "Internal Server Error";

		//enter email address
		//click retrieve password button
		InternalServerErrorPage internalServerErrorPage = new ForgotPasswordPage(driver)
				.enterEmailAddress(emailAddress)
				.clickRetrievePasswordButton();

		String resultText = internalServerErrorPage.getResultText();

		//ensure that we are on a new page and that text is displayed
		Assert.assertEquals(resultText, expectedResultText, "after clicking the button we were not on the result page.");
	}

	@BeforeMethod
	public void setup() {
		launchChromeDriver();
		this.driver.navigate().to(ForgotPasswordPage.url);
	}

	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}

	private void launchChromeDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", driverFile.toFile().getAbsolutePath());

		this.driver = new ChromeDriver();	

		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout , TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}
}