package phpTravelsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import phpTravelsPages.LogoutPage;
import phpTravelsUtils.BasicClass;

public class VerifyLogin extends BasicClass {
	
	@Test
	public void verifyLoggingIn() throws InterruptedException {
		BasicClass basicClass = new BasicClass();
		basicClass.loginPhpTravels();
		String logoutText = "Logout";
		LogoutPage logoutPage = new LogoutPage(driver);
		Assert.assertEquals(logoutPage.logoutButton().getText(), logoutText);
	}
}