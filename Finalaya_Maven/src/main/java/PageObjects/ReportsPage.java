package PageObjects;

/* Description: Reports page object class
 * Created By: Sunny Jain
 * Created Date: 25 Aug 2014
 * */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class ReportsPage {

	WebDriver driver;
	private final String csspath_ReportsTab = "#menu-wrapper > ul > li:nth-child(8) > a";
	private final String csspath_ResearchReportsMenu = "#menu-wrapper > ul > li:nth-child(8) > div > div.nav-column > ul > li:nth-child(4) > a";
	private final String csspath_Title = "span#ctl00_ucHeader_UCBreadcrumb_lblBreadcrumb";
	private final String csspath_AllReports = "li#ctl00_BodyCPH_ResearchMenu_liAll>a";
	private final String csspath_Premium = "ul.research_rpt_mnu>li:nth-child(2)>a";
	private final String csspath_Latest = "a#ctl00_BodyCPH_lnkLatestRpt";
	private final String csspath_MostViewed = "a#ctl00_BodyCPH_lnkMostViewedRpt";
	private final String csspath_FirstReportLink = "table.bordered>tbody>tr:nth-child(1)>td>div>h2>span>a";
	private final String csspath_NewWindowTitle = "span#ctl00_Heading";
	
	private final String css_MainReportTab = "#menu-wrapper > ul > li:nth-child(8) > a";
	private final String css_DailyWrapMenuTab = "#menu-wrapper > ul > li:nth-child(8) > div > div.nav-column > ul > li:nth-child(1) > a";
	private final String css_DailyWrapPage = "#ctl00_ucHeader_UCBreadcrumb_lblBreadcrumb";
	private final String css_CnxNiftytable = "#headingarea > table:nth-child(28) > tbody:nth-child(1) > tr:nth-child(1) > th > div";
	private final String css_BSeSensextable = "#headingarea > table:nth-child(30) > tbody:nth-child(1) > tr:nth-child(1) > th > div";
	private final String xpath_CNXEffectivedate = "//table[1][@class='bordered']/tbody[2]/tr/td[1]";
	private final String xpath_BSeSensexffectivedate = "//table[2][@class='bordered']/tbody[2]/tr/td[1]";
	private final String xpath_ViewArchiveBtn = "//*[@id='headingarea']/p[22]/a";
	private final String xpath_heading = "//table[@class='BlueBGtable']/tbody/tr";
	private final String css_datelink = "#lnkArticle";
	private final String css_PagedatelinkHeading = "#ctl00_BodyCPH_lblHeading";
	private final String css_PagedateTime = "#ctl00_BodyCPH_lblDateTime";
	private final String xpath_DailyScrapdatelink = "//table[@class='BlueBGtable']/tbody/tr[2]";
	private final String css_closeimg="#divRecentReports > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > a > img";
	
	
	@FindBy(css = csspath_ReportsTab)
	public WebElement we_csspath_ReportsTab;
	@FindBy(css = csspath_ResearchReportsMenu)
	public WebElement we_csspath_ResearchReportsMenu;
	@FindBy(css = csspath_Title)
	public WebElement we_csspath_Title;
	@FindBy(css = csspath_AllReports)
	public WebElement we_csspath_AllReports;
	@FindBy(css = csspath_Premium)
	public WebElement we_csspath_Premium;
	@FindBy(css = csspath_Latest)
	public WebElement we_csspath_Latest;
	@FindBy(css = csspath_MostViewed)
	public WebElement we_csspath_MostViewed;
	@FindBy(css = csspath_FirstReportLink)
	public WebElement we_csspath_FirstReportLink;
	@FindBy(css = csspath_NewWindowTitle)
	public WebElement we_csspath_NewWindowTitle;
	
	@FindBy(css = css_MainReportTab)
	public WebElement we_MainReportTab;
	@FindBy(css = css_DailyWrapMenuTab)
	public WebElement we_DailyWrapMenuTab;
	@FindBy(css = css_DailyWrapPage)
	public WebElement we_DailyWrapPage;
	@FindBy(css = css_CnxNiftytable)
	public WebElement we_CnxNiftytable;
	@FindBy(css = css_BSeSensextable)
	public WebElement we_BSeSensextable;
	@FindBy(xpath = xpath_CNXEffectivedate)
	public List<WebElement> we_CNXEffectivedate;
	@FindBy(xpath = xpath_BSeSensexffectivedate)
	public List<WebElement> we_BSeSensexffectivedate;
	@FindBy(xpath = xpath_ViewArchiveBtn)
	public WebElement we_ViewArchiveBtn;
	@FindBy(xpath = xpath_heading)
	public List<WebElement> we_HeadingWrapTable;
    @FindBy(css = css_datelink)
	public WebElement we_datelink;
	@FindBy(css = css_PagedatelinkHeading)
	public WebElement we_PagedatelinkHeading;
	@FindBy(css = css_closeimg)
	public WebElement we_Closeimage;
	@FindBy(css = css_PagedateTime)
	public WebElement we_PagedateTime;
	@FindBy(xpath = xpath_DailyScrapdatelink)
	public List<WebElement> we_DailyScrapdatelink;
	

	public ReportsPage(WebDriver driver){
		this.driver=driver;
	}

         /* Method Name: clickOnResearchReportstab
       * Description: 
       *            This method will click on the sub menu of tab.
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public void clickOnResearchReportstab() {
		try {
			LoggerInstance.logger.info("click on Research Reports Tab");
			FunctionLibrary.clickMenuItem(driver, we_csspath_ReportsTab,we_csspath_ResearchReportsMenu);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on NSE Tab");
		}
	}

   /* Method Name: verifyAllReportsTabIsDisplayed
       * Description: 
       *            This method will verify that All reports tab is displyed or not 
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public boolean verifyAllReportsTabIsDisplayed() {
		boolean result = false;
		try {
			result = we_csspath_AllReports.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("All Reports tab is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("All Reports tab is not displayed");
			return result;
		}
	}
       
 /* Method Name: verifyPremiumTabIsDisplayed
       * Description: 
       *            This method will verify that Premium tab is displyed or not 
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */

	public boolean verifyPremiumTabIsDisplayed() {
		boolean result = false;
		try {
			result = we_csspath_Premium.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("Premium tab is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Premium tab is not displayed");
			return result;
		}
	}
  /* Method Name: verifyLatestTabIsDisplayed
       * Description: 
       *            This method will verify that latest tab is displyed or not 
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public boolean verifyLatestTabIsDisplayed() {
		boolean result = false;
		try {
			result = we_csspath_Latest.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("Latest tab is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Latest tab is not displayed");
			return result;
		}
	}
 /* Method Name: verifyMostViewedTabIsDisplayed
       * Description: 
       *            This method will verify that Most viewed tab is displyed or not 
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public boolean verifyMostViewedTabIsDisplayed() {
		boolean result = false;
		try {
			result = we_csspath_MostViewed.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("Most viewed tab is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Most viewed tab is not displayed");
			return result;
		}
	}
 /* Method Name: verifyTitle
       * Description: 
       *            This method will verify the title 
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public boolean verifyTitle() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("verify the tilte");
			result = FunctionLibrary.verifyTextWebelement("Home � Research Reports",
					we_csspath_Title);
			if (result == true){
				LoggerInstance.logger.info("title is verified");
			return result;
			}
			else{
				LoggerInstance.logger.info("title is not same");
				return result;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("unable to verify title");
			return result;
		}
	}	
	 /* Method Name: clickOnReportLink
       * Description: 
       *            This method will click on the report link.
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public void clickOnReportLink() {
		
		try{
			LoggerInstance.logger.info("click on the first report link");
			FunctionLibrary.clickWebLink(we_csspath_FirstReportLink);
		}
		catch (Exception e) {
			LoggerInstance.logger.info("link is not clicked");	
		}
	}
	 /* Method Name: switchOfNewWindow
       * Description: 
       *            This method will switch on the newly opened window.
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public void switchOfNewWindow(){
		
		try{
			LoggerInstance.logger.info("Swtching to new opened window");
	        String parent = driver.getWindowHandle();
	         Thread.sleep(1000);
	         Set <String> availableWindows = driver.getWindowHandles();
	         String newWindow = null;
	         for (String window : availableWindows) {
	             if (!parent.equals(window)) {
	                 newWindow = window;
	             }  
	         }
	         driver.switchTo().window(newWindow);    
	         
		}
		catch (Exception e) {
			LoggerInstance.logger.info("Switch to new window fail");	
		}	
	}
	 /* Method Name: verifyNewWindowTitle
       * Description: 
       *            This method will the title of the newly opened window.
       * Parameters: 
       *            1. NA
       * Created By: Sunny Jain
       * Created Date: 25-08-2014
       * */
	public boolean verifyNewWindowTitle() {
		  boolean result = false;

		try {
			LoggerInstance.logger.info("verify the tilte of newly opened window");
			result = FunctionLibrary.verifyTextWebelement("Research Reports",we_csspath_NewWindowTitle);
		if (result == true){
			LoggerInstance.logger.info("title is verified");
			return result;
			}
		else{
			LoggerInstance.logger.info("title is not same");
			return result;
			}	
		} catch (Exception e) {
			LoggerInstance.logger.info("title is not matched");
			return result;
		}
	}
	
	
	/*
	 * Method Name: Description: Verify DailyMarketWrap Page is Displayed This
	 * method will return DailyMarketWrap Page is Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public Boolean VerifyDailyMarketWrapPageIsdisplayed() {

		boolean result = false;
		try {

			FunctionLibrary.clickMenuItem(driver, we_MainReportTab,
					we_DailyWrapMenuTab);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			result = we_DailyWrapPage.isDisplayed();
			if (result == true)
				LoggerInstance.logger
						.info("Daily Market Wrap Page is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Daily Market Wrap is not displayed");
			return result;
		}
	}

	/*
	 * Method Name: Description: Verify CNXTable Page is Displayed This method
	 * will returnCNXTable Page is Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */
	public Boolean VerifyCNXTableIsdisplayed() {

		boolean result = false;
		try {

			FunctionLibrary.clickMenuItem(driver, we_MainReportTab,
					we_DailyWrapMenuTab);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			result = we_CnxNiftytable.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("CNX Nifty Table is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("CNX Nifty Table  is displayed");
			return result;
		}
	}

	/*
	 * Method Name: Description: Verify S&P BSESensexTable Page is Displayed
	 * This method will return S&P BSESensexTable Page is Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */
	public Boolean VerifyBSESensexTableIsdisplayed() {

		boolean result = false;
		try {

			FunctionLibrary.clickMenuItem(driver, we_MainReportTab,
			we_DailyWrapMenuTab);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			result = we_BSeSensextable.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("S&P BSE Sensex Table is displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("S&P BSE Sensex Table is not displayed");
			return result;
		}
	}

	/*
	 * Method Name:
	 * 
	 * This method will return Date Value .
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public static String DateVal(int i) {
       
		String a = null ;
		try{
				Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.DAY_OF_MONTH, i);
		        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				Date date = cal.getTime();
				a = dateFormat.format(date);
				return a;
        }
		catch(Exception e)
		{
		  	LoggerInstance.logger.info("Does not Contain the date");
		  	return a;
		}
	     }
	

	/*
	 * Method Name: Description: Verify CNXTable contains three dates is
	 * Displayed This method will contains three dates is Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public Boolean VerifyCNXEffectiveDateDisplayed() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;

		try {

			FunctionLibrary.clickMenuItem(driver, we_MainReportTab,
					we_DailyWrapMenuTab);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> ListEffectivedate = we_CNXEffectivedate;
			for (int i = 0; i < ListEffectivedate.size(); i++) 
			{
				String ListEffectivedatetable = ListEffectivedate.get(i).getText();

				if (ListEffectivedatetable.equals(DateVal(0).toString()))
				{
					LoggerInstance.logger.info("CNX Nifty Table contains the Current date .");
					flag1 = true;
					continue;
				}				
			
				
				else if (ListEffectivedatetable.equals(DateVal(-1).toString())) 
				{
					LoggerInstance.logger.info("CNX Nifty Table contains the Last date .");
					flag2 = true;
					continue;
				}
				else if (ListEffectivedatetable.equals(DateVal(-2).toString()))
				{
					LoggerInstance.logger.info("CNX Nifty Table contains the Day Before Date .");
					flag3 = true;
					continue;
				}
				
			}
			 
			if (flag1 && flag2 && flag3) {
				result = true;
				LoggerInstance.logger.info("CNX Nifty Table contains Current , lastDate and Day Before Date ");
			}
			else{
				LoggerInstance.logger.info("CNX Nifty Table does not contains Current , lastDate and Day Before Date ");
				result = true;
				
			}
				
		} catch (Exception e) {
			LoggerInstance.logger.info("Columns are not displayed");
			result = false;
		}
		return result;

	}

	/*
	 * Method Name: Description: Verify BSESensexTable contains three dates is
	 * Displayed This method will contains BSESensexTable three dates is
	 * Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public Boolean VerifyBSESensexTableDateDisplayed() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;

		try {

			FunctionLibrary.clickMenuItem(driver, we_MainReportTab,
					we_DailyWrapMenuTab);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> ListEffectivedate = we_BSeSensexffectivedate;
			for (int i = 0; i < ListEffectivedate.size(); i++)
			{
				String ListEffectivedatetable = ListEffectivedate.get(i).getText();
				if (ListEffectivedatetable.equals(DateVal(0).toString())) {
					LoggerInstance.logger.info("BSE Sensex Table  contains the current date .");
					flag1 = true;
					continue;
				} else if (ListEffectivedatetable.equals(DateVal(-1).toString())) {
					LoggerInstance.logger.info("BSE Sensex Table contains the Last date .");
					flag2 = true;
					continue;
					
				}
                    else if (ListEffectivedatetable.equals(DateVal(-2).toString())) 
                 {
					LoggerInstance.logger.info("BSE Sensex Table contains the Day Before Date .");
					flag3 = true;
					continue;
				 }
			  }
			if (flag1 && flag2 && flag3)
			{
				result = true;
				LoggerInstance.logger.info("BSE Sensex Table contains Current , lastDate and Day Before Date ");
			}
			else{
				LoggerInstance.logger.info("BSE Sensex Table does not contains Current , lastDate and Day Before Date ");
				result = true;
				
			}
		} 
		catch (Exception e) {
			LoggerInstance.logger.info("Columns are not displayed");
			result = false;
		  }
		return result;

	  }

	/*
	 * Method Name: Description: Verify CNXTable contains
	 * VerifyDailyWrapFrameContainsHeading and 10 records is displayed This
	 * method will VerifyDailyWrapFrameContainsHeading is Displayed or not.
	 * 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public boolean VerifyDailyWrapFrameContainsHeading() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
           try {
            FunctionLibrary.clickMenuItem(driver, we_MainReportTab,we_DailyWrapMenuTab);
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			FunctionLibrary.clickWebLink(we_ViewArchiveBtn);
			List<WebElement> headerelment = we_HeadingWrapTable;
			int headerval = -1;
			int sum = 0;
			for (int i = 0; i < headerelment.size(); i++) {
				String HeaderText = headerelment.get(i).getText();
				headerval = headerval + 1;
				if (HeaderText.equalsIgnoreCase("Date Heading")) {
					LoggerInstance.logger.info("Daily  Wrap Frame contains Data Heading .");
					flag1 = true;
					continue;
				} else if (headerval == 10) {
					LoggerInstance.logger.info("Daily  Wrap Frame contains 10 records .");
					flag2 = true;
					continue;
				}

			}
			FunctionLibrary.clickWebLink(we_Closeimage);
			if (flag1 && flag2) {
				result = true;
				LoggerInstance.logger.info("Daily  Wrap Frame contains Data Heading  and 10 records");
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Columns are not displayed");
			result = false;
		}
		return result;
	}


	
	/*
	 * Method Name: Description: Verify Daily  Wrap Frame Value
	 *  contains the Same Heading Value is displayed 
	 * This method will Daily  Wrap Frame Value contains the Same Heading Value
	 *   is Displayed or not.
	 
	 * Created By: Mohd Suhail Created Date: 26-08-2014
	 */

	public boolean VerifyDailyWrapDatePageHeading() {
		boolean result = false;
		boolean flag1 = false;
		

		try {
		//	FunctionLibrary.clickMenuItem(driver, we_MainReportTab,we_DailyWrapMenuTab);
		//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			FunctionLibrary.clickWebLink(we_ViewArchiveBtn);
			List<WebElement> headerelment = we_DailyScrapdatelink;
			for (int i = 0; i < headerelment.size(); i++) {
				String HeaderText = headerelment.get(i).getText();
				FunctionLibrary.clickWebLink(we_datelink);
				if (HeaderText.contains(we_PagedatelinkHeading.getText())) {
					LoggerInstance.logger.info("Daily  Wrap Frame  contains the Same Heading Value and  date as new Loaded page");
					flag1 = true;
					continue;
				}
			}
			
            if (flag1) {
				result = true;
				LoggerInstance.logger.info("Daily  Wrap Frame  contains the Same Heading Value and  date as new Loaded page");
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Columns are not displayed");
			result = false;
		}
		return result;
	}
	
}
