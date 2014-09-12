package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class MutualFundsPage {

	final WebDriver driver;
	private final String xpath_MutualFundTab = ".//*[@id='menu-wrapper']/ul/li[3]/a";
	private final String xpath_FundHouses = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[1]/a";
	private final String xpath_FHHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/div[1]/div/h1/span";
	private final String xpath_Funds = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[2]/a";
	private final String xpath_FHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/div[1]/div/span";
	private final String xpath_FundScreener = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[3]/a";
	private final String xpath_FSHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/div[1]/div/h1/span";
	private final String xpath_PortChur = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[4]/a";
	private final String xpath_PCHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/div[1]/div/h1/span";
	private final String xpath_CompareFunds = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[5]/a";
	private final String xpath_CFHeader = ".//*[@id='NoLftRht']/h1/span";
	private final String xpath_MonthlySCard = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[6]/a";
	private final String xpath_MSCHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[1]/td/div/span";
	private final String xpath_NewFOffers = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[7]/a";
	private final String xpath_NFOHeader = ".//*[@id='aspnetForm']/div[5]/div/div[10]/div[1]/div/span/h1";
	private final String xpath_Corpus = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/span";
	private final String xpath_CorpusGainers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[1]/span";
	private final String xpath_CorpusLosers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[3]/span";
	private final String xpath_NAVGainers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[10]/td[1]/span";
	private final String xpath_NAVLosers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[10]/td[3]/span";
	private final String xpath_valueCorpusGainerFirstRow = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[1]/table/tbody/tr[1]/td[2]/span";
	private final String xpath_valueCorpusLosersFirstRow = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[3]/table/tbody/tr[1]/td[2]/span";
	private final String xpath_MutualFundCF = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[5]/a";
	private final String id_actualValueOnCompPage = "ctl00_BodyCPH_ucLftPanel_lblAvgAUM";
	private final String id_CorpusGainers_FirstRow = "ctl00_BodyCPH_rptAUMGainers_ctl01_lnkAMC";
	private final String id_CorpusLosers_FirstRow = "ctl00_BodyCPH_rptAUMLosers_ctl01_lnkAMC";
	private final String id_ActualTextMF = "dMF";
	private final String id_ActualTextCF = "dCmpF";
	private final String id_GraphChkBox = "ctl00_BodyCPH_cboxGraph";
	private final String id_EquityChkBox = "ctl00_BodyCPH_rbEquity";
	private final String id_DropdownOne = "ctl00_BodyCPH_comp1";
	private final String id_DropdownTwo = "ctl00_BodyCPH_comp2";
	private final String id_DdiOne = "ctl00_BodyCPH_ddlIndices1";
	private final String id_DdiTwo = "ctl00_BodyCPH_ddlIndices2";
	private final String id_CompareBtn = "ctl00_BodyCPH_btnGenerateGraph";
	private final String css_ImageGraph = "html.js.flexbox.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.no-csstransforms3d.csstransitions.fontface.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body form#aspnetForm div div div div#NoLftRht div#ctl00_BodyCPH_dvChart div div#divViewChart div div#ctl00_BodyCPH_ucCompareChart_divChart div#chartDiv_CompEx div div div div svg g path.amChartsPlotArea";
	private final String expectedCorpusColor = "#006699";
	private final String expectedCorpusGainersColor = "#108900";
	private final String expectedCorpusLosersColor = "#FC2A00";
	private final String expectedNAVGainersColor = "#108900";
	private final String expectedNAVLosersColor = "#FC2A00";
	private final String expectedTextMF = "Overview of Mutual Funds, Latest NAVs, Best/Worst performing schemes, Corp Actions, AUM-wise Top Schemes/AMCs, Company/ Industry exposure to MF, NFO updates";
	private final String expectedTextCF = "Allows to compare funds with other funds/indices in a graphical layout. This feature also compares fundamentals and NAVs upto five funds in one go.";
	private String valueCorpusGainersOnMSCPage;
	private String valueCorpusLosersOnMSCPage;
	
	@FindBy(xpath = xpath_MutualFundTab)
	private WebElement we_MutualFundsTab;
	@FindBy(id = id_ActualTextMF)
	private WebElement we_ActualTextMF;
	@FindBy(xpath = xpath_FundHouses)
	private WebElement we_FundHouses;
	@FindBy(xpath = xpath_Funds)
	private WebElement we_Funds;
	@FindBy(xpath = xpath_FundScreener)
	private WebElement we_FundScreener;
	@FindBy(xpath = xpath_PortChur)
	private WebElement we_PortChur;
	@FindBy(xpath = xpath_CompareFunds)
	private WebElement we_CompareFunds;
	@FindBy(xpath = xpath_NewFOffers)
	private WebElement we_NewFOffers;
	@FindBy(xpath = xpath_FHHeader)
	private WebElement we_FHHeader;
	@FindBy(xpath = xpath_FHeader)
	private WebElement we_FHeader;
	@FindBy(xpath = xpath_FSHeader)
	private WebElement we_FSHeader;
	@FindBy(xpath = xpath_PCHeader)
	private WebElement we_PCHeader;
	@FindBy(xpath = xpath_CFHeader)
	private WebElement we_CFHeader;
	@FindBy(xpath = xpath_MSCHeader)
	private WebElement we_MSCHeader;
	@FindBy(xpath = xpath_NFOHeader)
	private WebElement we_NFOHeader;
	@FindBy(xpath = xpath_MonthlySCard)
	private WebElement we_MonthlySCard;
	@FindBy(xpath = xpath_Corpus)
	private WebElement we_Corpus;
	@FindBy(xpath = xpath_CorpusGainers)
	private WebElement we_CorpusGainers;
	@FindBy(xpath = xpath_CorpusLosers)
	private WebElement we_CorpusLosers;
	@FindBy(xpath = xpath_NAVGainers)
	private WebElement we_NAVGainers;
	@FindBy(xpath = xpath_NAVLosers)
	private WebElement we_NAVLosers;
	@FindBy(xpath = xpath_valueCorpusGainerFirstRow)
	private WebElement we_valueCorpusGainerFirstRow;
	@FindBy(xpath = xpath_valueCorpusLosersFirstRow)
	private WebElement we_valueCorpusLosersFirstRow;
	@FindBy(id = id_actualValueOnCompPage)
	private WebElement we_actualValueOnCompPage;
	@FindBy(id = id_CorpusGainers_FirstRow)
	private WebElement we_CorpusGainers_FirstRow;
	@FindBy(id = id_CorpusLosers_FirstRow)
	private WebElement we_CorpusLosers_FirstRow;
	@FindBy(xpath = xpath_MutualFundCF)
	private WebElement we_MutualFundCF;
	@FindBy(id = id_ActualTextCF)
	private WebElement we_ActualTextCF;
	@FindBy(id = id_GraphChkBox)
	private WebElement we_GraphChkBox;
	@FindBy(id = id_EquityChkBox)
	private WebElement we_EquityChkBox;
	@FindBy(id = id_DropdownOne)
	private WebElement we_DropdownOne;
	@FindBy(id = id_DropdownTwo)
	private WebElement we_DropdownTwo;
	@FindBy(id = id_DdiOne)
	private WebElement we_DdiOne;
	@FindBy(id = id_DdiTwo)
	private WebElement we_DdiTwo;
	@FindBy(id = id_CompareBtn)
	private WebElement we_CompareBtn;
	@FindBy(css = css_ImageGraph)
	private WebElement we_ImageGraph;
	
	// This is a constructor, as every page need a base driver to find web elements
	public MutualFundsPage(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * Method Name: hoverMouse 
	 * Description: Function to hover mouse over Mutual Funds tab
	 * Parameters:
	 * Created By: Darwin
     * Created Date: 21-08-2014
	 */
	public void hoverMouse() {
		try {
			LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
			FunctionLibrary.waitTillElementVisible(5, By.xpath(xpath_MutualFundTab));
			Actions action = new Actions(driver);
			action.moveToElement(we_MutualFundsTab).build().perform();
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to hover mouse over Mutual Funds tab");
		}
	}
	/*
	 * Method Name: verifyTextMF 
	 * Description: Verify that On right of subtabs,text is displayed
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public boolean verifyTextMF() {
		boolean result = false;
		try{
			LoggerInstance.logger.info("Verify that On right of subtabs, text is displayed");
			result = FunctionLibrary.verifyTextWebelement(expectedTextMF, we_ActualTextMF);
		}
		catch(Exception e){
			LoggerInstance.logger.info("unable to Verify that On right of subtabs, text is displayed");
		}
		return result;
	}
	/*
	 * Method Name: clickOnFundHouses 
	 * Description: click On FundHouses item 
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnFundHouses(){
		try
		{	
			LoggerInstance.logger.info("click on Fund Houses");
			FunctionLibrary.clickWebLink(we_FundHouses);
		} catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Fund Houses");
		}
	}
	/*
	 * Method Name: clickOnFunds 
	 * Description: click On Funds item 
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnFunds(){
		try
		{	
			LoggerInstance.logger.info("click on Funds");
			FunctionLibrary.clickWebLink(we_Funds);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Funds");
		}
	}
	/*
	 * Method Name: clickOnFundScreener 
	 * Description: click On FundScreener item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnFundScreener(){
		try
		{	
			LoggerInstance.logger.info("click on Fund Screener");
			FunctionLibrary.clickWebLink(we_FundScreener);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Fund Screener");
		}
	}
	/*
	 * Method Name: clickOnPortChur 
	 * Description: click On Portfolio Churning item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnPortChur(){
		try
		{	
			LoggerInstance.logger.info("click on Portfolio Churning");
			FunctionLibrary.clickWebLink(we_PortChur);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Portfolio Churning");
		}
	}
	/*
	 * Method Name: clickOnCompareFunds 
	 * Description: click On CompareFunds item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnCompareFunds(){
		try
		{	
			LoggerInstance.logger.info("click on Compare Funds");
			FunctionLibrary.clickWebLink(we_CompareFunds);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Compare Funds");
		}
	}
	/*
	 * Method Name: clickOnMonthlySCard 
	 * Description: click On Monthly Score Card item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 21-08-2014
	 */
	public void clickOnMonthlySCard(){
		try
		{	
			LoggerInstance.logger.info("click on Monthly Score Card");
			FunctionLibrary.clickWebLink(we_MonthlySCard);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Monthly Score Card");
		}
	}
	/*
	 * Method Name: clickOnNewFOffers 
	 * Description: click On New Fund Offers item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 22-08-2014
	 */
	public void clickOnNewFOffers(){
		try
		{	
			LoggerInstance.logger.info("click on New Fund Offers");
			FunctionLibrary.clickWebLink(we_NewFOffers);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on New Fund Offers");
		}
	}
	/*
	 * Method Name: verifyFundHousesNavigation 
	 * Description: verify FundHouses page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 22-08-2014
	 */
	public boolean verifyFundHousesNavigation(){
		boolean result= false;
		try{
		 result=we_FHHeader.isDisplayed();
		 if (result==true)
			 LoggerInstance.logger.info("User is navigated to Fund Houses Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Fund Houses Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyFundsNavigation 
	 * Description: verify Funds page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 22-08-2014
	 */
	public boolean verifyFundsNavigation(){
		boolean result= false;
		try{
		 result=we_FHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to Funds Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Funds Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyFundScreenerNavigation 
	 * Description: verify FundScreener page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 22-08-2014
	 */
	public boolean verifyFundScreenerNavigation(){
		boolean result= false;
		try{
		 result=we_FSHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to Fund Screener Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Fund Screener Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyPortChurNavigation 
	 * Description: verify Portfolio Churning page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 22-08-2014
	 */
	public boolean verifyPortChurNavigation(){
		boolean result= false;
		try{
		 result=we_PCHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to Portfolio Churning Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Portfolio Churning Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyCompFundsNavigation 
	 * Description: verify Compare Funds page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyCompFundsNavigation(){
		boolean result= false;
		try{
		 result=we_CFHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to Compare Funds Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Compare Funds Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyMSCNavigation 
	 * Description: verify Monthly Score Card page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */	
	public boolean verifyMSCNavigation(){
		boolean result= false;
		try{
		 result=we_MSCHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to Monthly Score Card Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to Monthly Score Card Page");
			return result;
			}
	}
	/*
	 * Method Name: verifyNFONavigation 
	 * Description: verify New Fund Offers page is opened
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */	
	public boolean verifyNFONavigation(){
		boolean result= false;
		try{
		 result=we_NFOHeader.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("User is navigated to New Fund Offers Page");
		 return result;
			}
		catch (Exception e) 
			{
			LoggerInstance.logger.info("User is not navigated to New Fund Offers Page");
			return result;
			}
	}
	
	

	/*
	 * Method Name: verifyCorpusColour 
	 * Description: Verify Top 5 Fund Houses in terms of Corpus (displayed in BLUE)
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyCorpusColour() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying color of Top 5 Fund Houses in terms of Corpus displayed in BLUE");
			result=FunctionLibrary.verifyElementColor(we_Corpus,expectedCorpusColor);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to verify color of Top 5 Fund Houses in terms of Corpus displayed in BLUE");
		}
		return result;
	}
	/*
	 * Method Name: verifyCorpusGainersColour 
	 * Description: Verify Top 5 Fund Houses Gainers on Corpus basis(displayed in GREEN)
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyCorpusGainersColour() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying color of Top 5 Fund Houses Gainers on Corpus basis displayed in GREEN");
			result=FunctionLibrary.verifyElementColor(we_CorpusGainers,expectedCorpusGainersColor);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to verify color of Top 5 Fund Houses Gainers on Corpus basis displayed in GREEN");
		}
		return result;
	}
	/*
	 * Method Name: verifyCorpusLosersColour 
	 * Description: Verify Top 5 Fund Houses Losers on Corpus basis(displayed in RED)
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyCorpusLosersColour() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying color of Top 5 Fund Houses Losers on Corpus basis displayed in RED");
			result=FunctionLibrary.verifyElementColor(we_CorpusLosers,expectedCorpusLosersColor);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to verify color of Top 5 Fund Houses Losers on Corpus basis displayed in RED");
		}
		return result;
	}
	/*
	 * Method Name: verifyNAVGainersColour 
	 * Description: Verify Top 5 NAV (%) Gainers (displayed in GREEN)
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyNAVGainersColour() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying color of Top 5 NAV (%) Gainers displayed in GREEN");
			result=FunctionLibrary.verifyElementColor(we_NAVGainers,expectedNAVGainersColor);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to verify color of Top 5 NAV (%) Gainers displayed in GREEN");
		}
		return result;
	}
	/*
	 * Method Name: verifyNAVLosersColour 
	 * Description: Verify Top 5 NAV (%) Losers tables (displayed in RED)
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyNAVLosersColour() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying color of Top 5 NAV (%) Losers tables displayed in RED");
			result=FunctionLibrary.verifyElementColor(we_NAVLosers,expectedNAVLosersColor);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to verify color of Top 5 NAV (%) Losers tables displayed in RED");
		}
		return result;
	}
	/*
	 * Method Name: verifyValueCorpusGainers 
	 * Description: Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Gainers on Corpus basis
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyValueCorpusGainers() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying value of Corpus Gainers");
		valueCorpusGainersOnMSCPage = we_valueCorpusGainerFirstRow.getText();
		FunctionLibrary.clickWebLink(we_CorpusGainers_FirstRow);
		result=FunctionLibrary.verifyTextWebelement(valueCorpusGainersOnMSCPage, we_actualValueOnCompPage);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to Verify value of Corpus Gainers");
		}
		return result;
	}
	/*
	 * Method Name: verifyValueCorpusLosers 
	 * Description: Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Losers on Corpus basis
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyValueCorpusLosers() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying value of Corpus Losers");
		valueCorpusLosersOnMSCPage = we_valueCorpusLosersFirstRow.getText();
		FunctionLibrary.clickWebLink(we_CorpusLosers_FirstRow);
		result=FunctionLibrary.verifyTextWebelement(valueCorpusLosersOnMSCPage, we_actualValueOnCompPage);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to Verify value of Corpus Losers");
		}
		return result;
	}


	/*
	 * Method Name: hoverMouseCF 
	 * Description: Function to hover mouse Compare Funds item
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public void hoverMouseCF() {
		try {
			LoggerInstance.logger.info("hover mouse over Compare Funds item");
		FunctionLibrary.waitTillElementVisible(5, By.xpath(xpath_MutualFundCF));
		Actions action = new Actions(driver);
		action.moveToElement(we_MutualFundCF).build().perform();
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to hover mouse over Compare Funds item");
		}
	}
	/*
	 * Method Name: verifyTextCF 
	 * Description: Function to verify Text
	 * Parameters:
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean verifyTextCF() {
			boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying text");
			result = FunctionLibrary.verifyTextWebelement(expectedTextCF, we_ActualTextCF);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to Verify text");
		}
		return result;
	}
	
	
	/*
	 * Method Name: CompareFundsGraph 
	 * Description: Function to verify Compare Funds Graph is displayed
	 * Parameters:Index1 is value for Index first drop down
	 * 			  Index2 is value for Index second drop down
	 * Created By: Darwin
	 * Created Date: 26-08-2014
	 */
	public boolean compareFundsGraph(String Index1, String Index2) throws Throwable {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Verifying graph is displayed");
			FunctionLibrary.checkingCheckbox(we_GraphChkBox);
			FunctionLibrary.checkingCheckbox(we_EquityChkBox);
			FunctionLibrary.selectItemFromWeblist(we_DropdownOne, "Index");
			FunctionLibrary.selectItemFromWeblist(we_DdiOne, Index1);
			FunctionLibrary.selectItemFromWeblist(we_DropdownTwo, "Index");
			FunctionLibrary.selectItemFromWeblist(we_DdiTwo, Index2);
			we_CompareBtn.click();
			result = we_ImageGraph.isDisplayed();
			if (result==true){
				LoggerInstance.logger.info("Graph is displayed on page");
			}
			else {
				LoggerInstance.logger.info("Graph is not displayed on page");
				}
			}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to verify if graph is displayed");
		}	
		return result;
	}
}
