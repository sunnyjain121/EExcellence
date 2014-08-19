package FunctionLibraries;

import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Logger.LoggerInstance;

public class FunctionLibrary {

	 static WebDriver driver = null;
	
/* Method Name: GetTooltipValue
       * Description: 
        *            This method will return the ToolTip value i.e. title
       * Parameters: 
        *            1. WebDriver Object- Page for which we need the name/title
                       2. WebElement object - Get the locator value.
       * Created By: Anjul Tiwari
       * Created Date: 11-08-2014
       * */

	public void GetTooltipValue (By ByValue, String googleTooltip)     {
	   try {
			WebElement toolTipObject = driver.findElement(ByValue);
			googleTooltip = toolTipObject.getAttribute("title");
			System.out.println("Tooltip : " + googleTooltip); // This will print Tooltip display value
		}
	  catch(Exception e) {
					System.out.println("Exception - > " + e.toString());
		  }
	}

	
	/* Class Name    : WebDriverBrowser
	* Method Name    : getWebDriver 
	 * Description   : This method will return Webdriver object depending on browser type.
	* Parameters     : 
	 *    1. broswerName : Broswer Name as String 
	 * Created By     : Kuldeep Singh 
	 * Created Date   : 11-08-2014
	*/
	
	public static WebDriver getWebDriver(String browserName) {
        try {   
	        switch(browserName) {
	        case "firefox":
	        	 driver = new FirefoxDriver(); 
	        	break;
	        case "chrome" :
	        	System.setProperty("webdriver.chrome.driver", "");
	        	break;
	        case "ie" :
	        	driver = new InternetExplorerDriver();
	        	break;
	        }
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	driver = null;
        }
        return driver;
      }


/*
  * Method Name    : clickWebLink 
   * Description   : This method will click on web link.
  * Parameters     : 1. btnWebElement : Webelement for web link xpath 
   * Created By    : Kuldeep Singh 
   * Created Date  : 11-08-2014
  */

	/*
     * Method Name    : clickWebLink 
      * Description    : This method will click on web link.
     * Parameters     : 1. btnWebElement : Webelement for web link xpath 
      * Created By     : Kuldeep Singh 
      * Created Date   : 11-08-2014
     */

     public static void clickWebLink(WebElement webLinkWebElement) {
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
   * Description   : This method will click on button.
  * Parameters     : 1. btnWebElement : Webelement for button xpath 
   * Created By    : Kuldeep Singh 
   * Created Date  : 11-08-2014
  */

      public void clickButton(WebElement btnWebElement) {
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

public static void waitTillElementPresent(WebDriver driver, int iTimeOut, By byVal) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(byVal));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

}	/* Method Name: waitTillElementVisible
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

public static void waitTillElementVisible(int iTimeOut, By byVal) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
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

//Way to Call function :  readcellvalue("D:\\testfolder\\test.xlsx","sheet1",52,4);


public static XSSFCell readcellvalue(String excelFilepath,String sheetName,int rowNum,int colNum) throws IOException {
		InputStream ExcelFileToRead = new FileInputStream(excelFilepath);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet=wb.getSheet(sheetName);
		XSSFCell cell = null;
		try{
		cell = sheet.getRow(rowNum-1).getCell(colNum-1);
		System.out.println(cell);
		return cell;
		}
		catch(Exception e){
			System.out.print("Unable to read cell  --> "+e.getMessage());
			return cell;
	  }
}

	/* Method Name: waitTillElementEnable
       * Description: 
        *            This function will wait for a pre-defined time untill an element is enable on the DOM of a page.
        * Parameters:  
		*	1.	iTimeOut – value in seconds for pre-defined time, function will wait for
		*	2. byVal: By Type variable
       * Created By: Darwin Bhandari
       * Created Date: 13-08-2014
       * */

public static void waitTillElementEnable(int iTimeOut, By byVal) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(byVal));
		    }
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
}
	/* Method Name: waitTillPageLoaded
       * Description: 
        *            This function will wait for a pre-defined time till page is loaded completely
        * Parameters: 
		*	1.	sDriver – variable name used for driver 
		*	2.	iTimeOut – variable for pre-defined time, function will wait for
       * Created By: Darwin Bhandari
       * Created Date: 13-08-2014
       * */

  	public void waitTillPageLoaded(int iTimeOut) {
                ExpectedCondition<Boolean> expectation = new
                     ExpectedCondition<Boolean>(){     
              public Boolean  apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
               }
             };
             FluentWait<WebDriver> wait = new WebDriverWait(driver, iTimeOut);
             try {
                   wait.until(expectation);
             } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
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

	
/* Method Name: selectItemFromWeblist
       * Description: 
        *            This method will select the value from weblist.
        * Parameters: 
        *            1. WebElement object identifier  - Get the locator value.
                     2. TextValue  - to select particular value from weblist
       * Created By: Sunny Jain
       * Created Date: 12-08-2014
       * */

public static String selectItemFromWeblist(By ByValue,String textValue) {
		try{
			   
		    WebElement element = driver.findElement(ByValue);	
		    Select selectElement = new Select(element);
		    selectElement.selectByVisibleText(textValue);
		    //System.out.println(selectElement.getFirstSelectedOption().getText());
		    return selectElement.getFirstSelectedOption().getText();
		  } catch(Exception e) {
			  System.out.println("Exception - > " + e.toString());
			  return e.getMessage();   
		  }
		
	} 

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
		
		try {
			 WebElement element = driver.findElement(ByValue);
			 Select selectElement = new Select(element);
			 List <WebElement> theseOptions = selectElement.getOptions();
			 int i = selectElement.getOptions().size();
		     
	         for(int k = 1; k<i; k++) {
	        	 webList.add(theseOptions.get(k).getText());
		     }      
	         return  webList;
	  } 
	  catch(Exception e) {
		  System.out.println("Exception - > " + e.toString());
		  webList= null;
		  return  webList;
		   
	  }
}


public static String sortAlphabetically(Boolean ascending, String listDataSplittedBySpace) {
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
 
 
public static boolean webEdit(WebElement element,String text){
    String editBoxText  = "" ;
    try{
        element.sendKeys(text);
		editBoxText = element.getText();
		Assert.assertEquals(editBoxText, text);

    }catch(AssertionError ae) {
         LoggerInstance.logger.info("failed to insert value in TextBox "+ ae );
         return false; 
    }
    catch (Exception e) {
         LoggerInstance.logger.info("failed to insert value in TextBox  "+e);
         return false;
    }
    
    return true; 
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

public static void checkingCheckbox(WebElement element)
{  
      
      try
      {
		boolean checkstatus;  
		checkstatus=element.isSelected();  
		if (checkstatus==true){  
		      LoggerInstance.logger.info("Checkbox is already checked");
		   
		}  
		else {  
		   element.click();  
		   LoggerInstance.logger.info("Checked the checkbox");
		}  
	} catch(Exception e) {
		   LoggerInstance.logger.info("Checked the checkbox" + e);
		}
}


public void unCheckingCheckbox(WebElement element) {  
    try
    {
		boolean checkstatus;  
		checkstatus=element.isSelected();  
		if (checkstatus==true){  
		    element.click();  
		    LoggerInstance.logger.info("Checkbox is unchecked");    
		}  
		else  
		{  
		    LoggerInstance.logger.info("Checkbox is already unchecked");
		}  
    } catch(Exception e) {
          LoggerInstance.logger.info("Checked the checkbox");
    }
}




public  static void  verifytextWebelement(WebElement element ,String text)

{
	try
	{
		String stringverify=element.getText();
	
		//Assert.assertEquals(text, stringverify);
	}catch(Exception e)
	{
		System.out.println("the element is not present" +e);
	}
}


@SuppressWarnings("finally")
public static boolean isTextPresent(String txtValue) {
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

/* Method Name: clickMenuItem
 * Description: 
 * 		This function will click on Sub menu item of the main link
 * Parameters: Function accepts 3 parameters
 * 		1. WebDriver Object- Page on which the menu exists
 * 		2. mainLink: WebElement- This is the main menu link of Web Element type
 * 		3. subLink: WebElemet- This is the link that exists under the main menu 
 * Created By: Bal Govind
 * Created Date: 08-08-2014
 * */

public void clickMenuItem(WebElement mainLink, WebElement subLink) {
	try {
		System.out.println("click menu");	
		Actions actions = new Actions(driver);
			
			if(mainLink !=null && mainLink.isDisplayed()) {
				actions.moveToElement(mainLink).build().perform();
				Thread.sleep(3000);
				
				if(subLink !=null && subLink.isDisplayed()) {
					actions.moveToElement(subLink).build().perform();
					actions.moveToElement(subLink).click().build().perform();
				} else {
					System.out.println("Sublink not found");
				}
			}
    } catch (Exception e) {
    	System.out.println(e.getMessage());
    }
}

/* Method Name: webPageName
 * Description: 
 * 		This method will return the WebPage name i.e. title
 * Parameters: 
 * 		1. WebDriver Object- Page for which we need the name/title
 * Created By: Bal Govind
 * Created Date: 08-08-2014
 * */

	public String webPageName() {
		String pageTitle;
		try {
			pageTitle = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pageTitle = e.getMessage();
		}
		return pageTitle;
	}
	
	/* Method Name: scrollPage
	 * Description: 
	 * 		It will scroll down or scroll up the page according to the parameter
	 * Parameters: Function accepts 3 parameters
	 * 		1. WebDriver Object- Page which needs to scroll
	 * 		2. scrollCase- as a String; Accepted values are "UP" and "DOWN"
	 * 		3. pixelToScroll-  as an Integer; Pixels to scroll the web page up/down 
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */
	
	public void scrollPage(String scrollCase, int pixelToScroll) {
		try {
			
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				
				switch(scrollCase) {
				case "DOWN":
					jsExecutor.executeScript("scrollBy(0," + pixelToScroll + ")");
					break;
					
				case "UP":
						jsExecutor.executeScript("scrollBy(0," + -pixelToScroll + ")");
						break;
				}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
	}
	
	/* Method Name: verifyLogo
	 * Description: 
	 * 		It will verify the logo of application
	 * Parameters: Function accepts 3 parameters
	 * 		1. byVal- this is of By type
	 * 		2. dynamicLogoPath- String: This is the path of logo capture at runtime
	 * 		3. staticLogoPath-  String: This is the path of logo with which we need to compare 
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */
	
	public boolean verifyLogo(By byValLogo, String dynamicLogoPath, String staticLogoPath) throws IOException {
		WebElement appLogo = driver.findElement(byValLogo);
		String ul =appLogo.getAttribute("src");
		URL url = new URL(ul);
		BufferedImage bufferedImage = ImageIO.read(url);
		ImageIO.write(bufferedImage, "jpg", new File(dynamicLogoPath));
		
		Image imgStaticLogo = Toolkit.getDefaultToolkit().getImage(staticLogoPath);
		Image imgDownloadedLogo = Toolkit.getDefaultToolkit().getImage(dynamicLogoPath);
		
		try {
				PixelGrabber grab11 = new PixelGrabber(imgStaticLogo, 0, 0, -1, -1, false);
				PixelGrabber grab21 = new PixelGrabber(imgDownloadedLogo, 0, 0, -1, -1, false);
						
				int[] array1= null;
		
			    if (grab11.grabPixels()) {
			     int widthPic1 = grab11.getWidth();
			     int heightPic1 = grab11.getHeight();
			     array1= new int[widthPic1 * heightPic1];
			     array1= (int[]) grab11.getPixels();
			    }
		
			    int[] array2 = null;
		
			    if (grab21.grabPixels()) {
			     int widthPic2 = grab21.getWidth();
			     int heightPic2 = grab21.getHeight();
			     array2 = new int[widthPic2 * heightPic2];
			     array2 = (int[]) grab21.getPixels();
			    }
			    System.out.println((java.util.Arrays.equals(array1, array2 ) ? "Pixels equal: Equal" : "Pixels equal: Not Equal"));
			    
			    return (java.util.Arrays.equals(array1, array2) ? true : false);
			    
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return false;
					
				}
		}
	
	public static void verifyValueOrText(Object expected, Object actual) {
		try {
			assertEquals(expected, actual);
			System.out.println(expected + " is  equal to " + actual);
		} catch (Error e) {
			System.out.println(expected + " is not equal to " + actual);
		}
	}
	
	public static String getCalendarCurrentMonthAndYear() {
		String currentMonthAndYear = "";
		try {
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
			Calendar cal = Calendar.getInstance();
			String month = monthName[cal.get(Calendar.MONTH)];
			String year = cal.get(Calendar.YEAR) + "";
			currentMonthAndYear = month + " " + year;
		} catch (Error e) {
		}
		return currentMonthAndYear;
	}
	
	public static String getrgbaColor(WebElement divColorWebElement) {
		try {
			String text = divColorWebElement.getCssValue("background-color").toString();
			// Split css value of rgb
			String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
			int number1 = Integer.parseInt(numbers[0]);
			numbers[1] = numbers[1].trim();
			int number2 = Integer.parseInt(numbers[1]);
			numbers[2] = numbers[2].trim();
			int number3 = Integer.parseInt(numbers[2]);
			String hex = String.format("#%02X%02X%02X", number1, number2, number3);
			return hex;
		} catch (Exception e) {
			System.out.println("Exception Occurred --> " + e.getMessage());
			return "";
		}
	}
	
	public static int getMonthIntValue(String month) {
		int monthIndex = 0;
		try {
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
			for (String string : monthName) {
				monthIndex++;
				if (string.equals(month)) {
					return monthIndex;
				}
			}
		} catch (Error e) {
			e.printStackTrace();
		}
		return monthIndex;
	}
}