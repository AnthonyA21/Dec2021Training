package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.Textbox;

public class ForgotPasswordPage extends PageObjectBase {
	private final String url = "http://the-internet.herokuapp.com/forgot_password";
	
	@FindBy(how=How.ID, using="email")
	private WebElement emailAddressElement;

	@FindBy(how=How.ID, using="form_submit")
	private WebElement retrievePasswordButton;

	public ForgotPasswordPage(WebDriver driver) {
	    super(driver);
	}

	public ForgotPasswordPage enterEmailAddress(String emailAddress) {
		new Textbox(emailAddressElement).setValue(emailAddress);
		return this;
	}

	public InternalServerErrorPage clickRetrievePasswordButton() {
		retrievePasswordButton.click();
		return new InternalServerErrorPage(this.driver);
	}

	public ForgotPasswordPage navigate() {
		this.driver.navigate().to(url);
		return this ;
	}
}