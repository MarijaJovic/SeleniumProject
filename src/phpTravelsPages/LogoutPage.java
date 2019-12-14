package phpTravelsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasicPage{

	private By logout = By.id("logout");

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	public By getLogout() {
		return logout;
	}
	
	public WebElement logoutButton() {
		return this.driver.findElement(logout);
	}
}