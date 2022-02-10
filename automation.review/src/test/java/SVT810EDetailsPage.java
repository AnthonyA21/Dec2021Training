import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SVT810EDetailsPage extends PageObject {

	public SVT810EDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getArtistName() {
		return this.getDriver().findElement(By.cssSelector("[id='artist'] b")).getText(); 
	}

}
