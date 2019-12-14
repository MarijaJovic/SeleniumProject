package phpTravelsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsMenu extends BasicPage {
	
	private By dashboard = By.cssSelector(".fa.fa-desktop");
	private By updates = By.className("fa-refresh");
	private By modules = By.className("fa-cube");
	private By tours = By.cssSelector("#social-sidebar-menu > li:nth-child(9) > a");
	private By addNewInTours = By.cssSelector("#Tours > li:nth-child(2) > a");
	private By cars = By.cssSelector("#social-sidebar-menu > li:nth-child(10) > a");
	private By carsInCars = By.cssSelector("#Cars > li:nth-child(1) > a");
	private By coupons = By.cssSelector("#social-sidebar-menu > li:nth-child(15) > a");
	private By newsletter = By.cssSelector("a[href='https://www.phptravels.net/admin/newsletter/']");
	private By bookings = By.cssSelector("a[href='https://www.phptravels.net/admin/bookings/']");
	
	public TravelsMenu(WebDriver driver) {
		super(driver);
	}
	
	public By getDashboard() {
		return dashboard;
	}

	public By getUpdates() {
		return updates;
	}

	public By getModules() {
		return modules;
	}

	public By getTours() {
		return tours;
	}

	public By getCars() {
		return cars;
	}

	public By getCarsInCars() {
		return carsInCars;
	}

	public By getAddNewInTours() {
		return addNewInTours;
	}

	public By getCoupons() {
		return coupons;
	}

	public By getNewsletter() {
		return newsletter;
	}

	public By getBookings() {
		return bookings;
	}
	
	public WebElement Dashboard() {
		return this.driver.findElement(dashboard);
	}
	
	public WebElement Updates() {
		return this.driver.findElement(updates);
	}
	
	public WebElement Modules() {
		return this.driver.findElement(modules);
	}
	
	public WebElement Tours() {
		return this.driver.findElement(tours);
	}
	
	public WebElement addNewInTours() {
		return this.driver.findElement(addNewInTours);
	}
	
	public WebElement Cars() {
		return this.driver.findElement(cars);
	}
	
	public WebElement CarsInCars() {
		return this.driver.findElement(carsInCars);
	}
	
	public WebElement Coupons() {
		return this.driver.findElement(coupons);
	}
	
	public WebElement Newsletter() {
		return this.driver.findElement(newsletter);
	}
	
	public WebElement Bookings() {
		return this.driver.findElement(bookings);
	}
	
	public boolean checkPage(String expected) {
		String actual = driver.getTitle();
		boolean b = false;
		if (actual.contains(expected)) {
			b = true;
		}
		return b;
	}
	
}
