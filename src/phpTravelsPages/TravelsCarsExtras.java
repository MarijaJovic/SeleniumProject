package phpTravelsPages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCarsExtras extends BasicPage {
	
	private By cars = By.cssSelector("#social-sidebar-menu > li:nth-child(10) > a");	
	private By carsExtras = By.cssSelector("#Cars > li:nth-child(2)");
	private By extrasAdd = By.cssSelector(".btn.btn-success.xcrud-action");
	private By saveAndReturn = By.cssSelector("[data-task='save']");
	private By addImage = By.name("xcrud-attach");
	private By nameCars = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
	private By status = By.name("cHRfZXh0cmFzLmV4dHJhc19zdGF0dXM-");
	private By price = By.name("cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--");
	private By uploadPhotoCheck = By.cssSelector("tr.xcrud-row td:nth-child(3)");
	private By tableRows = By.cssSelector("div.xcrud-list-container > table > tbody > tr");
	
	public TravelsCarsExtras(WebDriver driver) {
		super(driver);
	}

	public By getCars() {
		return cars;
	}
	
	public By getAddImage() {
		return addImage;
	}

	public void setAddImage(By addImage) {
		this.addImage = addImage;
	}

	public By getNameCars() {
		return nameCars;
	}

	public void setNameCars(By nameCars) {
		this.nameCars = nameCars;
	}

	public By getStatus() {
		return status;
	}

	public void setStatus(By status) {
		this.status = status;
	}

	public By getPrice() {
		return price;
	}

	public void setPrice(By price) {
		this.price = price;
	}

	public By getCarsExtras() {
		return carsExtras;
	}

	public By getExtrasAdd() {
		return extrasAdd;
	}

	public By getSaveAndReturn() {
		return saveAndReturn;
	}
	
	public WebElement Cars() {
		return this.driver.findElement(cars);
	}
	
	public WebElement CarsExtras() {
		return this.driver.findElement(carsExtras);
	}
	
	public WebElement ExtrasAdd() {
		return this.driver.findElement(extrasAdd);
	}
	
	public WebElement SaveAndReturn() {
		return this.driver.findElement(saveAndReturn);
	}
	
	public WebElement AddImage() {
		return this.driver.findElement(addImage);
	}
	
	public WebElement NameCars() {
		return this.driver.findElement(nameCars);
	}
	
	public WebElement Status() {
		return this.driver.findElement(status);
	}
	
	public WebElement Price() {
		return this.driver.findElement(price);
	}
	
	public void setStatus(String Status) {
		WebElement selectStatus = driver.findElement(status);
		Select pickStatus = new Select(selectStatus);
		List<WebElement> allOptions = pickStatus.getOptions();

		for (int i = 0; i < allOptions.size(); i += 1) {
			if (Status == "Yes") {
				pickStatus.selectByVisibleText("Yes");
			} else {
				pickStatus.selectByVisibleText("No");
			}
		}
	}
	
	public void uploadImage(String path) {
		AddImage().sendKeys(new File(path).getAbsolutePath());
	}

	public boolean isImageUpload() {
		try {
			return this.driver.findElement(uploadPhotoCheck) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean checkIfCarIsAdded(String myCarName) {
		boolean check = false;

		List<WebElement> rows = driver.findElements(tableRows);
		for (int i = 0; i < rows.size(); i += 1) {
			WebElement row = rows.get(i);
			WebElement carName = row.findElement(By.cssSelector("td:nth-child(4)"));
			String name = carName.getText();
			if (name.equals(myCarName)) {
				check = true;
			}
		}
		return check;
	}

	public boolean inputStringInPriceField() {
		return Price().getAttribute("class").contains("validation-error");
	}
	
}
