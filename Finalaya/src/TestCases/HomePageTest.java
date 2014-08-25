
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;
import PageObjects.HomePage;


public class HomePageTest {

    static WebDriver driver;
   
    @Test
    public void verifyHomeTabCal() throws Exception {

        LoggerInstance loggerObj = new LoggerInstance();
        LoggerInstance.logger.info("main method started");
        String url = null;
        try {
            driver = FunctionLibrary.getWebDriver("firefox");
            LoggerInstance.logger.info("Called firefox driver");
            driver.get("http://www.finalaya.com");
            LoggerInstance.logger.info("Open finalaya l");
            driver.manage().window().maximize();
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);

            // Verifying HomePage tab
            homePage.verifyTabDisplay();
           
            //Click on first square button and Verifying Market Today,sensex text
            homePage.clickOnSquareButton();
           
            //Verify Latest News Section
            homePage.verifyLatestNewsSection();
           
            //Verify Search on home page
            homePage.verifySearchOnHomePage();
           
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


