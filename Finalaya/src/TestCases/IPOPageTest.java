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
import FunctionLibraries.FunctionLibrary;
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.IPOPage;

public class IPOPageTest {

	private IPOPage ipoPage;
	static WebDriver driver;

	Properties prop = new Properties();

	@BeforeMethod
	public void setUp() throws Exception {
		String browser = null;
		String url = null;
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		LoggerInstance l = new LoggerInstance();
		try {
			prop.load(inputConfig);
			browser = prop.get(AutomationConstants.BROWSER).toString();
			driver = WebDriverBrowser.getWebDriver(browser);
			driver.manage().window().maximize();
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			browser=null;
			url=null;
			inputConfig=null;
		}

	}

	@Test
	public void verifyIPOTabCal() throws Exception {

		try {
			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO page level
			LoggerInstance.logger.info("Verify user is navigated to IPO page.");
			ipoPage.verifyIPOPageLevel();

			// Verify that Calendar is displayed on the page - verify that calendar days are displaying
			LoggerInstance.logger.info("Verify that Calendar is displayed on the IPO page.");
			ipoPage.verifyCalendarDisplay();

			// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
			LoggerInstance.logger.info("Verify that Calendar current month and year is displayed on the IPO page.");
			ipoPage.verifyCalendarCurrentMonthAndYearDisplay();

			// Verify that Calendar navigation is displayed on the right upper side of Calendar - verify calendar navigation is displayed
			LoggerInstance.logger.info("Verify that Calendar navigation is displayed on the right upper side of Calendar.");
			ipoPage.verifyCalendarNavigationDisplay();

			// Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed - verify color code and text
			LoggerInstance.logger.info("Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.");
			ipoPage.verifyCalendarColorAndText();

			// Verify that Calendar navigation functionality is working or not - verify calendar navigation functionality
			LoggerInstance.logger.info("Verify that Calendar navigation functionality is working or not.");
			ipoPage.verifyCalendarNavigation();
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		}finally{
			ipoPage=null;
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
