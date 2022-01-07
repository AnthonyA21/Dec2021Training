package DemoQA.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.Slider;
import theInternet.pages.PageObjectBase;

public class SliderPage extends PageObjectBase {
	private final String url = "https://demoqa.com/slider";
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@FindBy(how=How.CSS, using="input[class='range-slider range-slider--primary']")
	private WebElement sliderElement;
	
	@FindBy(how=How.ID, using="sliderValue")
	private WebElement sliderValueElement;

	public SliderPage(WebDriver driver) {
	    super(driver);
	}

	public SliderPage setSliderValue(String valueStr) {
		Slider pageSlider = new Slider(sliderValueElement);
		pageSlider.setValue(valueStr, jse);
		return this;
	}
	
	public String getSliderValue() {
		Slider pageValueSlider = new Slider(sliderValueElement);
		return pageValueSlider.getValue();		
	}

	public SliderPage navigate() {
		this.driver.navigate().to(url);
		return this;
	}
	
}
