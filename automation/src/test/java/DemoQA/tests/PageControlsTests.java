package DemoQA.tests;

import org.testng.annotations.Test;

import DemoQA.pages.LinksPage;
import DemoQA.pages.RadioButtonPage;
import DemoQA.pages.SelectPage;
import DemoQA.pages.SliderPage;
import framework.TestBase;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PageControlsTests extends TestBase {
	
	@Test
	public void canClickRadioButton() {
		String strYes = "Yes", strImpressive = "Impressive", strNo = "No";
		RadioButtonPage radioButtonPage = new RadioButtonPage(this.getDriver()).navigate();
		
		radioButtonPage.clickRadioButton(strYes);
		String yesResult = radioButtonPage.getRadioValue();
		Assert.assertEquals(yesResult, strYes,
				"After clicking radio button, page did not display expected result text.");
		
		radioButtonPage.clickRadioButton(strImpressive);
		String impressiveResult = radioButtonPage.getRadioValue();
		Assert.assertEquals(impressiveResult, strImpressive,
				"After clicking radio button, page did not display expected result text.");
		
		radioButtonPage.clickRadioButton(strNo);
		String noResult = radioButtonPage.getRadioValue();
		Assert.assertNotEquals(noResult, strNo,
				"After clicking radio button, page did not display expected result text.");		
		
	}
	
	@Test
	public void canClickNotFoundLink() {
		String expectedResponseText = "Link has responded with staus 404 and status text Not Found";

		LinksPage linksPage = new LinksPage(this.getDriver()).navigate().clickLink();
		String responseText = linksPage.getResponseText();

		Assert.assertEquals(responseText, expectedResponseText,
				"After clicking link, page did not display expected response text.");
	}
	
	@Test
	public void canSetSliderValues() {
		  String[] testValues = {"80", "17", "0", "100"};
		  String testValue = "";
		  SliderPage sliderPage = new SliderPage(this.getDriver()).navigate();
		  for (int i = 0; i < testValues.length; i++) {
			  testValue = testValues[i];
			  sliderPage.setSliderValue(testValue);
			  String resultText = sliderPage.getSliderValue();
			  Assert.assertEquals(resultText, testValue);
		  }		
		
	}
	
	@Test 
	public void canSetDropdownValue() {
		String testText = "Indigo";
		SelectPage selectPage = new SelectPage(this.getDriver()).navigate();
		
		selectPage.selectValue(testText);
		String actualText = selectPage.getSelectValue();
		
		Assert.assertEquals(actualText, testText);
	}
	
	@Test
	public void canGetAllDropdownValues() {
		String[] testArray = {"Red","Blue","Green","Yellow","Purple","Black","White","Voilet","Indigo","Magenta","Aqua"};
		SelectPage selectPage = new SelectPage(this.getDriver()).navigate();
		
		String[] actualArray = selectPage.getMenuOptions();
		
		Assert.assertEquals(actualArray, testArray);		
		
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
