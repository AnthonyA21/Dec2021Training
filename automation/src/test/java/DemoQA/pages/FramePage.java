package DemoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import theInternet.pages.PageObjectBase;

public class FramePage extends PageObjectBase {
	final private String destination =  "https://demoqa.com/nestedframes";
	
	@FindBy(how = How.ID, using="frame1")
	WebElement parent_frame;
	
	private WebElement mappedElement;
	
	public FramePage(WebDriver driver) {
		super(driver);
	}
	
	public FramePage navigate() {
		this.driver.navigate().to(destination);
		return this;
	}
	
	public String changeFrame() {
		String result = "";
		this.driver = this.driver.switchTo().frame(parent_frame);
		mappedElement = this.driver.findElement(By.cssSelector("iframe[srcdoc='<p>Child Iframe</p>']"));
		this.driver = driver.switchTo().frame(mappedElement);
		
		//this.driver.switchTo().frame(mappedElement);
		result = driver.findElement(By.tagName("p")).getText();
		
		return result;
	}
}
