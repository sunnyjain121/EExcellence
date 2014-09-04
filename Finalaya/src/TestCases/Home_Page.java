package TestCases;

/* Description: Verification of Home Page .
 * Created By: Anjul Tiwari
 * Created Date: 23 Aug 2014
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
import FunctionLibraries.FunctionLibrary;
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.HomePage;


public class Home_Page {

	static WebDriver driver;
	private HomePage homePage;

	Properties prop = new Properties();

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
	
	// Scenario 1 :This test case will navigate to the Home Page and will Verify Sub Tab Menu and Latest News Section..
	@Test
	public void Home_VerifyNewsSection() throws Exception {
		try {
			LoggerInstance.logger.info("***********************Home_VerifyTabValue() Started*********************************");
			
			// Initialize Page Factory For HOME Page
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);

			// Verifying HomePage tab
			LoggerInstance.logger.info("Click on Home Page Tab.");
			homePage.verifyTabDisplay();
			
			//Click on first square button and Verifying Market Today,SenSex Text
			LoggerInstance.logger.info("Click on square button and verify Market today, sensex text.");
			homePage.clickOnSquareButton();
			
			//Verify Latest News Section
			LoggerInstance.logger.info("Verify latest news section.");
			homePage.verifyLatestNewsSection();
			
			//Verify Search on home page
			LoggerInstance.logger.info("Click on home page search.");
			homePage.verifySearchOnHomePage();
			
			LoggerInstance.logger.info("***********************Home_VerifyTabValue() Ended*********************************");
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			homePage = null;
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

