package TestCases;

/* Description: Verification of ReportsPage.
 * Created By: Sunny Jain
 * Created Date: 26 Aug 2014
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
import PageObjects.ReportsPage;


public class Reports_Page {
	
	private ReportsPage obj_reportPage;
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
	
	//Scenario 1:This test case will navigate to Research Reports menu of reports tab & will verify the different tabs,click on the report and verify the title of report opened in new window.
	@Test
	public void Reports_ResearchReports_VerifyReportsPage() throws Exception{
		
		try{
		
		LoggerInstance.logger.info("***********************Reports_ResearchReports_VerifyReportsPage() Started*********************************");
		
		// Initialize Page Factory For Reports Page
		obj_reportPage = PageFactory.initElements(driver, ReportsPage.class);
		
		// Click on Research Reports Sub Tab
		LoggerInstance.logger.info("Navigate to Research reports page.");
		obj_reportPage.clickOnResearchReportstab();
		
		//Verify the title of the page.
		LoggerInstance.logger.info("Verify user is navigated to Research reports page.");
		obj_reportPage.verifyTitle();
		
		// Verify the reports tab is displayed.
		LoggerInstance.logger.info("Verify All reports tab is displayed.");
		obj_reportPage.verifyAllReportsTabIsDisplayed();
		
		// Verify the premium tab is displayed.
		LoggerInstance.logger.info("Verify premium tab is displayed.");
		obj_reportPage.verifyPremiumTabIsDisplayed();
		
		// Verify the latest tab is displayed.
		LoggerInstance.logger.info("Verify latest tab is displayed.");
		obj_reportPage.verifyLatestTabIsDisplayed();
		
		// Verify the most viewed tab is displayed.
		LoggerInstance.logger.info("Verify Most viewed tab is displayed.");
		obj_reportPage.verifyMostViewedTabIsDisplayed();
		
		// Click on the first report.
		LoggerInstance.logger.info("Click on the first report link");
		obj_reportPage.clickOnReportLink();
		
		// Switch to the newly opened window
		LoggerInstance.logger.info("Switch to new window");
		obj_reportPage.switchOfNewWindow();
		
		// Verify the title of report opened in new window.
		LoggerInstance.logger.info("Verify the title of new window");
		obj_reportPage.verifyNewWindowTitle();
		
		LoggerInstance.logger.info("***********************Reports_ResearchReports_VerifyReportsPage() Ended*********************************");
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_reportPage = null;
	}
}
	
	// Scenario 2 :This test case will navigate to Daily Wrap menu of reports tab & will verify the tables , tables columns and click on the any date and will verify the same on the newly opened window.
	@Test
	public void Reports_DailyWrap_VerifyDailyWrapPage()
	{
	try
	{
		LoggerInstance.logger.info("***********************Reports_DailyWrap_VerifyDailyWrapPage() Started*********************************");	
		
		// Initialize Page Factory For Reports Page
		obj_reportPage = PageFactory.initElements(driver, ReportsPage.class);
		
		// Verify the page is displayed or not.
		LoggerInstance.logger.info("Verify Daily Market WrapPage Is displayed.");
		obj_reportPage.VerifyDailyMarketWrapPageIsdisplayed();
		
		// Verify the cnx table is displayed .
		LoggerInstance.logger.info("Verify CNX Table Is  displayed on Daily Market WrapPage Page.");
		obj_reportPage.VerifyCNXTableIsdisplayed();
		
		//Verify the BSE sensex table is displayed.
		LoggerInstance.logger.info("Verify BSE Sensex Table Is  displayed on Daily Market WrapPage Page.");
		obj_reportPage.VerifyBSESensexTableIsdisplayed();
	
		
		//Verify The CNX Table date
     	LoggerInstance.logger.info("Verify that CNX Table contains Last Three Dates.");
     	obj_reportPage.VerifyCNXEffectiveDateDisplayed();
		
		//Verify The BSE Sensex Table date
		LoggerInstance.logger.info("Verify that BSE SEnsex Table contains Last Three Dates.");
		obj_reportPage.VerifyBSESensexTableDateDisplayed();
		
		// Verify date and heading  daily wrap and scrap and heading
		LoggerInstance.logger.info("Verify that Daily Scrap  contains Heading and 10 colmun.");
		obj_reportPage.VerifyDailyWrapFrameContainsHeading();
		
		// Verify date and heading  daily wrap and scrap and heading on new loaded page
		LoggerInstance.logger.info("Verify that Daily Scrap  contains Heading as on New Page.");
		obj_reportPage.VerifyDailyWrapDatePageHeading();
		
		LoggerInstance.logger.info("***********************Reports_DailyWrap_VerifyDailyWrapPage()Ended*********************************");	

	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_reportPage = null;
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



