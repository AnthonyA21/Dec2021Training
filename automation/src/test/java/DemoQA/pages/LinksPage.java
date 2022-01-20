package DemoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.Hyperlink;
import theInternet.pages.PageObjectBase;

public class LinksPage extends PageObjectBase {
	private final String url = "https://demoqa.com/links";
	
	@FindBy(how=How.ID, using="invalid-url")
	private WebElement linksElement;
	
	@FindBy(how=How.ID, using="linkResponse")
	private WebElement linkResponseElement;

	public LinksPage(WebDriver driver) {
	    super(driver);
	}

	public LinksPage clickLink() {
		String linkText = "Not Found";
		Hyperlink pageHyperlink = new Hyperlink(linksElement);
		pageHyperlink.click(linkText);
		return this;
	}

	public LinksPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}
	
	public String getResponseText() {
		return linkResponseElement.getText();
	}	

}
