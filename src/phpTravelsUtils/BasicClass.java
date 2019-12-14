package phpTravelsUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import phpTravelsPages.TravelsLogin;

public class BasicClass {
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
	
	public void loginPhpTravels() throws InterruptedException {
		String homepage = "https://www.phptravels.net/admin";
		TravelsLogin travelsLogin = new TravelsLogin(driver);
		driver.get(homepage);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TravelsUtils travelsUtils = new TravelsUtils();
		travelsUtils.setExcell("test-data//Username.xlsx");
		travelsUtils.setWorkSheet(0);
		for (int i = 1; i < travelsUtils.getRowNumber(); i++) {
			travelsLogin.inputEmail(travelsUtils.getDataAt(i, 0));
			travelsLogin.inputPassword(travelsUtils.getDataAt(i, 1));
		}
		travelsUtils.closeExcell();
		travelsLogin.loginButton().click();
	}
}