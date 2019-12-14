package phpTravelsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCustomer extends BasicPage {

	private By accounts = By.cssSelector("#social-sidebar-menu > li:nth-child(5) a");
	private By customers = By.cssSelector("#ACCOUNTS li:nth-child(3)");
	private By editCustomer = By.cssSelector(".xcrud-list.table.table-striped.table-hover tbody tr:nth-child(47) .xcrud-current.xcrud-actions.xcrud-fix .btn-group a");
	private By showAllCustomers = By.cssSelector(".xcrud-nav button:nth-child(5)");
	private By firstName = By.name("fname");
	private By lastName = By.name("lname");
	private By email = By.name("email");
	private By password = By.name("password");
	private By mobileNumber = By.name("mobile");
	private By country = By.cssSelector("div#s2id_autogen1");
	private By typeCountry = By.cssSelector(".select2-search input");
	private By address = By.name("address1");
	private By status = By.name("status"); //ovo je select
	private By emailSubscriber = By.name("newssub");
	private By submitButton = By.cssSelector(".panel-footer button");
	private By searchButton = By.cssSelector(".xcrud-search-toggle.btn.btn-default");
	private By inputSearchTerm = By.cssSelector("input[name=phrase]");
	private By goButton = By.cssSelector(".xcrud-action.btn.btn-primary");
	private By checkIfAddedText = By.xpath("//*[text()='james.doe@yopmail.com']");
	
	public TravelsCustomer(WebDriver driver) {
		super(driver);
	}
	
	public WebElement accounts() {
		return this.driver.findElement(accounts);
	}
	
	public WebElement customers() {
		return this.driver.findElement(customers);
	}
	
	public WebElement editCustomer() {
		return this.driver.findElement(editCustomer);
	}
	
	public WebElement showAllCustomers() {
		return this.driver.findElement(showAllCustomers);
	}
	
	public void fillFirstName(String customerName) {
		this.driver.findElement(firstName).clear();
		this.driver.findElement(firstName).sendKeys(customerName);
	}
	
	public void fillLastName(String customerLastName) {
		this.driver.findElement(lastName).clear();
		this.driver.findElement(lastName).sendKeys(customerLastName);	
	}
	
	public void fillEmail(String Email) {
		this.driver.findElement(email).clear();
		this.driver.findElement(email).sendKeys(Email);	
	}
	
	public void fillPassword(String Password) {
		this.driver.findElement(password).clear();
		this.driver.findElement(password).sendKeys(Password);
	}
	
	public void fillMobileNumber(String MobileNumber) {
		this.driver.findElement(mobileNumber).clear();
		this.driver.findElement(mobileNumber).sendKeys(MobileNumber);	
	}
	
	public WebElement Country() {
		return this.driver.findElement(country);
	}
	
	public WebElement typeCountry() {
		return this.driver.findElement(typeCountry);
	}
	
	public void fillAddress(String Address) {
		this.driver.findElement(address).clear();
		this.driver.findElement(address).sendKeys(Address);	
	}
	
	public WebElement status() {
		return this.driver.findElement(status);
	}
	
	public WebElement emailSubscribe() {
		return this.driver.findElement(emailSubscriber);
	}
	
	public WebElement submitButton() {
		return this.driver.findElement(submitButton);
	}
	
	public WebElement searchButton() {
		return this.driver.findElement(searchButton);
	}
	
	public WebElement inputSearchTerm() {
		return this.driver.findElement(inputSearchTerm);
	}
	
	public WebElement goButton() {
		return this.driver.findElement(goButton);
	}
	
	public WebElement checkIfAddedText() {
		return this.driver.findElement(checkIfAddedText);
	}
	
	public void pickCountry(String Country) {
		this.driver.findElement(country).click();
		WebElement searchForCountry = this.driver.findElement(typeCountry);
		searchForCountry.sendKeys(Country);
		searchForCountry.sendKeys(Keys.ENTER);
	}

	public void pickStatus(String Status) {
		WebElement pickStatus = driver.findElement(status);
		Select sStatus = new Select(pickStatus);
		sStatus.selectByVisibleText(Status);
	}
	
}
