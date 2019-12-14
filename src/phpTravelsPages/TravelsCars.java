package phpTravelsPages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCars extends BasicPage {

	private By rowsOfOrders = By.cssSelector(".form-control.input-sm"); 
	private By rowsOfCars = By.tagName("tr");
	private By addButton = By.cssSelector("table.table-striped.table-hover tr th a");
	private By addPhotoBtn = By.cssSelector("table.table-striped.table-hover tr th a");
	private By insertPhoto = By.cssSelector("input[type='file']");
	
	public TravelsCars(WebDriver driver) {
		super(driver);
	}

	public WebElement rowsOfCars() {
		return this.driver.findElement(rowsOfCars);
	}
	
	public WebElement rowsOfOrders() {
		return this.driver.findElement(rowsOfOrders);
	}
	
	public WebElement addButton() {
		return this.driver.findElement(addButton);
	}
	
	public WebElement addPhoto() {
		return this.driver.findElement(addPhotoBtn);
	}
	
	public WebElement insertPhoto() {
		return this.driver.findElement(insertPhoto);
	}
	
	public int checkTableSize() {
		List<WebElement> listOfRows = driver.findElements(rowsOfCars);
		return (listOfRows.size() - 1);
	}

	public boolean isMoreThen50() {
		boolean NmbrOfCars50 = false;
		int sum = 0;
		List<WebElement> listOfOrders = driver.findElements(rowsOfOrders);
		for (int i = 0; i < listOfOrders.size(); i++) {
			String str = listOfOrders.get(i).getAttribute("value");
			int number = Integer.valueOf(str);
			sum = sum + number;
		}
		if (sum > 50) {
			NmbrOfCars50 = true;
		}
		return NmbrOfCars50;
	}

	public void clickOnUpload() {
		List<WebElement> tableRows = driver.findElements(rowsOfCars);
		WebElement firstRow = tableRows.get(1);
		WebElement upload = firstRow.findElement(By.cssSelector("td:nth-child(9) a"));
		upload.click();
	}
	
	public void uploadPhoto(String path) {
		insertPhoto().sendKeys(new File(path).getAbsolutePath());
	}
	
	public String checkUploadText() {
		List<WebElement> rows = driver.findElements(rowsOfCars);
		WebElement row = rows.get(1);
		WebElement uploadText = row.findElement(By.cssSelector("td:nth-child(9) a"));
		String checkText = uploadText.getText();
		return checkText;
	}
	
}
