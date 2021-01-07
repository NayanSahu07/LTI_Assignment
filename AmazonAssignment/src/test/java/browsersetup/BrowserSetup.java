package browsersetup;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import propertyReader.Objectproperty;

import commonFile.ConstantKey;

public class BrowserSetup {

	public static WebDriver driver;
	public String appUrl;

	public void browserInvoke() throws InterruptedException {
		Properties objProp = null;

		try {
			objProp = new Objectproperty().propertyFileRead();
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (objProp.getProperty("browserType").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantKey.IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();

		} else if (objProp.getProperty("browserType").equalsIgnoreCase("GoogleChrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantKey.GOOGLECHROME_DRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else if (objProp.getProperty("browserType").equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", ConstantKey.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();

		}
		Thread.sleep(2000);
		driver.get(objProp.getProperty("Amazon_URL"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		objProp.clear();

	}

	public void browserClose() {

		driver.quit();
	}
}
