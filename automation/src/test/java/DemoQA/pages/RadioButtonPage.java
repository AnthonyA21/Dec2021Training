package DemoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.RadioButton;
import theInternet.pages.PageObjectBase;

public class RadioButtonPage extends PageObjectBase {
	
	private final String url = "https://demoqa.com/radio-button";
	
	@FindBy(how=How.ID, using="yesRadio")
	private WebElement yesRadioElement;
	
	@FindBy(how=How.ID, using="impressiveRadio")
	private WebElement impressiveRadioElement;

	@FindBy(how=How.ID, using="noRadio")
	private WebElement noRadioElement;
	
	@FindBy(how=How.CLASS_NAME, using="text-success")
	private WebElement resultElement;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	RadioButton pageYesRadioButton = new RadioButton(yesRadioElement);
	RadioButton pageImpressiveRadioButton = new RadioButton(impressiveRadioElement);
	RadioButton pageNoRadioButton = new RadioButton(impressiveRadioElement);
	RadioButton pageResultText = new RadioButton(resultElement);
	
	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}	
	
	public RadioButtonPage clickRadioButton(String label) {
		switch (label) {
			case "Yes":
				pageYesRadioButton.select(label);
				break;
			case "Impressive":
				pageImpressiveRadioButton.select(label);
				break;
			case "No":
				pageNoRadioButton.select(label);
				break;
			default:
				break;
		}
    
		return this;
	}
	
	public String getRadioValue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));		
		return pageResultText.getSelected();
	}

	public RadioButtonPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}
}
