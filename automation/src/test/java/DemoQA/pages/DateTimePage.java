package DemoQA.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import theInternet.pages.PageObjectBase;

public class DateTimePage extends PageObjectBase {
	private final String url = "https://demoqa.com/date-picker";
	
	@FindBy(how=How.ID, using="datePickerMonthYearInput")
	private WebElement dateElement;
	
	@FindBy(how=How.ID, using="dateAndTimePickerInput")
	private WebElement dateAndTimeElement;
	
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public DateTimePage(WebDriver driver) {
		super(driver);
	}
	
	public void setDate(LocalDateTime dateTime) {
		String localDateString = "";
		localDateString = dateTime.toLocalDate().format(dateFormatter);
		jse.executeScript("document.getElementById('datePickerMonthYearInput').value = arguments[0];", localDateString);
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		String localDateTimeString = dateTime.format(dateTimeFormatter);
		int commaIndex = localDateTimeString.lastIndexOf(",");
		String newDateString = localDateTimeString.substring(0, commaIndex) + localDateTimeString.substring(commaIndex+1);
		
		jse.executeScript("document.getElementById('dateAndTimePickerInput').value = arguments[0];", newDateString);
	}
	
	public String getDate() {
		return dateElement.getAttribute("value");
		
	}

	public DateTimePage navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public String getDateTime() {
		return dateAndTimeElement.getAttribute("value");
	}

}
