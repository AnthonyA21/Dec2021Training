package DemoQA.tests;

import org.testng.annotations.Test;

import DemoQA.pages.DateTimePage;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DateTimeTests extends TestBase {
	@Test
	public void canPopulateDateField() {
		LocalDateTime testDate = LocalDateTime.now();
		DateTimePage dateTimePage = new DateTimePage(this.getDriver()).navigate();

		dateTimePage.setDate(testDate);
		String resultText = dateTimePage.getDate();

		Assert.assertEquals(resultText, "01/06/2022");
	}
	
	@Test
	public void canPopulateDateTimeField() {
		LocalDateTime testDate = LocalDateTime.of(2022, 1, 1, 20, 0);
		DateTimePage dateTimePage = new DateTimePage(this.getDriver()).navigate();
		
		dateTimePage.setDateTime(testDate);
		String resultText = dateTimePage.getDateTime();
		
		Assert.assertEquals(resultText, "January 1, 2022 8:00 PM");
		
		
	}

	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}

}
