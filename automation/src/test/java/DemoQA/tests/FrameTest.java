package DemoQA.tests;

import org.testng.annotations.Test;

import DemoQA.pages.FramePage;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FrameTest extends TestBase{
  @Test
  public void canSwitchFrames() {
	  final String check_inner_text = "Child Iframe";
	  String result = "";
	  
	  FramePage iframe_page = new FramePage(this.getDriver())
			  .navigate();
	  
	  result = iframe_page.changeFrame();
	  
	  Assert.assertEquals(result, check_inner_text);
  }
  @BeforeMethod
  public void beforeMethod() {
	  super.setup();
  }

  @AfterMethod
  public void afterMethod() {
	  super.cleanup();
  }

}
