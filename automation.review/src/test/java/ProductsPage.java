import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends PageObject {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public ClassicSeriesPage clickClassicSeries() {
		this.getDriver().findElement(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']")).click();
		return new ClassicSeriesPage(this.getDriver());
	}

}
