import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
		this.doNothing(5);
		this.doNothing("Nothing");
	}

	public HomePage navigate() {
		this.getDriver().navigate().to("https://ampeg.com/index.html");
		
		return this;
	}

	public ProductsPage clickProductsLink() {
		this.getDriver().findElement(By.cssSelector("a[title='Products']")).click();
		return new ProductsPage(this.getDriver());
	}
	
	//Override annotation not needed in Java
	@Override
	public void doNothing() {
		//do nothing some other way
	}
}
