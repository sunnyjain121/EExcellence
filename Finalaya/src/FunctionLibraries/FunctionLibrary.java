/* Method Name: GetTooltipValue
       * Description: 
        *            This method will return the ToolTip value i.e. title
       * Parameters: 
        *            1. WebDriver Object- Page for which we need the name/title
                       2. WebElement object - Get the locator value.
       * Created By: Anjul Tiwari
       * Created Date: 11-08-2014
       * */

	public void GetTooltipValue (By ByValue, String GoogleTooltip)     {
	   try {
		WebElement toolTipObject = driver.findElement(ByValue);
		String GoogleTooltip = toolTipObject.getAttribute("title");
		System.out.println("Tooltip : " + GoogleTooltip); // This will print Tooltip display value
		}
	  catch(Exception e) {
					System.out.println("Exception - > " + e.toString());
		  }
	}

	
	/* Class Name     : WebDriverBrowser
	* Method Name    : getWebDriver 
	 * Description    : This method will return Webdriver object depending on browser type.
	* Parameters     : 
	 *    1. broswerName : Broswer Name as String 
	 * Created By     : Kuldeep Singh 
	 * Created Date   : 11-08-2014
	*/
	
	public static WebDriver getWebDriver(String broswerName) {
            WebDriver driver = null;
            if (broswerName.equals("firefox")) {
                  // Create a new instance of firefox driver
                  driver = new FirefoxDriver(); 
            } else if (broswerName.equals("chrome")) {
                  System.setProperty("webdriver.chrome.driver", "E:\\ABC\\workspace\\chromedriver_win_26.0.1383.0\\chromedriver.exe");
                  // Create a new instance of chrome driver
                  driver = new ChromeDriver();
            } else if (broswerName.equals("ie")) {
                  // Create a new instance of ie driver
                  driver = new InternetExplorerDriver();
            } else {
                  driver = new FirefoxDriver();
            }
            return driver;
      }
}


/*
  * Method Name    : clickWebLink 
   * Description    : This method will click on web link.
  * Parameters     : 1. btnWebElement : Webelement for web link xpath 
   * Created By     : Kuldeep Singh 
   * Created Date   : 11-08-2014
  */

      public void clickWebLink(WebElement webLinkWebElement) {
            try {
                  if (webLinkWebElement.isEnabled()) {
                        webLinkWebElement.click();
                  } else {
                        System.out.println("Web Link is not Enabled");
                  }
            } catch (Exception e) {
                  System.out.println("Exception Occurred --> " + e.getMessage());
            }
      }

/*
  * Method Name    : clickBtn 
   * Description    : This method will click on button.
  * Parameters     : 1. btnWebElement : Webelement for button xpath 
   * Created By     : Kuldeep Singh 
   * Created Date   : 11-08-2014
  */

      public void clickBtn(WebElement btnWebElement) {
            try {
                  if (btnWebElement.isEnabled()) {
                        btnWebElement.click();
                  } else {
                        System.out.println("Button is not Enabled");
                  }
            } catch (Exception e) {
                  System.out.println("Exception Occurred --> " + e.getMessage());
            }
      }

	  
/* Method Name: waitTillElementPresent
       * Description: 
        *            This function will wait for a pre-defined time untill an element is present on the DOM of a page.
        * Parameters: 
		*	1.	sDriver – variable name used for driver 
		*	2.	iTimeOut – value in seconds for pre-defined time, function will wait for
		*	3.	sIdentifier – variable for identifier type by which object will be located
		*	4.	wElement - variable for identifier value by which object will be located
       * Created By: Darwin Bhandari
       * Created Date: 12-08-2014
       * */

public static void waitTillElementPresent(string sDriver, int iTimeOut, string sIdentifier, WebElement wElement) {
		try {
			WebDriverWait wait = new WebDriverWait(sDriver`, iTimeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.sIdentifier(wElement)));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

2.	/* Method Name: waitTillElementVisible
       * Description: 
        *            This function will wait for a pre-defined time till an element is visible on web page.
					 Visibility means that the element is not only displayed but also has a height and width that is greater than 0
		* Parameters: 
		*	1.	sDriver – variable name used for driver 
		*	2.	iTimeOut – variable for pre-defined time, function will wait for
		*	3.	sIdentifier – variable for identifier type by which object will be located
		*	4.	wElement - variable for identifier value by which object will be located
       * Created By: Darwin Bhandari
       * Created Date: 12-08-2014
* */

public static void waitTillElementVisible(string sDriver, int iTimeOut, string sIdentifier, WebElement wElement) {
		try {
			WebDriverWait wait = new WebDriverWait(sDriver, iTimeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.sIdentifier(wElement)));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
}

/* Method Name: readcellvalue
       * Description: 
        *           This function will fetch the cell value
        * Parameters: 
		*	1.	Xls or xlsx file path
		*	2.	Sheet name
		*	3.	Row number
		*	4.	Column number
       * Created By: Aman Saraf Jain
       * Created Date: 12-08-2014
* */

Way to Call function :  readcellvalue("D:\\testfolder\\test.xlsx","sheet1",52,4);


public static XSSFCell readcellvalue(String Xls_or_Xlsx_file_path,String sheet_name,int row_num,int col_num) throws IOException
		{
		InputStream ExcelFileToRead = new FileInputStream(Xls_or_Xlsx_file_path);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet=wb.getSheet(sheet_name);
		XSSFCell cell = null;
			try{
			cell = sheet.getRow(row_num-1).getCell(col_num-1);
			System.out.println(cell);
			return cell;
			}
			catch(Exception e){
				System.out.print("Unable to read cell  --> "+e.getMessage());
				return cell;
		  }
		}

1.	/* Method Name: waitTillElementEnable
       * Description: 
        *            This function will wait for a pre-defined time untill an element is enable on the DOM of a page.
        * Parameters: 
		*	1.	sDriver – variable name used for driver 
		*	2.	iTimeOut – value in seconds for pre-defined time, function will wait for
		*	3.	sIdentifier – variable for identifier type by which object will be located
		*	4.	wElement - variable for identifier value by which object will be located
       * Created By: Darwin Bhandari
       * Created Date: 13-08-2014
       * */

public static void waitTillElementEnable(string sDriver, int iTimeOut, string sIdentifier, WebElement wElement) {
		try {
			WebDriverWait wait = new WebDriverWait(sDriver, iTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(By.sIdentifier(wElement)));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

2.	/* Method Name: waitTillPageLoaded
       * Description: 
        *            This function will wait for a pre-defined time till page is loaded completely
        * Parameters: 
		*	1.	sDriver – variable name used for driver 
		*	2.	iTimeOut – variable for pre-defined time, function will wait for
       * Created By: Darwin Bhandari
       * Created Date: 13-08-2014
       * */

  	public void waitTillPageLoaded(WebDriver driver) throws InterruptedException {
                ExpectedCondition<Boolean> expectation = new
                     ExpectedCondition<Boolean>(){     
              public Boolean  apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
               }
             };
             FluentWait<WebDriver> wait = new WebDriverWait(sDriver, iTimeOut);
             try {
                   wait.until(expectation);
             } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
          }
        }
	}

/* Method Name: 
       * Description: getElementColor
        *            This method will return the color of the element.
        * Parameters: 
        *            1. WebElement object identifier  - Get the locator value.
       * Created By: Sunny Jain
       * Created Date: 14-08-2014
       * */
	public static String getElementColor(By ByValue) {
		try{
			WebElement e = driver.findElement(ByValue);
			String rgb = e.getCssValue("color");
			return rgb;
		} catch(Exception e) {
			System.out.println("Exception - > " + e.toString());
			return e.toString();
	  }
			
	}			
2.
/* Method Name: 
       * Description: navigateToPage
        *            This method to navigate to page url.
        * Parameters: 
        *            1. Page Url.
       * Created By: Sunny Jain
       * Created Date: 14-08-2014
       * */

public static void navigateToPage(String url){
			try{
				driver.get(url);
			  
			} catch(Exception e) {
				  
				  System.out.println("Exception - > " + e.toString());
			  }
			
		}
3.
	
/* Method Name: selectItemFromWeblist
       * Description: 
        *            This method will select the value from weblist.
        * Parameters: 
        *            1. WebElement object identifier  - Get the locator value.
                     2. TextValue  - to select particular value from weblist
       * Created By: Sunny Jain
       * Created Date: 12-08-2014
       * */

public static void selectItemFromWeblist(By ByValue,String textValue){
			try{
				  
			    WebElement element = driver.findElement(ByValue);	
			    Select selectElement = new Select(element);
			    selectElement.selectByVisibleText(textValue);
			    System.out.println(selectElement.getFirstSelectedOption().getText()); 
			  }
			
			  catch(Exception e) {
				  System.out.println("Exception - > " + e.toString());
			  }
			
		} 
4.
/* Method Name: getContentFromWebList
       * Description: 
        *            This method will select the value from weblist.
        * Parameters: 
        *            1. WebElement object identifier  - Get the locator value.
      
       * Created By: Sunny Jain
       * Created Date: 12-08-2014
       * */

public static List getContentFromWebList(By ByValue) {
		
		List <String> webList = new ArrayList <String>();
		
		try{
			WebElement element = driver.findElement(ByValue);
			 Select selectElement = new Select(element);
			 List <WebElement> theseOptions = selectElement.getOptions();
			 int i = selectElement.getOptions().size();
		     
	          for(int k = 1; k<i; k++)
		       {
		       webList.add(theseOptions.get(k).getText());
		     }        
	  } 
		
	  catch(Exception e) {
		  System.out.println("Exception - > " + e.toString());
		   
	  }
		System.out.println(webList);
		return  webList;
}


public static String sort_alphabetically(Boolean ascending, String listDataSplittedBySpace) {
        Collator col = Collator.getInstance(new Locale("en", "EN"));
        String s = listDataSplittedBySpace;
        String[] s1= s.split(" ");
        Arrays.sort(s1, col);
        String sorted = "";
        String sortedDesecding = "";
        
        try {
        for (int i = 0; i < s1.length; i++)
        {
          sorted += s1[i] + " ";
        }
        for (int j=s1.length; j>0; j--)
        {
            sortedDesecding += s1[j-1] + " ";
        }
        if(ascending==true){
            return sorted;
        }
        else if(ascending==false){
            sorted="";
            sorted+=sortedDesecding;
            return sorted;
        }
        else{
            JOptionPane.showMessageDialog(null,"Please choose True for ascending or False for descending");
        }
        
        }
        catch(Exception e) {
            System.out.println("Exception Occurred --> "+e.getMessage());
            return null;
        }
        return sortedDesecding;
 }
 
 
 public static void WebEdit(WebElement element, String val) {    
	try
	{
		element.clear();
		element.sendKeys(val);
	} catch(Exception e) {
			System.out.println("failed to enter the value" +e);
		}
}


public static void exampleInputRadio(List<WebElement> element, int optionval) {
    try
		{
			List<WebElement> radios = element;
			if (optionval > 0 && optionval <= radios.size()) {
				System.out.println(element.get(optionval -1).getText());
				radios.get(optionval - 1).click();                        
             } 
		} catch (Exception e) {
            System.out.println("Element is not present" +e);
           }
}

public static WebElement CheckingChkbox(WebElement chkbx1)
{  
	try {
			boolean checkstatus;  
			checkstatus=chkbx1.isSelected();  
			if (checkstatus==true){  
			System.out.println("Checkbox is already checked");    
			}  
			else  
			{  
			chkbx1.click();  
			System.out.println("Checked the checkbox");  
			}  
		} catch(Exception e)
			{
				System.out.println("Checked the checkbox" +e);
			}
		return chkbx1;
}



public  static void  verifytextWebelement(WebElement element ,String text)

{
	try
	{
		String stringverify=element.getText();
	
		Assert.assertEquals(text, stringverify);
	}catch(Exception e)
	{
		System.out.println("the element is not present" +e);
	}
}


public static boolean isTextPresent(String txtValue){
       WebDriver driver = null; 
 boolean b = false;
     try{
         b = driver.getPageSource().contains(txtValue);
         return b;
     }
     catch (Exception e){
         System.out.println(e.getMessage());
     }     
     finally{
      return b;
     }
}
     }
}
