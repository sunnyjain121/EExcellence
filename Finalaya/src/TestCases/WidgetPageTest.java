package TestCases;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FunctionLibraries.AutomationConstants;
import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;
import PageObjects.WidgetPage;


public class WidgetPageTest {
	static WebDriver driver;
	Properties prop = new Properties();

	@BeforeMethod
	public void openBroswer() throws Exception {
		 String browser = null;
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		try {
			prop.load(inputConfig);
			browser = prop.get(AutomationConstants.BROWSER).toString();
			driver = FunctionLibrary.getWebDriver(browser);
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void verifyCompanySnapshot() throws Exception {

		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();

			// Clicking on Company Snapshot
			LoggerInstance.logger.info("Clicking company snapshot link");
			widgetPage.clickoncompanysnapshot();	
			
			// Verify that Company name with NSE and BSE is displayed
			LoggerInstance.logger.info("verification step");
			widgetPage.verifycompanysnapshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void verifyBseTopGainersLosers() throws Exception {

		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();

			// Clicking on BSE Top Losers and Gainers
			LoggerInstance.logger.info("Clicking on BSE Top Losers and Gainers");
			widgetPage.clickonbsetoplosergainer();	
			
			// Verify that Company name with NSE and BSE is displayed
			LoggerInstance.logger.info("verification step");
			widgetPage.verifycompanysnapshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifylinkspresentonwidgetpage() throws IOException{
		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();
			
			// Verify links present on Widget Tab
			LoggerInstance.logger.info("verifying links present on Widget tab");
			widgetPage.verifylinkspresent();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void verifymarketBreadthlinkonwidgetpage() throws IOException{
		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();
			
			// Verify market breadth link and sub icons like refresh feedback on Widget Tab
			LoggerInstance.logger.info("Verify market breadth link and sub icons like refresh feedback on Widget Tab");
			widgetPage.verifymarketBreadthlink();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void verifymarketindicewidgetlinkonwidgetpage() throws IOException{
		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();
			
			// Verify market indice link on Widget Tab
			LoggerInstance.logger.info("Verify market indice link on Widget Tab");
			widgetPage.verifymarketIndicelink();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void verifysectionbyonwidgetpage() throws IOException{
		LoggerInstance loggerObj = new LoggerInstance();
		LoggerInstance.logger.info("main method started");
		String url = null;
		try {
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			WidgetPage widgetPage = PageFactory.initElements(driver, WidgetPage.class);

			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");			
			widgetPage.clickOnWidgetTab();
			
			// Verify section by on Widget Tab
			LoggerInstance.logger.info("verification step");
			widgetPage.verifysectionby();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
