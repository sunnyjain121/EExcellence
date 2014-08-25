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
import PageObjects.HomePage;
import PageObjects.MarketPage;


public class MarketPageTest {
	
	private MarketPage obj_marketPage;
	WebDriver driver;
	
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
			LoggerInstance.logger.info("Browser launched");
			driver.manage().window().maximize();
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			LoggerInstance.logger.info("Navigated to "+url);
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} 

	}
	
	@Test
	public void testMarketTab1(){
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		obj_marketPage.clickOnMarketTab();
		LoggerInstance.logger.info("Verify user is navigated to Market page.");
		obj_marketPage.verifyMarketPageIsDisplayed();
		obj_marketPage.clickOnBSETab();
		LoggerInstance.logger.info("Verify current value of sensex is displayed.");
		obj_marketPage.verifyCurrentValueOfSensexIsDisplayed();
		LoggerInstance.logger.info("Verify value change of sensex is displayed.");
		obj_marketPage.verifyValueChangeOfSensexIsDisplayed();
		LoggerInstance.logger.info("Verify Percentage change of sensex is displayed.");
		obj_marketPage.verifyPercentageChangeOfSensexIsDisplayed();
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Sensex is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
		obj_marketPage.clickOnNSETab();
		LoggerInstance.logger.info("Verify current value of Nifty is displayed.");
		obj_marketPage.verifyCurrentValueOfNiftyIsDisplayed();
		LoggerInstance.logger.info("Verify Percentage change of Nifty is displayed.");
		obj_marketPage.verifyPercentageChangeOfNiftyIsDisplayed();
		LoggerInstance.logger.info("Verify value change of Nifty is displayed.");
		obj_marketPage.verifyValueChangeOfNiftyIsDisplayed();
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Nifty is displayed.");
		obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed();
			
	}
	@Test
	public void testMarketTab2() throws InterruptedException{
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		LoggerInstance.logger.info("Navigate to ETF Zone tab");
		obj_marketPage.clickOnETFZoneTab();
		LoggerInstance.logger.info("Verify user is navigated to ETF Zone page.");
		obj_marketPage.verifyETFZonePageIsDisplayed();
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyGoldETFTableIsDisplayed();
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		LoggerInstance.logger.info("Select Non Gold from Underlying drpdwn");
		obj_marketPage.selectValueFromUnderlying("Non Gold");
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		LoggerInstance.logger.info("Select Gold from Underlying drpdwn");
		obj_marketPage.selectValueFromUnderlying("Gold");
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed();
		LoggerInstance.logger.info("Verify negative value is displayed in red color");
		obj_marketPage.verifyNegativeValueColor();
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
	}
}
