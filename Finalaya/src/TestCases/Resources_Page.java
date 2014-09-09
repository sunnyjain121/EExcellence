package TestCases;

/* Description: Verification of Resource Page.
 * Created By: Mohd Suhail
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
import PageObjects.ResourcesPage;


public class Resources_Page {

	private ResourcesPage obj_resourcePage;
	static WebDriver driver;

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
			LoggerInstance.logger.info("Navigated to  " + url);
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} finally {
			browser = null;
			url = null;
			inputConfig = null;
		}
	}

	// Scenario 1 :This test case will navigate to the Resource tab  & Verify  General Economic Indicator Page is displayed and General Economic Contains RBI Reference Exchange Column.
	@Test
	public void Resource_VerifyGeneralEconmicIndicatorPage() throws Exception {

		try {
			LoggerInstance.logger.info("*********************** Resource_VerifyGeneralEconmicIndicatorPage() Started*********************************");

			// Initialize Page Factory For Resource  Page
			obj_resourcePage = PageFactory.initElements(driver, ResourcesPage.class);

			//Click on Resource Tab
			obj_resourcePage.clickOnResourceTab();
			//Verify that General Economic Indicator Is Displayed.
			LoggerInstance.logger.info("Verify General Economic Indicator Page is displayed.");
			obj_resourcePage.verify_GeneralEconomicIndicatorsIsDisplayed();
		    //Verify that KeyEconomic Page is displayed
			LoggerInstance.logger.info("Verify KeyEconomic Page is displayed.");
			obj_resourcePage.verify_KeyEconomic();
		    //Verify CCil Indicators Indices Page is displayed.
			LoggerInstance.logger.info("Verify CCil Indicators Indices Page is displayed.");
			obj_resourcePage.verify_CCilIndicatorsIndicesIsDisplayed();
			//Verify NSE FIMMDA Indicators Page is displayed .
			LoggerInstance.logger.info("Verify NSE FIMMDA Indicators Page is displayed.");
			obj_resourcePage.verify_NSEFIMMDAIndicatorsIsDisplayed();
			
			//Verify General Economic Contains Indicator Column.
			LoggerInstance.logger.info("Verify General Economic Contains Indicator Column");
			obj_resourcePage.verify_GeneralEconomicContainsIndicator();
			//Verify General Economic Contains RBIPolicy Indicator Column.
			LoggerInstance.logger.info("Verify General Economic Contains RBIPolicy Indicator Column");
			obj_resourcePage.verify_GeneralEconomicContainsRBIPolicyIndicator();
			
			//Verify General Economic Contains RBI Reference Exchange Column.
			LoggerInstance.logger.info("Verify General Economic Contains RBI Reference Exchange Column");
			obj_resourcePage.verify_GeneralEconomicContainsRBIReferenceExchange();
			

			LoggerInstance.logger.info("***********************Resource_VerifyGeneralEconmicIndicatorPage()  Ended*********************************");
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_resourcePage = null;
		}
	}

	// This method will be run after each method present in testcase file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
	}

}
