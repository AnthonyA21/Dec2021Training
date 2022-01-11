package DemoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DemoQA.UIControl.ProgressBarControl;
import theInternet.pages.PageObjectBase;

public class ProgressBarPage extends PageObjectBase {
	final private String destination = "https://demoqa.com/progress-bar";
	private ProgressBarControl progress_element;
	
	public ProgressBarPage(WebDriver driver) {
		super(driver);
	}
	
	public ProgressBarPage navigate() {
		this.driver.navigate().to(destination);
		return this;
	}
	
	public ProgressBarControl getProgressControl() {
		WebElement element = driver.findElement(By.id("progressBarContainer"));
		ProgressBarControl progress_control = new ProgressBarControl(this.driver, element);
		progress_element = progress_control;
		return progress_element;
	}

}
