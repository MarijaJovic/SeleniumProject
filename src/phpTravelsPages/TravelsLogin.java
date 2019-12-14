package phpTravelsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLogin extends BasicPage {
	
	private By inputEmail = By.name("email");
	private By inputPassword = By.name("password");
	private By rememberMe = By.className("checkbox");
	private By forgotPassword = By.id("link-forgot");
	private By loginButton = By.cssSelector(".btn.btn-primary.btn-block");

	public TravelsLogin(WebDriver driver) {
		super(driver);
	}
	
	public By getInputEmail() {
		return inputEmail;
	}

	public By getInputPassword() {
		return inputPassword;
	}

	public By getRememberMe() {
		return rememberMe;
	}

	public By getForgotPassword() {
		return forgotPassword;
	}

	public By getLoginButton() {
		return loginButton;
	}

	public void goToHomepage(String homepage) throws InterruptedException {
		this.driver.get(homepage);
		Thread.sleep(2000);
	}
	
	public void forgotPassword() throws InterruptedException {
		this.driver.findElement(forgotPassword).click();
		Thread.sleep(2000);
	}
	
	public void inputEmail(String email) {
		this.driver.findElement(inputEmail).sendKeys(email);
	}
	
	public void inputPassword(String password) throws InterruptedException {
		this.driver.findElement(inputPassword).sendKeys(password);
		Thread.sleep(1000);
	}
	
	public void remeberMe() {
		this.driver.findElement(rememberMe).click();
	}
	
	public WebElement loginButton() {
		return this.driver.findElement(loginButton);
	}
	
}
