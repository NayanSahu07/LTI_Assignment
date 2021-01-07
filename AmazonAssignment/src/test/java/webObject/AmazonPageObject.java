package webObject;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import browsersetup.BrowserSetup;

public class AmazonPageObject {

	BrowserSetup browserObj = new BrowserSetup();
	Properties objProp = null;

	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[(@id='twotabsearchtextbox') and (@type='text')]")
	WebElement SearchField;
	@FindBy(how = How.XPATH, using = "//span[@data-action='a-dropdown-button']")
	WebElement SortBy;
	@FindBy(how = How.XPATH, using = "(//div[@class='a-section a-spacing-none']/h2/a)[2]")
	WebElement SecondProduct;
	@FindBy(how = How.XPATH, using = "(//div[@class='a-section a-spacing-none']/h2/a)[2]")
	WebElement SecondProductTitle;
	@FindBy(how = How.XPATH, using = "//*[@id='productTitle']")
	WebElement SecondProductDescription;

	public AmazonPageObject() {
		this.driver = BrowserSetup.driver;
		PageFactory.initElements(driver, this);
		this.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	public void verifyAppTitle() {
		System.out.println("Appliaction is open");
		driver = browserObj.driver;
		String actaulTitle = driver.getTitle();
		System.out.println(actaulTitle);
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		if (actaulTitle.equals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
	}

	public void searchproduct() {
		driver = browserObj.driver;
		System.out.println("Search product");
		SearchField.sendKeys("Nikon");
		SearchField.sendKeys(Keys.ENTER);
	}

	public void sortproduct(){
		driver = browserObj.driver;
		System.out.println("Sort product");
		SortBy.click();
		driver.findElement(By.linkText("Price: High to Low")).click();
	}

	public void clickSecondProduct() {
		driver = browserObj.driver;
		searchproduct();
		sortproduct();
		SecondProduct.click();
	}

	public void getProductDetails() throws InterruptedException {
		driver = browserObj.driver;
		String details =SecondProductDescription.getText();
		System.out.println(details);
	}

	public void verfiyandAssert() throws InterruptedException {
		driver = browserObj.driver;
		String Productdetails =SecondProductDescription.getText();
		String Contains = "Nikon 3DX";
		SoftAssertions sa = new SoftAssertions();
		sa.assertAll();
	}
}
