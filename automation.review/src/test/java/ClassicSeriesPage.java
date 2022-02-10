import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassicSeriesPage extends PageObject {

	public ClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT810EDetailsPage clickSVT810E() {
		this.getDriver().findElement(By.cssSelector("a[href='svt810e/']")).click();
		return new SVT810EDetailsPage(this.getDriver());
	}

}
