package TestCases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FunctionLibraries.AutomationConstants;
import Logger.LoggerInstance;
import FunctionLibraries.FunctionLibrary;
import PageObjects.IPOPage;

public class IPOPageTest {

	static WebDriver driver;
	//Properties prop = new Properties();

	/*@BeforeMethod
	public void openBroswer() throws Exception {
		String browser = null;
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		try {
			prop.load(inputConfig);
			browser = prop.get(AutomationConstants.BROWSER).toString();
			driver = FunctionLibrary.getWebDriver(browser);
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	@Test
	public void verifyIPOTabCal() throws Exception {

		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			driver = FunctionLibrary.getWebDriver("firefox");
			
			//url = prop.get(AutomationConstants.URL).toString();
			driver.get("http://www.finalaya.com");
			IPOPage ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO page level
			ipoPage.verifyIPOPageLevel();

			// Verify that Calendar is displayed on the page - verify that calendar days are displaying
			ipoPage.verifyCalendarDisplay();

			// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
			ipoPage.verifyCalendarCurrentMonthAndYearDisplay();

			// Verify that Calendar navigation is displayed on the right upper side of Calendar - verify calendar navigation is displayed
			ipoPage.verifyCalendarNavigationDisplay();

			// Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed - verify color code and text
			ipoPage.verifyCalendarColorAndText();
			
			// Verify that Calendar navigation functionality is working or not - verify calendar navigation functionality
			ipoPage.verifyCalendarNavigation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
