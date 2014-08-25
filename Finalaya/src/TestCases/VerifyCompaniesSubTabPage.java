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
import PageObjects.VerifyCompaniesSubTab;


public class VerifyCompaniesSubTabPage {
	
	
	
	private VerifyCompaniesSubTab CompaniesSubTab;
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
			CompaniesSubTab = PageFactory.initElements(driver,VerifyCompaniesSubTab.class);
			
			//Verify Microsite Page Is displayed
	
		CompaniesSubTab.VerifyMicrositePageIsdisplayed();
		
		//Verify Results Page Is displayed
		CompaniesSubTab.verifyResultsPageIsdisplayed();
		
		//Verify AnnoucementPage Page Is displayed
		CompaniesSubTab.VerifyAnnoucementPageIsdisplayed();
		
		//Verify CompareCompanies Page Is displayed
		CompaniesSubTab.VerifyCompareCompaniesPageIsdisplayed();
		
		//Verify IndustriesPage  Is displayed
		
		CompaniesSubTab.verifyIndustriesPageIsdisplayed();
		
		
		//Verify Document Page Is displayed
		CompaniesSubTab.VerifyDocumentPageIsdisplayed();
		
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("Exception occured.");
			
	
		}
		
	
	
	}
	
	
	@AfterMethod
	public void tear()
	{
		
		driver.close();
	}

}
