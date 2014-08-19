package PageObjects;

//package com.finalaya.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import FunctionLibraries.CommonUtility;
import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class MarketPage {
	
	private final String csspath_MarketTab = "html.js.flexbox.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.no-csstransforms3d.csstransitions.fontface.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body form#form1 div.topContainerHome div.fltLft100 div div#ucHeader_divHeader div#ucHeader_divMenu.fltLft100 div#menu-wrapper.menu-wrapper ul.nav li a";
	private final String id_BSETAb="ctl00_BodyCPH_lnkBSE";
	private final String id_NSETAb="ctl00_BodyCPH_lnkNSE";
	private final String id_SensexCurrentValue="ctl00_BodyCPH_ucExGraph_lblCurrentValue";
	private final String id_SensexValueChange="ctl00_BodyCPH_ucExGraph_lblAbsoluteChange";
	private final String id_SensexPercentageChange="ctl00_BodyCPH_ucExGraph_lblPercentChange";
	private final String xpath_MarketToday="//*[@id='divMarket']//div[contains(text(),'Market Today')]";
	private final String csspath_OpenLowHighPreClose = "html.js.flexbox.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.no-csstransforms3d.csstransitions.fontface.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body form#aspnetForm div div div div#divMarket div#mak_1 div.mak_info_grp div#divExchangeGraph div div.mar_OHLC";
	@FindBy(css = csspath_MarketTab)
	public WebElement we_MarketTab;
	@FindBy(css = csspath_OpenLowHighPreClose)
	public WebElement we_OpenLowHighPreClose;
	@FindBy(id = id_BSETAb)
	public WebElement we_BSETab;
	@FindBy(id = id_NSETAb)
	public WebElement we_NSETab;
	@FindBy(id = id_SensexCurrentValue)
	public WebElement we_SensexCurrentValue;
	@FindBy(id = id_SensexValueChange)
	public WebElement we_SensexValueChange;
	@FindBy(id = id_SensexPercentageChange)
	public WebElement we_SensexPercentageChange;
	@FindBy(xpath = xpath_MarketToday)
	public WebElement we_MarketToday;
	//Function to click on Market Tab
	public void clickOnMarketTab()
	{
		try
		{
		
			LoggerInstance.logger.info("click on Market Tab");
			FunctionLibrary.clickWebLink(we_MarketTab);
		}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to click on Market Tab");
		}
	}
	//Function to click on BSE tab
	public void clickOnBSETab()
	{
		try
		{
		
			LoggerInstance.logger.info("click on BSE Tab");
			FunctionLibrary.clickWebLink(we_BSETab);
		}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to click on BSE Tab");
		}
	}
	//Function to click on NSE tab
		public void clickOnNSETab()
		{
			try
			{
			
				LoggerInstance.logger.info("click on NSE Tab");
				FunctionLibrary.clickWebLink(we_NSETab);
			}
			catch(Exception e)
			{
			LoggerInstance.logger.info("Not able to click on NSE Tab");
			}
		}
		
		public boolean verifyOpenLowHighPreCloseIsDisplayed(){
			boolean result= false;
			try{
			 result=we_OpenLowHighPreClose.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Open, low, Hig, Pre Close is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Open, low, Hig, Pre Close is not displayed");
				return result;
				}
		}
		
		public boolean verifyMarketPageIsDisplayed(){
			boolean result= false;
			try{
			 result=we_MarketToday.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("User is navigated to Market Page");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("User is not navigated to Market Page");
				return result;
				}
		}
		public boolean verifyCurrentValueOfSensexIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexCurrentValue.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Current value of Sensex is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Current value of Sensex is not displayed");
				return result;
				}
		}
		public boolean verifyCurrentValueOfNiftyIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexCurrentValue.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Current value of Nifty is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Current value of Nifty is not displayed");
				return result;
				}
		}
		public boolean verifyValueChangeOfNiftyIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexValueChange.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Value chnage of Nifty is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Value change of Nifty is not displayed");
				return result;
				}
		}
		public boolean verifyValueChangeOfSensexIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexValueChange.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Value chnage of Sensex is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Value change of Sensex is not displayed");
				return result;
				}
		}
		
	
		
		public boolean verifyPercentageChangeOfSensexIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexPercentageChange.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Percentage chnage of Sensex is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Percentage change of Sensex is not displayed");
				return result;
				}
		}
		public boolean verifyPercentageChangeOfNiftyIsDisplayed(){
			boolean result= false;
			try{
			 result=we_SensexPercentageChange.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Percentage chnage of Nifty is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Percentage change of Nifty is not displayed");
				return result;
				}
		}
		
}

