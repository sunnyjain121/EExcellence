package TestCases;

/* Description: Verification of IPO Page.
 * Created By: Kuldeep Singh
 * Created Date: 19 Aug 2014
 * */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FunctionLibraries.AutomationConstants;
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.IPOPage;

public class IPO_Page {

	private IPOPage ipoPage;
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

	
	// Scenario 1 :This test case will navigate to the forthcoming menu of the IPO tab & will verify the displayed columns & records.
	@Test
	public void IPO_Forthcoming_VerifyForthcomingTab() throws Exception {

		try {
			LoggerInstance.logger.info("***********************IPO_Forthcoming_VerifyForthcomingTab() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Click on Forthcoming IPO page Sub Tab
			LoggerInstance.logger.info("Click on Forthcoming IPO page Sub Tab.");
			ipoPage.clickForthcomingSubTab();

			// Verify that Forthcoming IPO Information Label is displayed
			LoggerInstance.logger.info("Verify Forthcoming tab Information.");
			ipoPage.verifyForthcomingInfoLabel();

			// Verify Information and Documents Tabs are displayed
			LoggerInstance.logger.info("Verify Information and Documents Tabs are displayed.");
			ipoPage.verifyInformationAndDocumentsTabs();

			// Verify Forthcoming Columns header
			LoggerInstance.logger.info("Verify Forthcoming Columns header.");
			ipoPage.verifyColumnsHeaders();

			// Verify Forthcoming tab Records
			LoggerInstance.logger.info("Verify Forthcoming tab Records.");
			ipoPage.verifyForthcomingTabRecords();

			// Verify Forthcoming Guided Search Section
			LoggerInstance.logger.info("Verify Forthcoming Guided Search Section.");
			ipoPage.verifyGuidedSearchSection();

			LoggerInstance.logger.info("***********************IPO_Forthcoming_VerifyForthcomingTab() Ended*********************************");

		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
		}
	}

	
	// Scenario 2: This test case will navigate to the calender menu of the IPO tab & will verify the displayed calender for companies, different sections displayed.
	@Test
	public void IPO_Calender_VerifyCalenderTab() throws Exception {
		try {
			LoggerInstance.logger.info("***********************IPO_Calender_VerifyCalenderTab() Started*********************************");

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

			LoggerInstance.logger.info("***********************IPO_Calender_VerifyCalenderTab() Ended***********************************");

		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
		}
	}

	
	// Scenario 3 :This test case will navigate to IPO tab & will verify the displayed calender for current Month is displayed ,labels navigation buttons .
	@Test
	public void IPO_VerifyCalenderOnIPOPage() throws Exception { 

		try {
			LoggerInstance.logger.info("***********************IPO_VerifyCalenderOnIPOPage() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO
			// page level
			LoggerInstance.logger.info("Verify user is navigated to IPO page.");
			ipoPage.verifyIPOPageLevel();

			// Verify that Calendar is displayed on the page - verify that
			// calendar days are displaying
			LoggerInstance.logger
					.info("Verify that Calendar is displayed on the IPO page.");
			ipoPage.verifyCalendarDisplay();

			// Verify that Calendar current month and year is displayed on the
			// page - verify that calendar current month and year is displaying
			LoggerInstance.logger.info("Verify that Calendar current month and year is displayed on the IPO page.");
			ipoPage.verifyCalendarCurrentMonthAndYearDisplay();

			// Verify that Calendar navigation is displayed on the right upper
			// side of Calendar - verify calendar navigation is displayed
			LoggerInstance.logger.info("Verify that Calendar navigation is displayed on the right upper side of Calendar.");
			ipoPage.verifyCalendarNavigationDisplay();

			// Verify that (Green) Open,(Red) close, (Fellow)Upcoming,
			// (Blue)Listing is displayed - verify color code and text
			LoggerInstance.logger.info("Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.");
			ipoPage.verifyCalendarColorAndText();

			// Verify that Calendar navigation functionality is working or not -
			// verify calendar navigation functionality
			LoggerInstance.logger.info("Verify that Calendar navigation functionality is working or not.");
			ipoPage.verifyCalendarNavigation();

			LoggerInstance.logger.info("***********************IPO_VerifyCalenderOnIPOPage() Ended*********************************");
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
		}
	}

	
	// Scenario 4 :This test case will navigate to Past menu of IPO tab & will verify the different tabs,columns & fields.
	@Test
	public void IPO_Past_VerifyCalenderTab() throws Exception {

		try {
			LoggerInstance.logger.info("***********************IPO_Past_VerifyCalenderTab() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Click on Past IPO page Sub Tab
			LoggerInstance.logger.info("Click on Forthcoming IPO page Sub Tab.");
			ipoPage.clickPastSubTab();

			// Verify that Past IPO Information Label is displayed
			LoggerInstance.logger.info("Verify Past IPO Information.");
			ipoPage.verifyPastIPOInfoLabel();

			// Verify Information and Documents Tabs are displayed
			LoggerInstance.logger.info("Verify Information and Documents Tabs are displayed.");
			ipoPage.verifyInformationAndDocumentsTabsPastIPO();

			// Verify Past IPO Columns header
			LoggerInstance.logger.info("Verify Past IPO Columns header.");
			ipoPage.verifyPastIPOTableHeader();

			// Verify Past tab Records and their order
			LoggerInstance.logger.info("Verify Past IPO tab Records and their order is in Descending.");
			ipoPage.verifyPastIPOTabRecordsDecrendingOrder();

			// Verify that Clicking on Close Date Column, records will be sorted
			// in Ascending Order
			LoggerInstance.logger.info("Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.");
			ipoPage.verifyPastIPOTabRecordsAscendingOrder();

			// Verify Past Guided Search Section
			LoggerInstance.logger.info("Verify Past Guided Search Section.");
			ipoPage.verifyGuidedSearchSection();

			// Verify that after entering Values into fields Close Date From and
			// To and click GO Button, records are displayed where Close date is
			// ranging between From and To dates
			LoggerInstance.logger.info("Verify that after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.");
			ipoPage.verifySearchCriteria();

			// Verify that Under Company Column click on any record and user is
			// navigated to Company's details Page
			LoggerInstance.logger.info("Verify that Under Company Column click on any record and user is navigated to Company's details Page.");
			ipoPage.verifyCompanyClickNevigation();

			LoggerInstance.logger.info("***********************IPO_Past_VerifyCalenderTab() Ended*********************************");

		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
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
