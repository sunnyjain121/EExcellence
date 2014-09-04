package TestCases;

/* Description: Verification of Market Page .
 * Created By: Rohit Mighlani
 * Created Date: 13 Aug 2014
 * */

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
import PageObjects.HomePage;
import PageObjects.MarketPage;


public class Market_Page {
	
	private MarketPage obj_marketPage;
	WebDriver driver;
	
	Properties prop = new Properties();
	
	// This method would be run before each method present in testcase file & will launch browser & will open application.
	@BeforeMethod
	public void setUp() throws Exception {
		String browser = null;
		String url = null;
		// Create input stream object of property file.
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		// Create the logger instance object
		LoggerInstance l = new LoggerInstance();
		try {
			prop.load(inputConfig);
			// To get browser value from property file
			browser = prop.get(AutomationConstants.BROWSER).toString();
			// Initialize driver object of particular browser.
			driver = WebDriverBrowser.getWebDriver(browser);
			LoggerInstance.logger.info("Browser launched");
			// Maximize the browser window.
			driver.manage().window().maximize();
			// To get application url value from property file.
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			LoggerInstance.logger.info("Navigated to "+url);
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} 

	}
	// Scenario 1 :This test case will navigate to the Market Page and will Verify all the Sensex Value and and Nifty Value is Displayed.
	@Test
	public void Market_VerifyMarketTab(){
		try {
		LoggerInstance.logger.info("***********************Market Verify MarketTab() Started*********************************");
		// Initialize Page Factory For Market Page
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		obj_marketPage.clickOnMarketTab();
		// Verify user is navigated to Market page
		LoggerInstance.logger.info("Verify user is navigated to Market page.");
		obj_marketPage.verifyMarketPageIsDisplayed();
		// Click On BSE Tab.
		obj_marketPage.clickOnBSETab();
		// Verify current value of sensex is displayed.
		LoggerInstance.logger.info("Verify current value of sensex is displayed.");
		obj_marketPage.verifyCurrentValueOfSensexIsDisplayed();
		// Verify value change of sensex is displayed.
		LoggerInstance.logger.info("Verify value change of sensex is displayed.");
		obj_marketPage.verifyValueChangeOfSensexIsDisplayed();
		// Verify Percentage change of sensex is displayed.
		LoggerInstance.logger.info("Verify Percentage change of sensex is displayed.");
		obj_marketPage.verifyPercentageChangeOfSensexIsDisplayed();
		// Verify Open, Low, High and Pre Close of Sensex is displayed.
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Sensex is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
		// Click On NSE Tab.
		obj_marketPage.clickOnNSETab();
		// Verify current value of Nifty is displayed.
		LoggerInstance.logger.info("Verify current value of Nifty is displayed.");
		obj_marketPage.verifyCurrentValueOfNiftyIsDisplayed();
		// Verify Percentage change of Nifty is displayed.
		LoggerInstance.logger.info("Verify Percentage change of Nifty is displayed.");
		obj_marketPage.verifyPercentageChangeOfNiftyIsDisplayed();
		// Verify value change of Nifty is displayed.
		LoggerInstance.logger.info("Verify value change of Nifty is displayed.");
		obj_marketPage.verifyValueChangeOfNiftyIsDisplayed();
		// Verify Open, Low, High and Pre Close of Nifty is displayed.
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Nifty is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
		LoggerInstance.logger.info("***********************Market Verify MarketTab() Ended*********************************");

		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_marketPage = null;
		}
			
	}
	// Scenario 2 :This test case will navigate  to ETF Zone page and will Verify Gold ETF Table is displayed.
	@Test
	public void Market_VerifyETFTab() throws InterruptedException{
		try {
		LoggerInstance.logger.info("***********************Market Verify ETFTab() Started*********************************");
		// Initialize Page Factory For Market Page
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		// Navigate to ETF Zone tab.
		LoggerInstance.logger.info("Navigate to ETF Zone tab");
		obj_marketPage.clickOnETFZoneTab(driver);
		// Verify user is navigated to ETF Zone page.
		LoggerInstance.logger.info("Verify user is navigated to ETF Zone page.");
		obj_marketPage.verifyETFZonePageIsDisplayed();
		// Verify Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyGoldETFTableIsDisplayed();
		// Verify Verify Non Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		// Select Non Gold from Underlying dropdown.
		LoggerInstance.logger.info("Select Non Gold from Underlying dropdown");
		obj_marketPage.selectValueFromUnderlying("Non Gold");
		// Verify Non Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		// Select Gold from Underlying dropdown.
		LoggerInstance.logger.info("Select Gold from Underlying dropdown");
		obj_marketPage.selectValueFromUnderlying("Gold");
		// Verify Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		// Verify negative value is displayed in red color
		LoggerInstance.logger.info("Verify negative value is displayed in red color");
		obj_marketPage.verifyNegativeValueColor();
		LoggerInstance.logger.info("***********************Market Verify ETFTab() Ended*********************************");
		
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_marketPage = null;
	}
	}
	// This method will be run after each method present in testcase file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed.");
	}
}
