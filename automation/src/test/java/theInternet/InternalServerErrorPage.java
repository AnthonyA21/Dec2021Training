package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import theInternet.pages.PageObjectBase;

public class InternalServerErrorPage extends PageObjectBase {
	private WebDriver driver;

	@FindBy(how=How.TAG_NAME, using="h1")
	private WebElement headerOneElement;

	public InternalServerErrorPage(WebDriver driver) {
		super(driver);
	}

	public String getResultText() {
		return headerOneElement.getText();
	}
}