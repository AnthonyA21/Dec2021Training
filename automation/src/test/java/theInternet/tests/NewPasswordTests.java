package theInternet.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import theInternet.pages.ForgotPasswordPage;
import theInternet.pages.InternalServerErrorPage;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewPasswordTests extends TestBase {

	@Test
	public void canEnterValueInForgotPasswordFieldAndClickPassword() {
		String emailAddress = "foo@bar.com";
		String expectedResultText = "Internal Server Error";

		InternalServerErrorPage internalServerErrorPage = new ForgotPasswordPage(this.getDriver())
				.navigate()
				.enterEmailAddress(emailAddress)
				.clickRetrievePasswordButton();

		String resultText = internalServerErrorPage.getResultText();

		Assert.assertEquals(resultText, expectedResultText, "after clicking the button we were not on the result page.");
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