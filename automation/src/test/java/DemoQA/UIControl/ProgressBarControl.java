package DemoQA.UIControl;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ProgressBarControl extends UIControlBase {
	private WebElement mappedElement;
	
	By progress_bar = By.id("progressBar");
	
	public ProgressBarControl(WebDriver driver, WebElement element) {
		super(driver);
		this.mappedElement = element;
	}
	
	public String start() {
		WebElement startButton = this.mappedElement.findElement(By.id("startStopButton"));
		startButton.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		WebElement reset_button = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("resetButton"));
			}
		});
		String result = this.mappedElement.findElement(progress_bar).getText();
		reset_button.click();
		return result;
	}
	
}
