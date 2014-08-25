package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class MonthlyScoreCardPage{

	final WebDriver driver;
	private final String xpath_MutualFundTab = ".//*[@id='menu-wrapper']/ul/li[3]/a";
	private final String xpath_MonthlySCard = ".//*[@id='menu-wrapper']/ul/li[3]/div/div[1]/ul/li[6]/a";
	private final String xpath_Corpus = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/span";
	private final String xpath_CorpusGainers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[1]/span";
	private final String xpath_CorpusLosers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[3]/span";
	private final String xpath_NAVGainers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[10]/td[1]/span";
	private final String xpath_NAVLosers = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[10]/td[3]/span";
	private final String expectedCorpusColor = "#006699";
	private final String expectedCorpusGainersColor = "#108900";
	private final String expectedCorpusLosersColor = "#FC2A00";
	private final String expectedNAVGainersColor = "#108900";
	private final String expectedNAVLosersColor = "#FC2A00";
	
	private final String xpath_valueCorpusGainerFirstRow = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[1]/table/tbody/tr[1]/td[2]/span";
	private final String xpath_valueCorpusLosersFirstRow = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[7]/td[3]/table/tbody/tr[1]/td[2]/span";
	private final String id_actualValueOnCompPage = "ctl00_BodyCPH_ucLftPanel_lblAvgAUM";
	
	private final String id_CorpusGainers_FirstRow = "ctl00_BodyCPH_rptAUMGainers_ctl01_lnkAMC";
	private final String id_CorpusLosers_FirstRow = "ctl00_BodyCPH_rptAUMLosers_ctl01_lnkAMC";
	private String valueCorpusGainersOnMSCPage;
	private String valueCorpusGainersOnCompPage;
	private String valueCorpusLosersOnMSCPage;
	private String valueCorpusLosersOnCompPage;
	
	
	@FindBy(xpath = xpath_MutualFundTab)
	private WebElement we_MutualFundsTab;
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
	
	// This is a constructor, as every page need a base driver to find web elements
	public MonthlyScoreCardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void hoverMouse() {
		FunctionLibrary.waitTillElementVisible(5, By.xpath(xpath_MutualFundTab));
		Actions action = new Actions(driver);
		action.moveToElement(we_MutualFundsTab).build().perform();
	}
	
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
	
	public void verifyCorpusColour() {
		// #006699 is the Hex Color of BLUE 
		FunctionLibrary.verifyElementColor(we_Corpus,expectedCorpusColor);
	}
	public void verifyCorpusGainersColour() {
		FunctionLibrary.verifyElementColor(we_CorpusGainers,expectedCorpusGainersColor);
	}
	public void verifyCorpusLosersColour() {
		FunctionLibrary.verifyElementColor(we_CorpusLosers,expectedCorpusLosersColor);
	}
	public void verifyNAVGainersColour() {
		FunctionLibrary.verifyElementColor(we_NAVGainers,expectedNAVGainersColor);
	}
	public void verifyNAVLosersColour() {
		FunctionLibrary.verifyElementColor(we_NAVLosers,expectedNAVLosersColor);
	}
	
	public void verifyValueCorpusGainers() {
		valueCorpusGainersOnMSCPage = we_valueCorpusGainerFirstRow.getText();
		FunctionLibrary.clickWebLink(we_CorpusGainers_FirstRow);
		FunctionLibrary.verifyTextWebelement(valueCorpusGainersOnMSCPage, we_actualValueOnCompPage);
	}
	public void verifyValueCorpusLosers() {
		valueCorpusLosersOnMSCPage = we_valueCorpusLosersFirstRow.getText();
		FunctionLibrary.clickWebLink(we_CorpusLosers_FirstRow);
		FunctionLibrary.verifyTextWebelement(valueCorpusLosersOnMSCPage, we_actualValueOnCompPage);
	}
	

	
}
