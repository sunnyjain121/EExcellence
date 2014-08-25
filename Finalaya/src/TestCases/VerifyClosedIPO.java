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
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.IPOPage;

/* Description: Verify Closed IPO
* Created By: Kuldeep Singh
* Created Date: 19 Aug 2014
* */

public class VerifyClosedIPO {

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
		} finally {
			browser = null;
			url = null;
			inputConfig = null;
		}

	}

	@Test
	public void verifyClosedIPO() throws Exception {

		try {
			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO page level
			LoggerInstance.logger.info("Verify user is navigated to IPO page.");
			ipoPage.verifyIPOPageLevel();

			// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
			LoggerInstance.logger.info("Verify that Calendar current month and year is displayed on the IPO page.");
			ipoPage.verifyCalendarCurrentMonthAndYearDisplay();

			// Verify that IPO Microsite where Company Name is displayed as Label
			LoggerInstance.logger.info("Verify that IPO Microsite where Company Name is displayed as Label");
			ipoPage.verifyCalendarCompanyies();

			// Verify that On IPO Microsite Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports
			LoggerInstance.logger.info("Verify that On IPO Microsite Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports");
			ipoPage.verifyIPOMicrositeTableHeader();

		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
