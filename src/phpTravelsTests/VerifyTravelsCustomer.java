package phpTravelsTests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.TravelsCustomer;
import phpTravelsUtils.BasicClass;

public class VerifyTravelsCustomer extends BasicClass {

	@Test
	public void verifyCustomers() throws InterruptedException {
		BasicClass basicClass = new BasicClass();
		basicClass.loginPhpTravels();
		TravelsCustomer travelCustomer = new TravelsCustomer(driver);
		travelCustomer.accounts().click();
		travelCustomer.customers().click();
		travelCustomer.showAllCustomers().click();
		travelCustomer.editCustomer().click();
		travelCustomer.fillFirstName("James");
		travelCustomer.fillLastName("Doe");
		travelCustomer.fillEmail("james.doe@yopmail.com");
		travelCustomer.fillPassword("test1234");
		travelCustomer.fillMobileNumber("079123445");
		travelCustomer.pickCountry("Serbia");
		travelCustomer.fillAddress("Random street");
		travelCustomer.pickStatus("Enabled");
		travelCustomer.emailSubscribe().click();
		JavascriptExecutor JSE = (JavascriptExecutor) driver;
		JSE.executeScript("window.scrollBy(0,1000)");
		travelCustomer.submitButton().click();
		travelCustomer.searchButton().click();
		travelCustomer.inputSearchTerm().sendKeys("james.doe@yopmail.com");
		travelCustomer.goButton().click();
		Thread.sleep(2000);
		Assert.assertEquals(travelCustomer.checkIfAddedText().getText(), "james.doe@yopmail.com");
	}
}