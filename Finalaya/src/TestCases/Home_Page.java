package TestCases;

/* Description: Verification of Home Page .
 * Created By: Anjul Tiwari
 * Created Date: 23 Aug 2014
 * */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
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
import Reports.CustomMethodReport;


public class Home_Page {

	static WebDriver driver;
	private HomePage homePage;

	Properties prop = new Properties();
	
	CustomMethodReport cmr = new CustomMethodReport();
	FunctionLibrary fLib = new FunctionLibrary();
	PrintWriter printWrite = null;
	boolean isVerificationPassed= true;
	
	@BeforeMethod
	public void setUp(Method method) throws Exception {
		String browser = null;
		String url = null;
		
		//Call create Writer method to generate the html file
		printWrite = cmr.createWriter(method.getName());
		cmr.startHtmlPage(printWrite);
		
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
			boolean isVerifyTabDisplay = homePage.verifyTabDisplay();
			
			if(isVerifyTabDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Home Page tab is displayed.", "Home Page Tab is displayed.", "Home Page Tab is displayed.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Home Page tab is displayed.", "Home Page Tab is displayed.", "Home Page Tab is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Click on first square button and Verifying Market Today,SenSex Text
			LoggerInstance.logger.info("Click on square button and verify Market today, sensex text.");
			homePage.clickOnSquareButton();
			
			//Verify Latest News Section
			LoggerInstance.logger.info("Verify latest news section.");
			boolean isVerifyLatestNewsSection = homePage.verifyLatestNewsSection();
			
			if(isVerifyLatestNewsSection) {
				cmr.generateExecutionReport(printWrite, "Verify if latest news section is displayed.", "Latest news section is displayed.", "Latest news section is displayed.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if latest news section is displayed.", "Latest news section is displayed.", "Latest news section is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Search on home page
			LoggerInstance.logger.info("Click on home page search.");
			boolean isVerifySearchOnHomePage = homePage.verifySearchOnHomePage();
			if(isVerifySearchOnHomePage){
				cmr.generateExecutionReport(printWrite, "Verify if Company Name is searched.", "Company Name is searched.", "Company Name is searched.", true, null);
			} else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Company Name is searched.", "Company Name is searched.", "Company Name is not searched.", false, fLib.captureScreenshot());
			}
			LoggerInstance.logger.info("***********************Home_VerifyTabValue() Ended*********************************");
			
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			homePage = null;
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
	}

	// This method will be run after each method present in testcase file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed.");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}

}

