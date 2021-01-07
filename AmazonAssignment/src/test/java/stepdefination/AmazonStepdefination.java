package stepdefination;

import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webObject.AmazonPageObject;
import browsersetup.BrowserSetup;

public class AmazonStepdefination {

	BrowserSetup browserObj = new BrowserSetup();
	Properties objProp = null;

	@Before
	public void browserOpen() throws InterruptedException {

		browserObj = new BrowserSetup();
		browserObj.browserInvoke();

	}

	@After
	public void browserClose() {
		browserObj = new BrowserSetup();
		browserObj.browserClose();
	}

	@Given("^Open Amazon Site$")
	public void Open_Amazon_Site() throws Throwable {
		System.out.println("Application is opened");
	}

	@When("^Application is loaded then verify the title$")
	public void Application_is_loaded_then_verify_the_title() throws Throwable {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.verifyAppTitle();
	}

	@Given("^Search Nikon product$")
	public void Search_Nikon_product() throws Throwable {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.searchproduct();
	}

	@Then("^Sort it in Higest to Lowset order$")
	public void Sort_it_in_Higest_to_Lowset_order() throws Throwable {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.sortproduct();
	}

	@Given("^Click on second product$")
	public void Click_on_second_product() throws InterruptedException {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.clickSecondProduct();
	}

	@When("^Check product details$")
	public void Check_product_details() throws InterruptedException {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.getProductDetails();
	}

	@Then("^Use assert and verify to find Nikon 3DX in product description$")
	public void Use_assert_and_verify_to_find_Nikon_3DX_in_product_description() throws InterruptedException {
		AmazonPageObject objpag = new AmazonPageObject();
		objpag.verfiyandAssert();

	}
}
