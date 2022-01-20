package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import theInternet.pages.PageObjectBase;

public class ForgotPasswordPage extends PageObjectBase {
	public final static String url = "http://the-internet.herokuapp.com/forgot_password";

	private WebDriver driver;

	@FindBy(how=How.ID, using="email")
	private WebElement emailAddressTextbox;

	@FindBy(how=How.ID, using="form_submit")
	private WebElement retrievePasswordButton;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	public ForgotPasswordPage enterEmailAddress(String emailAddress) {
		emailAddressTextbox.sendKeys(emailAddress);
		return this;
	}

	public InternalServerErrorPage clickRetrievePasswordButton() {
		retrievePasswordButton.click();
		return new InternalServerErrorPage(this.driver);
	}
}