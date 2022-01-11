package DemoQA.tests;

import org.testng.annotations.Test;

import DemoQA.pages.ProgressBarPage;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ProgressBarTest extends TestBase{
  @Test
  public void canMakeProgress() {
	  final String check_done = "100%";
	  ProgressBarPage progress_page = new ProgressBarPage(this.getDriver())
			  .navigate();
	  
	  String result = progress_page.getProgressControl().start();
	  Assert.assertEquals(result, check_done);
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
