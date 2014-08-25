package PageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import FunctionLibraries.FunctionLibrary;


public class WidgetPage {
	WebDriver driver;

	
	private final String linkTest_widgetGallery_tab="Widget Gallery";
	private final String linkTest_company_snapshot_link="Company Snapshot";
	private final String xpath_widget_lbl="//span[contains(@id,'lblWidgetName')]";
	private final String xpath_BSE_lbl="//span[contains(.,'BSE:')]";
	private final String company="//a[@class='companyTitle']";
	private final String bseTopGainersLosers="//a[contains(.,'BSE Top Gainers & Losers')]";
	private final String xpath_BSE_MarketTicker="//a[@title='BSE Market Ticker']";
	private final String xpath_NiftyTicker="//a[@title='Nifty Ticker']";
	private final String xpath_MarketBreadth="//a[@title='Market Breadth']";
	private final String id_latestImpression="lnkJustViewed";
	private final String id_justDownloaded="lnkJustDownloaded";
	private final String id_mostDownloaded="lnkMostDownloaded";
	private final String xpath_refresh="//img[@alt='Refresh']";
	private final String xpath_getwdgetcode="//img[@alt='Get Widget Code']";
	private final String xpath_feedback="//img[@title='Feedback']";
	private final String xpath_investorspowered="//img[@src='http://impetus-d270/Finalaya/images/finalaya_small.gif']";
	private final String xpath_bsemarketindices="//a[contains(.,'BSE Market Indices')]";
	private final String classname_DashboardTitle="DashboardTitle";
	private final String xpath_market="//a[contains(.,' Market')]";
	private final String xpath_markettext="/html/body/form/div[5]/div/div[10]/div[2]/div[1]/div[1]/p[1]/span[2]";
	
	
	@FindBy(how = How.LINK_TEXT, using = linkTest_widgetGallery_tab)
	private WebElement widget_gallery;

	@FindBy(how = How.LINK_TEXT, using = linkTest_company_snapshot_link)
	private WebElement company_snapshot;
	
	@FindBy(how = How.XPATH, using = xpath_investorspowered)
	private WebElement we_investorspowered;
	
	@FindBy(how = How.XPATH, using = xpath_feedback)
	private WebElement we_feedback;
	
	@FindBy(how = How.XPATH, using = xpath_refresh)
	private WebElement we_refresh;
	
	@FindBy(how = How.XPATH, using = xpath_widget_lbl)
	private WebElement widgetlabel;

	@FindBy(how = How.XPATH, using = xpath_BSE_lbl)
	private WebElement label_BSE;

	@FindBy(how = How.XPATH, using = company)
	private WebElement company_title;
	// This is a constructor, as every page need a base driver to find web elements
	
	@FindBy(how = How.XPATH, using = bseTopGainersLosers)
	private WebElement bsetopgainerslosers;
	
	@FindBy(how = How.XPATH, using = xpath_BSE_MarketTicker)
	private WebElement bsemarketticker;
	
	@FindBy(how = How.XPATH, using = xpath_NiftyTicker)
	private WebElement niftyTicker;
	
	@FindBy(how = How.XPATH, using =xpath_MarketBreadth)
	private WebElement MarketBreadth;
	
	@FindBy(how=How.ID, using = id_latestImpression)
	private WebElement latestImpression;
	
	@FindBy(how=How.ID,using = id_justDownloaded)
	private WebElement justDownloaded;
	
	@FindBy(how=How.ID, using = id_mostDownloaded)
	private WebElement mostDownloaded;
	
	@FindBy(how = How.XPATH, using = xpath_refresh)
	private WebElement refreshIcon;
	
	@FindBy(how = How.XPATH, using = xpath_feedback)
	private WebElement feedbackIcon;
	
	@FindBy(how = How.XPATH, using = xpath_investorspowered)
	private WebElement investorsIcon;
	
	@FindBy(how = How.XPATH, using = xpath_bsemarketindices)
	private WebElement bseindiceswidgetlink;
	
	@FindBy(how = How.CLASS_NAME, using = classname_DashboardTitle)
	private WebElement dashboardTitle;
	
	@FindBy(how = How.XPATH, using = xpath_market)
	private WebElement MarketlinkunderBySection;
	
	
	@FindBy(how = How.XPATH, using = xpath_markettext)
	private WebElement MarketText;
	
	public void WidgetPage(WebDriver driver) {
		this.driver = driver;
	}

	// static CommonUtility commonUtility;
	public void clickOnWidgetTab() {
		FunctionLibrary.clickWebLink(widget_gallery);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// Verify that user should be navigated to IPO page - verify IPO page level
	public void clickoncompanysnapshot() {
		FunctionLibrary.clickWebLink(company_snapshot);
	}

	public void clickonbsetoplosergainer() {
		FunctionLibrary.clickWebLink(bsetopgainerslosers);
	}

	
  public void verifycompanysnapshot() {
	  FunctionLibrary.verifyTextWebelement("Company Snapshot", widgetlabel);
	  FunctionLibrary.verifyTextWebelement("BSE", label_BSE);
      company_title.isDisplayed();
  }
  
  public void verifylinkspresent(){
	  FunctionLibrary.verifyTextWebelement("Company Snapshot", widgetlabel);
	  FunctionLibrary.verifyTextWebelement("BSE Market Ticker", bsemarketticker);
	  FunctionLibrary.verifyTextWebelement("Nifty Ticker", niftyTicker);
	  FunctionLibrary.verifyTextWebelement("BSE Top Gainers & Losers", bsetopgainerslosers);
	  FunctionLibrary.verifyTextWebelement("Market Breadth", MarketBreadth);	
	  FunctionLibrary.verifyTextWebelement("Latest Impressions", latestImpression);
	  FunctionLibrary.verifyTextWebelement("Just Downloaded", justDownloaded);
	  FunctionLibrary.verifyTextWebelement("Most Downloaded", mostDownloaded);
  }

  public  void verifymarketBreadthlink(){
	  FunctionLibrary.clickWebLink(MarketBreadth);
	  FunctionLibrary.verifyTextWebelement("Market Breadth", widgetlabel);
	  String refresh =FunctionLibrary.getTooltipValue(we_refresh);
	  FunctionLibrary.verifyStringsAreSame("Refresh",refresh);
	  String feedback=FunctionLibrary.getTooltipValue(we_feedback);
	  FunctionLibrary.verifyStringsAreSame("Feedback", feedback);
	  String investorspowered=FunctionLibrary.getTooltipValue(we_investorspowered);
	  FunctionLibrary.verifyStringsAreSame("Finalaya: Investors Empowered - Online Investor Disclosure & Communication",investorspowered );
  }

  public  void verifymarketIndicelink(){
	  FunctionLibrary.clickWebLink(bseindiceswidgetlink);
	  FunctionLibrary.verifyTextWebelement("Finalaya Widgets - BSE Market Indices", dashboardTitle);
  }
 
  public  void verifysectionby(){
	  FunctionLibrary.clickWebLink(MarketlinkunderBySection);
	  FunctionLibrary.verifyTextWebelement("Market", MarketText);
  }
}
