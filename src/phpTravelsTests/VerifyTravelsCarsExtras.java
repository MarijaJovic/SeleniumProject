package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCarsExtras;
import phpTravelsUtils.BasicClass;

public class VerifyTravelsCarsExtras extends BasicClass {
	
	@Test (priority=1)
	public void cars() throws InterruptedException {
		BasicClass basicClass = new BasicClass();
		basicClass.loginPhpTravels();
		TravelsCarsExtras travelsCarsExtras = new TravelsCarsExtras(driver);
		travelsCarsExtras.Cars().click();
		travelsCarsExtras.CarsExtras().click();
		travelsCarsExtras.ExtrasAdd().click();
		travelsCarsExtras.NameCars().sendKeys("Corey's Car");
		travelsCarsExtras.uploadImage("test-data\\corey.jpg");
		Thread.sleep(2000);
		travelsCarsExtras.setStatus("No");
		travelsCarsExtras.Price().sendKeys("55000");
		travelsCarsExtras.SaveAndReturn().click();
		Assert.assertTrue(travelsCarsExtras.isImageUpload());
	}

	@Test (priority=2)
	public void findCarName() {
		TravelsCarsExtras travelsCarsExtras = new TravelsCarsExtras(driver);
		Assert.assertTrue(travelsCarsExtras.checkIfCarIsAdded("Corey's Car"));
	}
	
	@Test (priority=3)
	public void inputStringInPriceFieldTest() throws InterruptedException {
		TravelsCarsExtras travelsCarsExtras = new TravelsCarsExtras(driver);
		travelsCarsExtras.Cars().click();
		travelsCarsExtras.CarsExtras().click();
		travelsCarsExtras.ExtrasAdd().click();
		travelsCarsExtras.NameCars().sendKeys("Corey's Car");
		travelsCarsExtras.setStatus("Yes");
		travelsCarsExtras.Price().sendKeys("Price");
		travelsCarsExtras.SaveAndReturn().click();
		travelsCarsExtras.inputStringInPriceField();
		Assert.assertTrue(travelsCarsExtras.inputStringInPriceField());
	}
	
}