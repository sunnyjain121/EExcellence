package TestCases;

/* Description: Verification of Mutual Funds Page.
 * Created By: Darwin Bhandari
 * Created Date: 19 Aug 2014
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
import PageObjects.MutualFundsPage;

public class MutualFunds_Page {

	private MutualFundsPage obj_mutualfundspage;
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
	
	//Scenario 1: Verify text for Mutual Funds tool-tip and that user is able to navigate to all sub-tabs
	
	@Test()
	public void MutualFunds_VerifyTextAndNavigation() {
		try {
			LoggerInstance.logger.info("*************MutualFunds_VerifyTextAndNavigation() Started**************");
		
		// Initialize Page Factory For MutualFunds Page
			obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
				
		// Verify that text is displayed correctly
		LoggerInstance.logger.info("Verify that text is displayed correctly");
		obj_mutualfundspage.verifyTextMF();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds House item
		LoggerInstance.logger.info("Click on Funds House item");
		obj_mutualfundspage.clickOnFundHouses();
		
		// Verify Funds House page is opened
		LoggerInstance.logger.info("Verify Funds House page is opened");
		obj_mutualfundspage.verifyFundHousesNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds item
		LoggerInstance.logger.info("Click on Funds item");
		obj_mutualfundspage.clickOnFunds();
		
		// Verify Funds page is opened
		LoggerInstance.logger.info("Verify Funds page is opened");
		obj_mutualfundspage.verifyFundsNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds Screener item
		LoggerInstance.logger.info("Click on Funds Screener item");
		obj_mutualfundspage.clickOnFundScreener();
		
		// Verify Funds Screener page is opened
		LoggerInstance.logger.info("Verify Funds Screener page is opened");
		obj_mutualfundspage.verifyFundScreenerNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Portfolio Churning item
		LoggerInstance.logger.info("Click on Portfolio Churning item");
		obj_mutualfundspage.clickOnPortChur();
		
		// Verify Portfolio Churning page is opened
		LoggerInstance.logger.info("Verify Portfolio Churning page is opened");
		obj_mutualfundspage.verifyPortChurNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Compare Funds item
		LoggerInstance.logger.info("Click on Compare Funds item");
		obj_mutualfundspage.clickOnCompareFunds();
		
		// Verify Compare Funds page is opened
		LoggerInstance.logger.info("Verify Compare Funds page is opened");
		obj_mutualfundspage.verifyCompFundsNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Monthly Score Card item
		LoggerInstance.logger.info("Click on Monthly Score Card item");
		obj_mutualfundspage.clickOnMonthlySCard();
		
		// Verify Monthly Score card page is opened
		LoggerInstance.logger.info("Verify Monthly Score card page is opened");
		obj_mutualfundspage.verifyMSCNavigation();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on New Fund Offers item
		LoggerInstance.logger.info("Click on New Fund Offers item");
		obj_mutualfundspage.clickOnNewFOffers();
		
		// Verify New Fund Offers page is opened
		LoggerInstance.logger.info("Verify New Fund Offers page is opened");
		obj_mutualfundspage.verifyNFONavigation();
		
		LoggerInstance.logger.info("***********MutualFunds_VerifyTextAndNavigation() Ended**************");
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_mutualfundspage = null;
		}	
	}	
	
	
	//Scenario 2: This test case will navigate to  Monthly Score Card page and verify color and value
	
@Test
public void MutualFunds_MonthScoreCard_VerifyColorAndValue() {
	try {
		LoggerInstance.logger.info("**************MutualFunds_MonthScoreCard_VerifyColorAndValue() Started**************");
	
	// Initialize Page Factory For MutualFunds Page
		obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
	
	// Hover mouse over Mutual Funds tab
	LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
	obj_mutualfundspage.hoverMouse();
	
	// Click on Monthly Score card item
	LoggerInstance.logger.info("Click on Monthly Score card item");
	obj_mutualfundspage.clickOnMonthlySCard();
	
	// Verify Top 5 Fund Houses in terms of Corpus (displayed in BLUE)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses in terms of Corpus (displayed in BLUE)");
	obj_mutualfundspage.verifyCorpusColour();
	
	// Verify Top 5 Fund Houses Gainers on Corpus basis(displayed in GREEN)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses Gainers on Corpus basis(displayed in GREEN)");
	obj_mutualfundspage.verifyCorpusGainersColour();
	
	// Verify Top 5 Fund Houses Losers on Corpus basis(displayed in RED)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses Losers on Corpus basis(displayed in RED)");
	obj_mutualfundspage.verifyCorpusLosersColour();
	
	// Verify Top 5 NAV (%) Gainers (displayed in GREEN)
	LoggerInstance.logger.info("Verify Top 5 NAV (%) Gainers (displayed in GREEN)");
	obj_mutualfundspage.verifyNAVGainersColour();
	
	// Verify Top 5 NAV (%) Losers tables (displayed in RED)
	LoggerInstance.logger.info("Verify Top 5 NAV (%) Losers tables (displayed in RED)");
	obj_mutualfundspage.verifyNAVLosersColour();
	
	// Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Gainers on Corpus basis
	LoggerInstance.logger.info("Verify same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainers on Corpus basis");
	obj_mutualfundspage.verifyValueCorpusGainers();
	
	// Hover mouse over Mutual Funds tab
	LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
	obj_mutualfundspage.hoverMouse();
	
	// Click on Monthly Score card page
	LoggerInstance.logger.info("Click on Monthly Score card page");
	obj_mutualfundspage.clickOnMonthlySCard();
	
	// Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Losers on Corpus basis
	LoggerInstance.logger.info("Verify same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Losers on Corpus basis");
	obj_mutualfundspage.verifyValueCorpusLosers();
	
	LoggerInstance.logger.info("***********MutualFunds_MonthScoreCard_VerifyColorAndValue() Ended**************");
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_mutualfundspage = null;
	}	
}
	
	
	//Scenario 3: This test case will navigate to  Compare Funds page and verify text and graph

  @Test()
	public void MutualFunds_CompareFunds_VerifyTextAndGraph() throws Throwable  {
		try {
			LoggerInstance.logger.info("************MutualFunds_CompareFunds_VerifyTextAndGraph() Started**************");
		// Initialize Page Factory For MutualFunds Page
			obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Hover mouse over Compare Funds item
		LoggerInstance.logger.info("Hover mouse over Compare Funds item");
		obj_mutualfundspage.hoverMouseCF();
		
		// Verify that expected text is displayed on Page
		LoggerInstance.logger.info("Verify that expected text is displayed on Page");
		obj_mutualfundspage.verifyTextCF();
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");	
		obj_mutualfundspage.hoverMouse();
		
		// Click on Compare Funds item
		LoggerInstance.logger.info("Click on Compare Funds item");
		obj_mutualfundspage.clickOnCompareFunds();
		
		// Verify Comparison Graph is displayed
		LoggerInstance.logger.info("Verify Comparison Graph is displayed");
		obj_mutualfundspage.compareFundsGraph("S&P AUTO", "S&P BANKEX");
		
		LoggerInstance.logger.info("************MutualFunds_CompareFunds_VerifyTextAndGraph() Ended**************");
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_mutualfundspage = null;
		}	
	}	
	

	// This method will be run after each method present in test case file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
	}	
}

