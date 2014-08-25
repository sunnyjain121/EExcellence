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
import PageObjects.VerifyCompaniesPage;


public class VerifyCompaniesTabTest 


{
	
	
	
	private VerifyCompaniesPage companiesPage;
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
	public void test1() throws InterruptedException
	{
		try{
			// Initialize Page Factory For Companies Page
			
			companiesPage = PageFactory.initElements(driver,VerifyCompaniesPage.class);
			
		      //Clicking on Companies tab
		companiesPage.clickOnCompaniesTab();
		

		//Verify Document  Tab Is Present
		companiesPage.verifyInformationTab();
		
		//Verify Document  Tab Is Present
		companiesPage.verifyDocumentTabIsDisplayed();
		
		//Verify Company Name Is Sorted Ascending order
		companiesPage.VerifyComanyNameSortedAscending();
		
		//Verify Company Name Is Sorted Descending order
		
		companiesPage.VerifyComanyNameSorteDecendingOrder();
		
		 //Clicking on Companies tab
		companiesPage.clickOnCompaniesTab();
		
		//Verify Company Table Heading is Displayed and verified
		companiesPage.VerifyComanyTableHeadingIsDisplayed();
		
		 //Clicking on Industries tab
		companiesPage.clicktab();
		
		//Verify Company name and Industry column value is matching with tool tip text.
		companiesPage.VerifyToolTipCompanyValIndustryColumnValMatches();
		
       //Verify BSE Text red color have down arrow and green color text have up arrow
		companiesPage.VerifyBSEArrowColorTextVal();
		
		//Verify NSE Text red color have down arrow and green color text have up arrow
		companiesPage.VerifyNSEArrowColorTextVal();
		
		//Verify Image is right displayed to text
		companiesPage.verifyImageLeftTextIsDisplayed();
		
		//Verify Image is left displayed to text
		companiesPage.verifyImageLeftTextIsDisplayed();
		
		//Verify Pagination occurs or not
		companiesPage.verifyPaginationdisplayed();
		
		//Verify Pagination Clicking on Next and Previous button
		companiesPage.verifyClickingNextPreviousDislayedPage();
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("Exception occured.");
			
	
		}
		
		
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tear()
	{
		
		driver.quit();;
	}

}
