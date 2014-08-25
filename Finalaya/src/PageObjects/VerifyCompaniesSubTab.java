package PageObjects;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;



public class VerifyCompaniesSubTab {

	
	private WebDriver driver;
	private final String csspath_MainLink = "#menu-wrapper > ul > li:nth-child(2) > a";
	private final String csspath_MicrositeSublink="#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(1) > a";
	private final String csspath_ResultsSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(2) > a";
	private final String csspath_AnnoucementsSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(3) > a";
	private final String csspath_CompareCompnaiesSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(4) > a";
	private final String csspath_IndustriesSubTab= "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(5) > a";
	private final String csspath_DocumentSubTab = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(6) > a";
	private final String csspath_Microsite = "#ctl00_BodyCPH_divCompany > h1 > span";
	private final String csspath_Resultspage = "#ctl00_BodyCPH_divCompany > h1";
	private final String csspath_Annoucement = "#mainOuter > div > div > div > div.DashboardTitle > h1";
	private final String Xpath_CompareCompaniesPage = "//*[@id='aspnetForm']/div[5]/div/div[10]/div/h1/span";
    private final String csspath_Industriespage= "#divHeader > span > div > h1 > span";
    private final String csspath_CompanyDocument ="#ctl00_BodyCPH_divDocument > h1 > span";


    


 // This is a constructor, as every page gets intantiated 
     public VerifyCompaniesSubTab(WebDriver driver) {
		this.driver=driver;
	}

	
    @FindBy( css = csspath_MainLink)
    private WebElement we_csspath_MainLink;

    @FindBy(css = csspath_MicrositeSublink)
    private WebElement we_csspath_MicrositeSublink;
    
    @FindBy(css = csspath_ResultsSubLink)
    private WebElement we_csspath_ResultsSubLink;
    
    
    
    @FindBy(css = csspath_AnnoucementsSubLink)
    private WebElement we_csspath_AnnoucementsSubLink;
    
    
    @FindBy( css = csspath_CompareCompnaiesSubLink)
    private WebElement we_csspath_CompareCompnaiesSubLink;

    @FindBy(css = csspath_IndustriesSubTab)
    private WebElement we_csspath_IndustriesSubTab;
    
    
    @FindBy(css = csspath_DocumentSubTab)
    private WebElement we_csspath_DocumentSubTab;
    @FindBy(css = csspath_Microsite)
    private WebElement we_csspath_Microsite;
    
    
    @FindBy(css = csspath_Resultspage)
    private WebElement we_csspath_Resultspage;
    
    @FindBy(css = csspath_Annoucement)
    private WebElement we_csspath_Annoucement;
    
    
    @FindBy(xpath = Xpath_CompareCompaniesPage)
    private WebElement we_xpath_CompareCompaniesPage;
    
    
    @FindBy(css = csspath_Industriespage)
    private WebElement we_csspath_Industriespage;
    
    @FindBy(css = csspath_CompanyDocument)
    private WebElement we_csspath_CompanyDocumentPage;
    
    
    

/* Method Name: 
       * Description: Verify SubTab Microsite Page is Displayed
        *            This method will return Microsite Page is Displayed or not.
        * 
       * Created By: Mohd Suhail
       * Created Date: 19-08-2014
       * */

    public Boolean  VerifyMicrositePageIsdisplayed() {
        
    	
    	boolean result= false;
    	 try {
    	  
              LoggerInstance.logger.info("Going to  Sub Tab");
              FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_MicrositeSublink);
              driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
             
             
            
  			
  			 result=we_csspath_Microsite.isDisplayed();
  			 if (result==true)
  			 LoggerInstance.logger.info("Microsite Page is displayed");
  			 return result;
  				}
  			catch (Exception e) 
  				{
  				LoggerInstance.logger.info("Microsite Page is not displayed");
  				return result;
  				}
  		}



    /* Method Name: 
     * Description: Verify SubTab Results Page is Displayed
      *            This method will return Results Page is Displayed or not.
      * 
     * Created By: Mohd Suhail
     * Created Date: 19-08-2014
     * */

public Boolean  verifyResultsPageIsdisplayed() {
        
    	
    	boolean result= false;
    	 try {
    	  
              LoggerInstance.logger.info("Going to  Sub Tab");
              FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_ResultsSubLink);
              driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
             
             
            
  			
  			 result=we_csspath_Resultspage.isDisplayed();
  			 if (result==true)
  			 LoggerInstance.logger.info("Results Page is displayed");
  			 return result;
  				}
  			catch (Exception e) 
  				{
  				LoggerInstance.logger.info("Results Page is not displayed");
  				return result;
  				}
  		}
    


/* Method Name: 
 * Description: Verify SubTab AnnoucementPage is Displayed
  *            This method will return AnnoucementPage is Displayed or not.
  * 
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */


public Boolean  VerifyAnnoucementPageIsdisplayed() {
    
	
	boolean result= false;
	 try {
	  
          LoggerInstance.logger.info("Going to  Sub Tab");
          FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_AnnoucementsSubLink);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         
         
        
			
			 result=we_csspath_Annoucement.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Annoucement Page is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Annoucement Page is not displayed");
				return result;
				}
		}




/* Method Name: 
 * Description: Verify SubTab CompareCompaniesPage is Displayed
  *            This method will return CompareCompaniesPage is Displayed or not.
  * 
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */

public Boolean  VerifyCompareCompaniesPageIsdisplayed() {
    
	
	boolean result= false;
	 try {
	  
          LoggerInstance.logger.info("Going to  Sub Tab");
          FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_CompareCompnaiesSubLink);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         
         
        
			
			 result=we_xpath_CompareCompaniesPage.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Compare Companies Page is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Compare Companies Page is not displayed");
				return result;
				}
		}


/* Method Name: 
 * Description: Verify SubTab IndustriesPage is Displayed
  *            This method will return IndustriesPage is Displayed or not.
  * 
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */

public Boolean  verifyIndustriesPageIsdisplayed() {
    
	
	boolean result= false;
	 try {
	  
          LoggerInstance.logger.info("Going to  Sub Tab");
          FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_IndustriesSubTab);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         
         
        
			
			 result=we_csspath_Industriespage.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Industries Page is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Industries Page is not displayed");
				return result;
				}
		}

    
/* Method Name: 
 * Description: Verify SubTab DocumentPage is Displayed
  *            This method will return DocumentPage is Displayed or not.
  * 
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */
public Boolean  VerifyDocumentPageIsdisplayed() {
    
	
	boolean result= false;
	 try {
	  
          LoggerInstance.logger.info("Going to  Sub Tab");
          FunctionLibrary.clickMenuItem(we_csspath_MainLink, we_csspath_DocumentSubTab);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         
         
        
			
			 result=we_csspath_CompanyDocumentPage.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Document Page is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Document Page is not displayed");
				return result;
				}
		}

    
}