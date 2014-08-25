package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;
import PageObjects.MonthlyScoreCardPage;

public class MonthlyScoreCardTest {

	private MonthlyScoreCardPage obj_MonthlyScoreCardPage;
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception {
		driver = FunctionLibrary.getWebDriver("firefox");
		driver.manage().window().maximize();
		driver.get("http://www.finalaya.com/IPO/Calendar.aspx");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoggerInstance l = new LoggerInstance();
		
	// Initialize Page Factory For MutualFunds Page
		obj_MonthlyScoreCardPage = PageFactory.initElements(driver,MonthlyScoreCardPage.class);
	}// End public void setUp()
	
	@Test(alwaysRun=true)
	
	public void test() throws Throwable{
		
		obj_MonthlyScoreCardPage.hoverMouse();
		Thread.sleep(2000);
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_MonthlyScoreCardPage.clickOnMonthlySCard();
		Thread.sleep(2000);
		obj_MonthlyScoreCardPage.verifyCorpusColour();
		obj_MonthlyScoreCardPage.verifyCorpusGainersColour();
		obj_MonthlyScoreCardPage.verifyCorpusLosersColour();
		obj_MonthlyScoreCardPage.verifyNAVGainersColour();
		obj_MonthlyScoreCardPage.verifyNAVLosersColour();
		
		obj_MonthlyScoreCardPage.verifyValueCorpusGainers();
		Thread.sleep(1000);
		obj_MonthlyScoreCardPage.hoverMouse();
		obj_MonthlyScoreCardPage.clickOnMonthlySCard();
		obj_MonthlyScoreCardPage.verifyValueCorpusLosers();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
