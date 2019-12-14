package phpTravelsPages;

import org.openqa.selenium.WebDriver;

public class BasicPage {

	protected WebDriver driver;
	protected String baseUrl = "https://www.phptravels.net/admin";
	
	public BasicPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
	
}
