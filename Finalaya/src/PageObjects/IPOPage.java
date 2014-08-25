package PageObjects;

/* Description: IPO page object class
 * Created By: Kuldeep Singh
 * Created Date: 16 Aug 2014
 * */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class IPOPage {

	final WebDriver driver;

	private final String csspath_IPOTab = "#menu-wrapper > ul > li:nth-child(4) > a";
	private final String csspath_IPOPageLabel = "#ctl00_BodyCPH_ipoCalendar_divCompany";

	private final String csspath_IPOPageCalDay_Sunday = ".fc-sun.ui-widget-header.fc-first";
	private final String csspath_IPOPageCalDay_Monday = ".fc-mon.ui-widget-header";
	private final String csspath_IPOPageCalDay_Tuesday = ".fc-tue.ui-widget-header";
	private final String csspath_IPOPageCalDay_Wednesday = ".fc-wed.ui-widget-header";
	private final String csspath_IPOPageCalDay_Thursday = ".fc-thu.ui-widget-header";
	private final String csspath_IPOPageCalDay_Friday = ".fc-fri.ui-widget-header";
	private final String csspath_IPOPageCalDay_Saturday = ".fc-sat.ui-widget-header.fc-last";

	private final String csspath_IPOPageCalCurrentMonthAndYear = ".fc-header-title>h2";

	private final String csspath_IPOPageCal_PreYear = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-prevYear.ui-state-default.ui-corner-left > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_PreMonth = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-prev.ui-state-default.ui-corner-right > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_Today = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-today.ui-state-default.ui-corner-left.ui-corner-right";
	private final String csspath_IPOPageCal_NextMonth = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-next.ui-state-default.ui-corner-left > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_NextYear = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-nextYear.ui-state-default.ui-corner-right > span > span.fc-button-content > span > span";

	private final String csspath_IPOPageOpen_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(1)";
	private final String csspath_IPOPageClose_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(3)";
	private final String csspath_IPOPageUpcoming_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(5)";
	private final String csspath_IPOPageListing_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(7)";

	private final String xpath_IPOPageOpen_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[1]";
	private final String xpath_IPOPageClose_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[2]";
	private final String xpath_IPOPageUpcoming_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[3]";
	private final String xpath_IPOPageListing_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[4]";

	private final String csspath_IPOCalDiv = "#calendar > div > div > div > div:nth-child(1) > div > span > a";
	private final String csspath_IPOCalMicrositeName = "#ctl00_BodyCPH_lblHeading";

	private final String xpath_IPOCalMicrositeTableHeader_Overview = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[1]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_IssueDetails = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[3]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_ContactInformation = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[5]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_IPOManagingBodies = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[2]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_Documents = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[4]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_ResearchReports = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[6]/td/table/thead/tr/th";

	@FindBy(how = How.CSS, using = csspath_IPOTab)
	private WebElement we_IPOTab2;

	@FindBy(how = How.CSS, using = csspath_IPOPageLabel)
	private WebElement we_IPOPageLabel;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Sunday)
	private WebElement we_IPOPageCalDay_Sunday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Monday)
	private WebElement we_IPOPageCalDay_Monday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Tuesday)
	private WebElement we_IPOPageCalDay_Tuesday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Wednesday)
	private WebElement we_IPOPageCalDay_Wednesday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Thursday)
	private WebElement we_IPOPageCalDay_Thursday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Friday)
	private WebElement we_IPOPageCalDay_Friday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalDay_Saturday)
	private WebElement we_IPOPageCalDay_Saturday;

	@FindBy(how = How.CSS, using = csspath_IPOPageCalCurrentMonthAndYear)
	private WebElement we_IPOPageCalCurrentMonthAndYear;

	@FindBy(how = How.CSS, using = csspath_IPOPageCal_PreYear)
	private WebElement we_IPOPageCal_PreYear;

	@FindBy(how = How.CSS, using = csspath_IPOPageCal_PreMonth)
	private WebElement we_IPOPageCal_PreMonth;

	@FindBy(how = How.CSS, using = csspath_IPOPageCal_NextYear)
	private WebElement we_IPOPageCal_NextYear;

	@FindBy(how = How.CSS, using = csspath_IPOPageCal_NextMonth)
	private WebElement we_IPOPageCal_NextMonth;

	@FindBy(how = How.CSS, using = csspath_IPOPageCal_Today)
	private WebElement we_IPOPageCal_Today;

	@FindBy(how = How.CSS, using = csspath_IPOPageOpen_Color)
	private WebElement we_IPOPageOpen_Color;

	@FindBy(how = How.CSS, using = csspath_IPOPageClose_Color)
	private WebElement we_IPOPageClose_Color;

	@FindBy(how = How.CSS, using = csspath_IPOPageUpcoming_Color)
	private WebElement we_IPOPageUpcoming_Color;

	@FindBy(how = How.CSS, using = csspath_IPOPageListing_Color)
	private WebElement we_IPOPageListing_Color;

	@FindBy(how = How.XPATH, using = xpath_IPOPageOpen_Text)
	private WebElement we_IPOPageOpen_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageClose_Text)
	private WebElement we_IPOPageClose_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageUpcoming_Text)
	private WebElement we_IPOPageUpcoming_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageListing_Text)
	private WebElement we_IPOPageListing_Text;

	@FindBy(how = How.CSS, using = csspath_IPOCalDiv)
	private WebElement we_IPOCalDiv;

	@FindBy(how = How.CSS, using = csspath_IPOCalMicrositeName)
	private WebElement we_IPOCalMicrositeName;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_Overview)
	private WebElement we_IPOCalMicrositeTableHeader_Overview;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_IssueDetails)
	private WebElement we_IPOCalMicrositeTableHeader_IssueDetails;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_ContactInformation)
	private WebElement we_IPOCalMicrositeTableHeader_ContactInformation;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_IPOManagingBodies)
	private WebElement we_IPOCalMicrositeTableHeader_IPOManagingBodies;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_Documents)
	private WebElement we_IPOCalMicrositeTableHeader_Documents;

	@FindBy(how = How.XPATH, using = xpath_IPOCalMicrositeTableHeader_ResearchReports)
	private WebElement we_IPOCalMicrositeTableHeader_ResearchReports;

	// This is a constructor, as every page need a base driver to find web elements
	public IPOPage(WebDriver driver) {
		this.driver = driver;
	}

	// Function to click on IPO tab
	public void clickOnIPOTab() {
		try {
			LoggerInstance.logger.info("click on IPO Tab");
			FunctionLibrary.clickWebLink(we_IPOTab2);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Market Tab");
		}
	}

	// Function to Verify that user should be navigated to IPO page - verify IPO page level
	public void verifyIPOPageLevel() {
		try {
			LoggerInstance.logger.info("User is navigated to IPO page");
			FunctionLibrary.verifyTextWebelement("IPO Calendar", we_IPOPageLabel);
		} catch (Exception e) {
			LoggerInstance.logger.info("User is not navigated to IPO page");
		}
	}

	// Verify that Calendar is displayed on the page - verify that calendar days are displaying
	public void verifyCalendarDisplay() {
		try {
			LoggerInstance.logger.info("Calendar is displayed");
			FunctionLibrary.verifyTextWebelement("Sun", we_IPOPageCalDay_Sunday);
			FunctionLibrary.verifyTextWebelement("Mon", we_IPOPageCalDay_Monday);
			FunctionLibrary.verifyTextWebelement("Tue", we_IPOPageCalDay_Tuesday);
			FunctionLibrary.verifyTextWebelement("Wed", we_IPOPageCalDay_Wednesday);
			FunctionLibrary.verifyTextWebelement("Thu", we_IPOPageCalDay_Thursday);
			FunctionLibrary.verifyTextWebelement("Fri", we_IPOPageCalDay_Friday);
			FunctionLibrary.verifyTextWebelement("Sat", we_IPOPageCalDay_Saturday);
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar is not displayed");
		}
	}

	// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
	public void verifyCalendarCurrentMonthAndYearDisplay() {
		try {
			LoggerInstance.logger.info("Calendar current month and year is displayed");
			FunctionLibrary.verifyTextWebelement(FunctionLibrary.getCalendarCurrentMonthAndYear(), we_IPOPageCalCurrentMonthAndYear);
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar current month and year is not displayed");
		}
	}

	// Verify that Calendar navigation is displayed on the right upper side of Calendar - verify calendar navigation is displayed
	public void verifyCalendarNavigationDisplay() {
		try {
			LoggerInstance.logger.info("Calendar navigation is displayed on the right upper side of Calendar");
			we_IPOPageCal_PreYear.isEnabled();
			we_IPOPageCal_PreMonth.isEnabled();
			we_IPOPageCal_Today.isDisplayed();
			we_IPOPageCal_NextMonth.isEnabled();
			we_IPOPageCal_NextYear.isEnabled();
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar navigation is not displayed on the right upper side of Calendar");
		}
	}

	// Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed - verify color code and text
	public void verifyCalendarColorAndText() {
		try {
			LoggerInstance.logger.info("(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed");
			FunctionLibrary.verifyElementColor(we_IPOPageOpen_Color,"#9FE900");
			FunctionLibrary.verifyElementColor(we_IPOPageClose_Color,"#D00000");
			FunctionLibrary.verifyElementColor(we_IPOPageUpcoming_Color,"#E9C500");
			FunctionLibrary.verifyElementColor(we_IPOPageListing_Color,"#005DE9");
			FunctionLibrary.verifyTextWebelement("Open", we_IPOPageOpen_Text);
			FunctionLibrary.verifyTextWebelement("Close", we_IPOPageClose_Text);
			FunctionLibrary.verifyTextWebelement("Upcoming", we_IPOPageUpcoming_Text);
			FunctionLibrary.verifyTextWebelement("Listing", we_IPOPageListing_Text);
		} catch (Exception e) {
			LoggerInstance.logger.info("(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is not displayed");
		}
	}

	// Verify that Calendar navigation functionality is working or not - verify calendar navigation functionality
	public void verifyCalendarNavigation() {

		try {
			LoggerInstance.logger.info("Going to check Calendar navigation functionality");
			// Storing current month and year value in currentMonth and currentYear variable
			String string_IPOPageCalCurrentMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
			int currentMonth = FunctionLibrary.getMonthIntValue(string_IPOPageCalCurrentMonthAndYear.split(" ")[0]);
			int currentYear = Integer.parseInt(string_IPOPageCalCurrentMonthAndYear.split(" ")[1]);

			// Clicking on Previous year link
			FunctionLibrary.clickWebLink(we_IPOPageCal_PreYear);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String preMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
			int preYear = Integer.parseInt(preMonthAndYear.split(" ")[1]);
			if (preYear == currentYear - 1) {
				LoggerInstance.logger.info("Previous Year match with value " + preYear);
			} else
				LoggerInstance.logger.info("Previous Year value is not matching");

			// Clicking on Previous Month link
			FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FunctionLibrary.clickWebLink(we_IPOPageCal_PreMonth);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String preMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
			int preMonth = FunctionLibrary.getMonthIntValue(preMonthAndYear_Again.split(" ")[0]);
			if (preMonth == currentMonth - 1) {
				LoggerInstance.logger.info("Previous Month match with value " + preMonth);
			} else
				LoggerInstance.logger.info("Previous Month value is not matching");

			// Clicking on Next Month link
			FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FunctionLibrary.clickWebLink(we_IPOPageCal_NextMonth);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String nextMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
			int nextMonth = FunctionLibrary.getMonthIntValue(nextMonthAndYear.split(" ")[0]);
			if (nextMonth == currentMonth + 1) {
				LoggerInstance.logger.info("Next Month match with value " + nextMonth);
			} else
				LoggerInstance.logger.info("Next Month value is not matching");

			// Clicking on Next Year link
			FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FunctionLibrary.clickWebLink(we_IPOPageCal_NextYear);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String nextMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
			int nextYear = Integer.parseInt(nextMonthAndYear_Again.split(" ")[1]);
			if (nextYear == currentYear + 1) {
				LoggerInstance.logger.info("Next Year match with value " + nextYear);
			} else
				LoggerInstance.logger.info("Next Year value is not matching");
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar navigation functionality is not working");
		}
	}

	// Click on Company Name and Navigated to page under Home> IPO Calender > IPO Microsite where Company Name is displayed as Label
	public void verifyCalendarCompanyies() {
		try {
			LoggerInstance.logger.info("Going to click on Company and Navigated to page under Home> IPO Calender > IPO Microsite");
			String ipoCompanyName = we_IPOCalDiv.getText();
			FunctionLibrary.clickWebLink(we_IPOCalDiv);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FunctionLibrary.verifyTextWebelement(ipoCompanyName, we_IPOCalMicrositeName);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Company");
		}
	}

	// On Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports
	public void verifyIPOMicrositeTableHeader() {
		try {
			LoggerInstance.logger.info("Going to check table header");
			FunctionLibrary.verifyTextWebelement("Overview", we_IPOCalMicrositeTableHeader_Overview);
			FunctionLibrary.verifyTextWebelement("Issue Details", we_IPOCalMicrositeTableHeader_IssueDetails);
			FunctionLibrary.verifyTextWebelement("Contact information", we_IPOCalMicrositeTableHeader_ContactInformation);
			FunctionLibrary.verifyTextWebelement("IPO Managing Bodies", we_IPOCalMicrositeTableHeader_IPOManagingBodies);
			FunctionLibrary.verifyTextWebelement("Documents", we_IPOCalMicrositeTableHeader_Documents);
			FunctionLibrary.verifyTextWebelement("Research Reports", we_IPOCalMicrositeTableHeader_ResearchReports);
		} catch (Exception e) {
			LoggerInstance.logger.info("Table header are not displayed");
		}
	}

}
