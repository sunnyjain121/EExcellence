package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;

public class IPOPage {

	final WebDriver driver;

	private final String xPath_IPOTab = "//a[text()='IPO']";
	private final String xpath_IPOPageLabel = ".//*[@id='ctl00_BodyCPH_ipoCalendar_divCompany']";

	private final String xpath_IPOPageCalDay_Sunday = ".//*[@id='calendar']/div/div/table/thead/tr/th[1]";
	private final String xpath_IPOPageCalDay_Monday = ".//*[@id='calendar']/div/div/table/thead/tr/th[2]";
	private final String xpath_IPOPageCalDay_Tuesday = ".//*[@id='calendar']/div/div/table/thead/tr/th[3]";
	private final String xpath_IPOPageCalDay_Wednesday = ".//*[@id='calendar']/div/div/table/thead/tr/th[4]";
	private final String xpath_IPOPageCalDay_Thursday = ".//*[@id='calendar']/div/div/table/thead/tr/th[5]";
	private final String xpath_IPOPageCalDay_Friday = ".//*[@id='calendar']/div/div/table/thead/tr/th[6]";
	private final String xpath_IPOPageCalDay_Saturday = ".//*[@id='calendar']/div/div/table/thead/tr/th[7]";

	private final String xpath_IPOPageCalCurrentMonthAndYear = ".//*[@id='calendar']/table/tbody/tr/td[1]/span/h2";

	private final String xpath_IPOPageCal_PreYear = ".//*[@id='calendar']/table/tbody/tr/td[3]/span[1]";
	private final String xpath_IPOPageCal_PreMonth = ".//*[@id='calendar']/table/tbody/tr/td[3]/span[2]";
	private final String xpath_IPOPageCal_Today = ".//*[@id='calendar']/table/tbody/tr/td[3]/span[4]";
	private final String xpath_IPOPageCal_NextMonth = ".//*[@id='calendar']/table/tbody/tr/td[3]/span[6]";
	private final String xpath_IPOPageCal_NextYear = ".//*[@id='calendar']/table/tbody/tr/td[3]/span[7]";
	

	private final String xpath_IPOPageOpen_Color = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/div[1]";
	private final String xpath_IPOPageClose_Color = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/div[2]";
	private final String xpath_IPOPageUpcoming_Color = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/div[3]";
	private final String xpath_IPOPageListing_Color = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/div[4]";

	private final String xpath_IPOPageOpen_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[1]";
	private final String xpath_IPOPageClose_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[2]";
	private final String xpath_IPOPageUpcoming_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[3]";
	private final String xpath_IPOPageListing_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[4]";

	@FindBy(how = How.XPATH, using = xPath_IPOTab)
	private WebElement we_IPOTab2;

	@FindBy(how = How.XPATH, using = xpath_IPOPageLabel)
	private WebElement we_IPOPageLabel;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Sunday)
	private WebElement we_IPOPageCalDay_Sunday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Monday)
	private WebElement we_IPOPageCalDay_Monday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Tuesday)
	private WebElement we_IPOPageCalDay_Tuesday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Wednesday)
	private WebElement we_IPOPageCalDay_Wednesday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Thursday)
	private WebElement we_IPOPageCalDay_Thursday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Friday)
	private WebElement we_IPOPageCalDay_Friday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalDay_Saturday)
	private WebElement we_IPOPageCalDay_Saturday;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCalCurrentMonthAndYear)
	private WebElement we_IPOPageCalCurrentMonthAndYear;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCal_PreYear)
	private WebElement we_IPOPageCal_PreYear;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCal_PreMonth)
	private WebElement we_IPOPageCal_PreMonth;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCal_NextYear)
	private WebElement we_IPOPageCal_NextYear;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCal_NextMonth)
	private WebElement we_IPOPageCal_NextMonth;

	@FindBy(how = How.XPATH, using = xpath_IPOPageCal_Today)
	private WebElement we_IPOPageCal_Today;

	@FindBy(how = How.XPATH, using = xpath_IPOPageOpen_Color)
	private WebElement we_IPOPageOpen_Color;

	@FindBy(how = How.XPATH, using = xpath_IPOPageClose_Color)
	private WebElement we_IPOPageClose_Color;

	@FindBy(how = How.XPATH, using = xpath_IPOPageUpcoming_Color)
	private WebElement we_IPOPageUpcoming_Color;

	@FindBy(how = How.XPATH, using = xpath_IPOPageListing_Color)
	private WebElement we_IPOPageListing_Color;

	@FindBy(how = How.XPATH, using = xpath_IPOPageOpen_Text)
	private WebElement we_IPOPageOpen_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageClose_Text)
	private WebElement we_IPOPageClose_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageUpcoming_Text)
	private WebElement we_IPOPageUpcoming_Text;

	@FindBy(how = How.XPATH, using = xpath_IPOPageListing_Text)
	private WebElement we_IPOPageListing_Text;

	// This is a constructor, as every page need a base driver to find web elements
	public IPOPage(WebDriver driver) {
		this.driver = driver;
	}

	// static CommonUtility commonUtility;
	public void clickOnIPOTab() {
		FunctionLibrary.clickWebLink(we_IPOTab2);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// Verify that user should be navigated to IPO page - verify IPO page level
	public void verifyIPOPageLevel() {
		FunctionLibrary.verifyValueOrText("IPO Calendar", we_IPOPageLabel.getText());
	}

	// Verify that Calendar is displayed on the page - verify that calendar days are displaying
	public void verifyCalendarDisplay() {
		FunctionLibrary.verifyValueOrText("Sun", we_IPOPageCalDay_Sunday.getText());
		FunctionLibrary.verifyValueOrText("Mon", we_IPOPageCalDay_Monday.getText());
		FunctionLibrary.verifyValueOrText("Tue", we_IPOPageCalDay_Tuesday.getText());
		FunctionLibrary.verifyValueOrText("Wed", we_IPOPageCalDay_Wednesday.getText());
		FunctionLibrary.verifyValueOrText("Thu", we_IPOPageCalDay_Thursday.getText());
		FunctionLibrary.verifyValueOrText("Fri", we_IPOPageCalDay_Friday.getText());
		FunctionLibrary.verifyValueOrText("Sat", we_IPOPageCalDay_Saturday.getText());
	}

	// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
	public void verifyCalendarCurrentMonthAndYearDisplay() {
		FunctionLibrary.verifyValueOrText(FunctionLibrary.getCalendarCurrentMonthAndYear(), we_IPOPageCalCurrentMonthAndYear.getText());
	}

	// Verify that Calendar navigation is displayed on the right upper side of Calendar - verify calendar navigation is displayed
	public void verifyCalendarNavigationDisplay() {
		we_IPOPageCal_PreYear.isEnabled();
		we_IPOPageCal_PreMonth.isEnabled();
		we_IPOPageCal_Today.isEnabled();
		we_IPOPageCal_NextMonth.isEnabled();
		we_IPOPageCal_NextYear.isEnabled();
	}

	// Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed - verify color code and text
	public void verifyCalendarColorAndText() {
		FunctionLibrary.verifyValueOrText("#9FE900", FunctionLibrary.getrgbaColor(we_IPOPageOpen_Color));
		FunctionLibrary.verifyValueOrText("#D00000", FunctionLibrary.getrgbaColor(we_IPOPageClose_Color));
		FunctionLibrary.verifyValueOrText("#E9C500", FunctionLibrary.getrgbaColor(we_IPOPageUpcoming_Color));
		FunctionLibrary.verifyValueOrText("#005DE9", FunctionLibrary.getrgbaColor(we_IPOPageListing_Color));
		FunctionLibrary.verifyValueOrText("Open", we_IPOPageOpen_Text.getText());
		FunctionLibrary.verifyValueOrText("Close", we_IPOPageClose_Text.getText());
		FunctionLibrary.verifyValueOrText("Upcoming", we_IPOPageUpcoming_Text.getText());
		FunctionLibrary.verifyValueOrText("Listing", we_IPOPageListing_Text.getText());
	}

	// Verify that Calendar navigation functionality is working or not - verify calendar navigation functionality
	public void verifyCalendarNavigation() {
		
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
			System.out.println("Previous Year match with value " + preYear);
		}else System.out.println("Previous Year value is not matching");

		// Clicking on Previous Month link
		FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FunctionLibrary.clickWebLink(we_IPOPageCal_PreMonth);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String preMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
		int preMonth = FunctionLibrary.getMonthIntValue(preMonthAndYear_Again.split(" ")[0]);
		if (preMonth == currentMonth - 1) {
			System.out.println("Previous Month match with value " + preMonth);
		}else System.out.println("Previous Month value is not matching");
		
		// Clicking on Next Month link
		FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FunctionLibrary.clickWebLink(we_IPOPageCal_NextMonth);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String nextMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
		int nextMonth = FunctionLibrary.getMonthIntValue(nextMonthAndYear.split(" ")[0]);
		if (nextMonth == currentMonth + 1) {
			System.out.println("Next Month match with value " + nextMonth);
		}else System.out.println("Next Month value is not matching");

		// Clicking on Next Year link
		FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FunctionLibrary.clickWebLink(we_IPOPageCal_NextYear);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String nextMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
		int nextYear = Integer.parseInt(nextMonthAndYear_Again.split(" ")[1]);
		if (nextYear == currentYear + 1) {
			System.out.println("Next Year match with value " + nextYear);
		}else System.out.println("Next Year value is not matching");
	}
	
	
	
}
