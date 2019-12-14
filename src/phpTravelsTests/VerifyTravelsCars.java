package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCars;
import phpTravelsPages.TravelsMenu;
import phpTravelsUtils.BasicClass;

public class VerifyTravelsCars extends BasicClass{

	@BeforeTest
	public void getHomepage() throws InterruptedException {
		BasicClass basicClass = new BasicClass();
		basicClass.loginPhpTravels();
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Cars().click();
		travelsMenu.CarsInCars().click();
	}
	
	@Test (priority=1)
	public void verifyNumberOfCarModels() {
		TravelsCars travelsCars = new TravelsCars(driver);
		travelsCars.checkTableSize();
		Assert.assertEquals(travelsCars.checkTableSize(), 40);
	}
	
	@Test (priority=2)
	public void verifyNumberOfOrders() {
		TravelsCars travelsCars = new TravelsCars(driver);
		Assert.assertTrue(travelsCars.isMoreThen50());
	}
	
	@Test (priority=3)
	public void uploadPhoto() throws InterruptedException {
		TravelsCars travelsCars = new TravelsCars(driver);
		String textBeforeUploadPhoto = travelsCars.checkUploadText();
		travelsCars.clickOnUpload();
		travelsCars.addButton().click();
		travelsCars.uploadPhoto("test-data\\corey.jpg");
		Thread.sleep(5000);
		TravelsMenu travelsMenu = new TravelsMenu(driver);
		travelsMenu.Cars().click();
		travelsMenu.CarsInCars().click();
		String textAfterUploadPhoto = travelsCars.checkUploadText();
		Assert.assertNotEquals(textBeforeUploadPhoto, textAfterUploadPhoto);
	}
	
}