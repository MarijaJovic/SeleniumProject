package phpTravelsTests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsMenu;
import phpTravelsUtils.BasicClass;

public class VerifyTravelsMenu extends BasicClass{
	
	@BeforeTest
	public void getHomepage() throws InterruptedException {
		BasicClass basicClass = new BasicClass();
		basicClass.loginPhpTravels();
	}

	@Test (priority=1)
	public void verifyDashboard() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Dashboard().click();
		Assert.assertTrue(travelsMenu.checkPage("Dashboard"));
	}

	@Test (priority=2)
	public void verifyUpdates() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Updates().click();
		String expectedTitle = "Updates";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=3)
	public void verifyModules() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Modules().click();
		String expectedTitle = "Modules";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=4)
	public void verifyAddNewTours() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Tours().click();
		travelsMenu.addNewInTours().click();
		String expectedTitle = "Add Tour";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=5)
	public void verifyCars() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Cars().click();
		travelsMenu.CarsInCars().click();
		String expectedTitle = "Cars Management";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=6)
	public void verifyCoupons() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Coupons().click();
		String expectedTitle = "Coupon Codes Management";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=7)
	public void verifyNewsletter() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Newsletter().click();
		String expectedTitle = "Newsletter Management";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

	@Test (priority=8)
	public void verifyBookings() throws InterruptedException {
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Bookings().click();
		String expectedTitle = "Booking Management";
		Assert.assertTrue(travelsMenu.checkPage(expectedTitle));
	}

}
