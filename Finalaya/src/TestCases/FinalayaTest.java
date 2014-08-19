package TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Logger.LoggerInstance;
import FunctionLibraries.FunctionLibrary;
import PageObjects.MarketPage;

public class FinalayaTest {
	
	private MarketPage obj_marketPage;
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception {
		driver = FunctionLibrary.getWebDriver("firefox");
		driver.manage().window().maximize();
		driver.get("http://www.finalaya.com/");
		LoggerInstance l= new LoggerInstance();
		// Initialize Page Factory For Market Page
		obj_marketPage = PageFactory.initElements(driver,MarketPage.class);
		
		
	}// End public void setUp()
	@Test(alwaysRun=true)
	public void test(){
		
		obj_marketPage.clickOnMarketTab();
		LoggerInstance.logger.info("Verify user is navigated to Market page.");
		obj_marketPage.verifyMarketPageIsDisplayed();
		obj_marketPage.clickOnBSETab();
		LoggerInstance.logger.info("verify current value of sensex is displayed.");
		obj_marketPage.verifyCurrentValueOfSensexIsDisplayed();
		LoggerInstance.logger.info("verify value change of sensex is displayed.");
		obj_marketPage.verifyValueChangeOfSensexIsDisplayed();
		LoggerInstance.logger.info("verify Percentage change of sensex is displayed.");
		obj_marketPage.verifyPercentageChangeOfSensexIsDisplayed();
		LoggerInstance.logger.info("verify Open, Low, High and Pre Close of Sensex is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
		obj_marketPage.clickOnNSETab();
		LoggerInstance.logger.info("verify current value of Nifty is displayed.");
		obj_marketPage.verifyCurrentValueOfNiftyIsDisplayed();
		LoggerInstance.logger.info("verify Percentage change of Nifty is displayed.");
		obj_marketPage.verifyPercentageChangeOfNiftyIsDisplayed();
		LoggerInstance.logger.info("verify value change of Nifty is displayed.");
		obj_marketPage.verifyValueChangeOfNiftyIsDisplayed();
		LoggerInstance.logger.info("verify Open, Low, High and Pre Close of Nifty is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
			
	}
	
	
}
