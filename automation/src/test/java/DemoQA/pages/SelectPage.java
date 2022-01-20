package DemoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import framework.OldStyleDropdownList;
import theInternet.pages.PageObjectBase;

public class SelectPage extends PageObjectBase {
	private final String url = "https://demoqa.com/select-menu";
	
	@FindBy(how=How.ID, using="oldSelectMenu")
	private WebElement oldSelectElement;
	
	OldStyleDropdownList pageSelectMenu = new OldStyleDropdownList(oldSelectElement);
	
	public SelectPage(WebDriver driver) {
	    super(driver);
	}

	public void selectValue(String menuValue) {
		pageSelectMenu.setValue(menuValue);
	}
	
	public String getSelectValue() {
		return pageSelectMenu.getValue();
	}
	
	public String[] getMenuOptions() {
		return pageSelectMenu.getOptions();
	}

	public SelectPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

}
