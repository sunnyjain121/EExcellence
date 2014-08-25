package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;

public class HomePage {

    final WebDriver driver;
    private final String xPath_FinalayaImage = "//img[@alt='Finalaya']";
    private final String xPath_MarketNowTab = "//a[text()='Markets Now']";
    private final String linkTest_Companies_tab= "Companies";
    private final String linkTest_MutualFundsTab= "Mutual Funds";
    private final String linkTest_IPOTab = "IPO";
    private final String linkTest_ResearchHubTab = "Research Hub";
    private final String linkTest_WidgetGalleryTab = "Widget Gallery";
    private final String linkTest_ResourcesTab = "Resources";
    private final String linkTest_ReportsTab = "Reports";
    private final String xpath_QuickLink = "//span[contains(.,'QUICK LINKS')]";
   
    private final String xpath_SquareButton = "//img[@src='images/gifs/1x1Spacer.gif']";
    private final String xpath_MarketToday = "//img[@src='Images/NewHomePage/mt_Home.jpg']";
    private final String xpath_Sensex = "//span[contains(.,'SENSEX')]";
    private final String xpath_LatestNews = "//span[contains(.,'Latest News')]";
    private final String xpath_SearchText = "//input[@id='ucHeader_ucSearch_myTextBox']";
    private final String xpath_SearchButton = "//input[@id='ucHeader_ucSearch_btnFinSearch']";
    private final String xpath_RSTText = "//span[@id='ctl00_BodyCPH_lblcompany']";
   
   
    @FindBy(how = How.XPATH, using = xPath_FinalayaImage)
    private WebElement we_FinalayaImage;
   
    @FindBy(how = How.XPATH, using = xPath_MarketNowTab)
    private WebElement we_MarketNowTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_Companies_tab)
    private WebElement we_CompaniesTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_MutualFundsTab)
    private WebElement we_MutualFundsTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_IPOTab)
    private WebElement we_IPOTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_ResearchHubTab)
    private WebElement we_ResearchHubTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_WidgetGalleryTab)
    private WebElement we_WidgetGalleryTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_ResourcesTab)
    private WebElement we_ResourcesTab;
   
    @FindBy(how = How.LINK_TEXT, using = linkTest_ReportsTab)
    private WebElement we_ReportsTab;
   
    @FindBy(how = How.XPATH, using = xpath_SquareButton)
    private WebElement we_SquareButton;
   
    @FindBy(how = How.XPATH, using = xpath_MarketToday)
    private WebElement we_MarketToday;
   
    @FindBy(how = How.XPATH, using = xpath_Sensex)
    private WebElement we_Sensex;
   
    @FindBy(how = How.XPATH, using = xpath_LatestNews)
    private WebElement we_LatestNews;
   
    @FindBy(how = How.XPATH, using = xpath_SearchText)
    private WebElement we_SearchText;
   
    @FindBy(how = How.XPATH, using = xpath_SearchButton)
    private WebElement we_SearchButton;
   
    @FindBy(how = How.XPATH, using = xpath_QuickLink)
    private WebElement we_QuickLink;
   
    @FindBy(how = How.XPATH, using = xpath_RSTText)
    private WebElement we_RSTText;
   
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
   
    public void verifyTabDisplay() {
        FunctionLibrary.verifyTextWebelement("Markets Now", we_MarketNowTab);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        FunctionLibrary.verifyTextWebelement("Companies", we_CompaniesTab);
        FunctionLibrary.verifyTextWebelement("Mutual Funds", we_MutualFundsTab);
        FunctionLibrary.verifyTextWebelement("IPO", we_IPOTab);
        FunctionLibrary.verifyTextWebelement("Research Hub", we_ResearchHubTab);
        FunctionLibrary.verifyTextWebelement("Widget Gallery", we_WidgetGalleryTab);
        FunctionLibrary.verifyTextWebelement("Resources", we_ResourcesTab);
        FunctionLibrary.verifyTextWebelement("Reports", we_ReportsTab);
        FunctionLibrary.verifyTextWebelement("QUICK LINKS", we_QuickLink);
    }
   
    public void clickOnSquareButton() {
        FunctionLibrary.clickWebLink(we_SquareButton);
        FunctionLibrary.verifyTextWebelement("SENSEX", we_Sensex);
    }
   
    public void verifyLatestNewsSection() {
        FunctionLibrary.verifyTextWebelement("Latest News", we_LatestNews);
        //FunctionLibrary.verifyTextWebelement("Market Today", we_MarketToday.getText());
    }
   
    public void verifySearchOnHomePage() {
        we_SearchText.sendKeys("Real Strips Ltd");
        FunctionLibrary.clickWebLink(we_SearchButton);
        FunctionLibrary.verifyTextWebelement("Real Strips Ltd", we_RSTText);
    }
}


