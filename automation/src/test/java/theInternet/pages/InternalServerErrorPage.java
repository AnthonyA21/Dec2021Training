package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InternalServerErrorPage extends PageObjectBase {

	@FindBy(how=How.TAG_NAME, using="h1")
	private WebElement headerOneElement;

	public InternalServerErrorPage(WebDriver driver) {
		super(driver);
	}

	public String getResultText() {
		return headerOneElement.getText();
	}
}