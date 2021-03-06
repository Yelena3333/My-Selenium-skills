package WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		// Puts an Implicit wait, Will wait for 10 seconds before throwing
		// exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch web-site
		driver.navigate().to("http://www.calculator.net/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Use element's path described once in PercentCalculatorPage class
		PercentCalculatorPage.lnk_percent_calc(driver).click();

		PercentCalculatorPage.txt_num_1(driver).clear();
		PercentCalculatorPage.txt_num_1(driver).sendKeys("10");

		PercentCalculatorPage.txt_num_2(driver).clear();
		PercentCalculatorPage.txt_num_2(driver).sendKeys("50");

		PercentCalculatorPage.btn_calc(driver).click();

		// Get the Result Text
		String result = PercentCalculatorPage.web_result(driver).getText();

		result = result.replaceAll("\\D", "");

		// Print a Log In message to the console
		System.out.println(" The Result is " + result);

		if (result.equals("5")) {
			System.out.println(" The Result is Passed");
		} else {
			System.out.println(" The Result is Failed");
		}

		// Close the Browser
		// driver.close();
		driver.quit();

	}

}
