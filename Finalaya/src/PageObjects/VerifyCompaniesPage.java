package PageObjects;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class VerifyCompaniesPage {	
	
	private WebDriver driver;
	
	 private final String id_InforMationTab = "liViewCompanyResult";
	 private final String id_DocumentTab ="ctl00_BodyCPH_lnkViewDocumentResult";
	 private final String css_InforMationTabclick="#ctl00_BodyCPH_lnkViewCompanyResult";
     private final String css_toolTipTextIndustryName="#lblIndustry";
     private final String id_Paginationval="ctl00_BodyCPH_Pagination_pages";
     private final String Xpath_Paginationflicker="//*[@id='pagination-flickr']/li[1]";
     private final String css_PaginationflickerNextBtn="#pagination-flickr > li.next > a";
     private final String css_PaginationflickerPreviousBtn="#pagination-flickr > li.previous > a";
     private final String xpath_CompaniesTab="//*[@id='menu-wrapper']/ul/li[2]/a";
     private final String xpath_RowTextVal="//table[@id='tblStockSearchResult']/tbody/tr/td[1]";
     private final String css_RowTextVal ="#ctl00_BodyCPH_rpStockSearchResult_ctl00_lb_Company";
     private final String xpath_HeaderTable="//table[@id='tblStockSearchResult']/thead";
     private final String xpath_ColorimageNse="//table[@id='tblStockSearchResult']/tbody/tr/td[3]//img";
     private final String xpath_ColorTextNse="//table[@id='tblStockSearchResult']/tbody/tr/td[3]//span";
     private final String xpath_ColorimageBse="//table[@id='tblStockSearchResult']/tbody/tr/td[4]//img";
     private final String xpath_ColorTextBse="//table[@id='tblStockSearchResult']/tbody/tr/td[4]//span";
     private final String xpath_leftimageBegng="//table[@id='tblStockSearchResult']/tbody/tr/td[1]//img[1]";
     private final String xpath_rightimagetext="//table[@id='tblStockSearchResult']/tbody/tr/td[1]//img[2]";
     private final String id_PaginationDisplayed="ctl00_BodyCPH_Pagination_pages";
     private final String xpath_TableColumnVal="//table[@id='tblStockSearchResult']/tbody/tr/td[1]";
     private final String xpath_TableColumnVal2="//table[@id='tblStockSearchResult']/tbody/tr/td[2]";
     
    
    
     
  
     @FindBy(css=css_InforMationTabclick)
	    public WebElement we_InforMationTabclick;
     @FindBy(id=id_InforMationTab)
	    public WebElement we_InforMationTab;
	 @FindBy(id=id_DocumentTab)
	 public WebElement we_DocumentTab;
     @FindBy(xpath=xpath_CompaniesTab)
	 public WebElement we_CompaniesTab;  
	 @FindBy(xpath=xpath_RowTextVal)
	 public List<WebElement> we_RowTextVal;
	 @FindBy(xpath=xpath_HeaderTable)
	 List<WebElement> we_headertable;
	 @FindBy(xpath=xpath_ColorimageNse)
	public List<WebElement> we_ColorImageArrowNse;
	@FindBy(xpath=xpath_ColorTextNse)
     List<WebElement> we_ColorTextNse;
	@FindBy(xpath=xpath_ColorimageBse)
	public List<WebElement> we_ColorImageArrowBse;
    @FindBy(xpath=xpath_ColorTextBse)
    List<WebElement> we_ColorTextBse;
    @FindBy(xpath=xpath_leftimageBegng)
    List<WebElement> we_LeftImgBegng;
    @FindBy(xpath=xpath_rightimagetext)
    List<WebElement> we_RigtImg;
    @FindBy(css=css_RowTextVal)
    public WebElement we_desc;
    @FindBy(id=id_Paginationval)
    public List<WebElement> we_Paginationval;
    
    @FindBy(xpath=Xpath_Paginationflicker)
    public List<WebElement> we_Paginationflicker;
    
    @FindBy(css=css_PaginationflickerNextBtn)
    public WebElement we_PaginationflickerNextBtn;
    
    @FindBy(css=css_PaginationflickerPreviousBtn)
    public WebElement we_PaginationflickerPreviousBtn;
    
    @FindBy(id=id_PaginationDisplayed)
    WebElement we_PaginationIsdisplayed;
    
    @FindBy(xpath=xpath_TableColumnVal)
    List<WebElement> we_ToolTipColumnval;
    
    @FindBy(xpath=xpath_TableColumnVal2)
    List<WebElement> we_ToolTipColumnval2;
    
    @FindBy(css=css_toolTipTextIndustryName)
    WebElement we_toolTipTextIndustryName;
    
    
   

    


		// This is a constructor, as every page need a base driver to find web elements
		public VerifyCompaniesPage(WebDriver driver) {
			this.driver = driver;
		}
	 
	 
	 
	 
	 

	    /* Method Name: 
	     * Description: Function to click on Companies Tab
	      *            This method will click the companies tab.
	      * 
	     * Created By: Mohd Suhail
	     * Created Date: 19-08-2014
	     * */
	
		public void clickOnCompaniesTab() {
			try {
				LoggerInstance.logger.info("click on Companies Tab");
				FunctionLibrary.clickWebLink(we_CompaniesTab)    ;
				
				
			//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
			} catch (Exception e) {
				LoggerInstance.logger.info("Not able to click on Companies Tab");
			}
		}
		
		

	    /* Method Name: 
	     * Description: Function to click on InforMationTabclick
	      *            This method will click the InforMationTab.
	      * 
	     * Created By: Mohd Suhail
	     * Created Date: 19-08-2014
	     * */
		
		public void clicktab() throws InterruptedException
		{
			
			
			FunctionLibrary.clickWebLink(we_InforMationTabclick)    ;
			Thread.sleep(10000);
			
		}
		
		
		
	

		
		
	
	 
	 
	 
	 // Function to Verify Information Tab Displayed
		
		
		 /* Method Name: 
	     * Description: Function to Verify Information Tab Displayed
	      *            This method will Verify Information Tab Displayed.
	      * 
	     * Created By: Mohd Suhail
	     * Created Date: 20-08-2014
	     * */


		public Boolean verifyInformationTab(){
			
			
			boolean result= false;
			
			try{
			 result=we_InforMationTab.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Information _Tab is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Information _Tab is not displayed");
				return result;
				}
		}

	 
	 
	 
			
			 /* Method Name: 
		     * Description: Function to Verify Document Tab Displayed
		      *            This method will Verify Document Tab Displayed or not.
		      * 
		     * Created By: Mohd Suhail
		     * Created Date: 20-08-2014
		     * */

	 
		public Boolean verifyDocumentTabIsDisplayed(){
			
		
			boolean result= false;
			
			try{
			 result=we_DocumentTab.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Document_Tab is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Document_Tab is not displayed");
				return result;
				}
		}
		
	
		 /* Method Name: 
	     * Description: Function to Verify Company name in Ascending order
	      *            This method will Verify Company name in Ascending order or not.
	      * 
	     * Created By: Mohd Suhail
	     * Created Date: 20-08-2014
	     * */

public boolean VerifyComanyNameSortedAscending(){
			
	boolean result = false ;
	
	try{
		
		
		List<WebElement> textverifyAscending= we_RowTextVal;
	
	
	 for(int i=0;i<textverifyAscending.size()-1;i++)
	    {
	    	
	    	String Current=textverifyAscending.get(i).getText();
	    	String Next=textverifyAscending.get(i+1).getText();
	    	
	    	if (result=Current.compareToIgnoreCase(Next )< 0){ 
	    		
	    		LoggerInstance.logger.info("Companies Name Is arranged in Ascending Order");
	    		
       }else if(result=Current.compareToIgnoreCase(Next) > 0){ 
    	   LoggerInstance.logger.info("Companies Name Is not arranged in Ascending Order");
    	
       }else { 
    	   LoggerInstance.logger.info("Companies Name are identical");
    	 
       }
	    
	    }
	    }catch (Exception e) 
	{
		LoggerInstance.logger.info("Company Name is not arranged in Ascending Order");
		return result;
}
		
	return result;

	
     
		
}
	


/* Method Name: 
* Description: Function to Verify Company name in Descending order
 *            This method will Verify Company name in Descending order or not.
 * 
* Created By: Mohd Suhail
* Created Date: 20-08-2014
* */
    

public boolean VerifyComanyNameSorteDecendingOrder(){
	
	
boolean result = false ;
	
	try{
	FunctionLibrary.clickWebLink(we_desc);
	
	List<WebElement> textverifyAscending= we_RowTextVal;
	
	 for(int i=0;i<textverifyAscending.size()-1;i++)
	    {
	    	
	    	String Current=textverifyAscending.get(i).getText();
	    	String Next=textverifyAscending.get(i+1).getText();
	    	if (result=Current.compareToIgnoreCase(Next ) >0){ 
	    		LoggerInstance.logger.info("Companies Name Is arranged in decending Order");
       }else if(result=Current.compareToIgnoreCase(Next) < 0){ 
    	   LoggerInstance.logger.info("Companies Name Is not arranged in decending Order");
       }else { 
    	   LoggerInstance.logger.info("Companies Name are identical");
       }
	    }	
	    }catch (Exception e) 
   	{
   		LoggerInstance.logger.info("Company Name is not arranged in Ascending Order");
   		
   }
	    return result;
          
     
		
}
	 


/* Method Name: 
* Description: Function to Verify Table heading CompanyName ,Industry Name
*                            NSE, BSE is displayed
 *            This method will Verify Table heading CompanyName ,Industry Name
 *              NSE, BSE is displayed or not.
 * 
* Created By: Mohd Suhail
* Created Date: 20-08-2014
* */



	 public boolean VerifyComanyTableHeadingIsDisplayed()
	 {	 
		 boolean result = false ;
			
			try{
	 List<WebElement> headerelment=we_headertable;
		 for(int i=0;i<headerelment.size();i++)
		   {
			   
		String HeaderText=	 headerelment.get(i).getText();
		
		if(result=HeaderText.equalsIgnoreCase("Company Name Industry NSE BSE"))
		{
			
			LoggerInstance.logger.info("Companies Column Heading Is Displayed and verified ");
			
		}
		
		else
		{
			
			LoggerInstance.logger.info("Companies Column Heading Is not Displayed and verified");
		}
			   
		   }   
		   }
		 catch (Exception e) 
			{
				LoggerInstance.logger.info("Element is not displayed");
				return result;
		}
				
			return result;
		 
		 
		 
		
		
	 
	 }
	
	
	 
	 /* Method Name: 
	 * Description: Function to Nse value displayed red color has down arrow
	 *               and  value green color in up arrow
	 *                            
	  *            This method will Verify Nse value displayed red color has down arrow
	 *               and  value green color in up arrow or not.
	  * 
	 * Created By: Mohd Suhail
	 * Created Date: 20-08-2014
	 * */
	 
	 public Boolean VerifyNSEArrowColorTextVal()
	 {
	 boolean result = false ;
			
			
	   
		 List<WebElement> colorTextNse=we_ColorTextNse;
		 List<WebElement> colorArrowImage=we_ColorImageArrowNse;
		 for(int i=0;i<colorTextNse.size();i++)
	        {
	          
	                String     colorArrowImagepos=colorArrowImage.get(i).getAttribute("src");
	                String     colorTextNseval=colorTextNse.get(i).getAttribute("style");
	                  try{  
	                if(colorArrowImagepos!=null && colorTextNseval!=null)
	                {
	                     if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
	                     {
	                     	
	                    	 LoggerInstance.logger.info("NSE Data is green in color and image is up arrow");
	             			
	                     }
	                     
	                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
	                    		 {
	                    	 LoggerInstance.logger.info("NSE Data is red in color and image is down arrow");
	                     }   
	                     
	                     
	                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
	            		 {
	                    	 LoggerInstance.logger.info("NSE Data is green in color and image is down arrow");
	             } 
	                     else if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
	            		 {
	                    	 LoggerInstance.logger.info("NSE Data is red in color and image is up arrow");
	             } 
	                   
	              
	                     
	              }
	              
	             
	                  }catch(Exception e)
	                  { 
	                	  
	                	  LoggerInstance.logger.info("Nse column does not contain ant data");
	                  
	                  }
	                 
	        }
		return result; 
	        
	       }	
	 
	 
	 /* Method Name: 
		 * Description: Function to BSE value displayed red color has down arrow
		 *               and  value green color in up arrow
		 *                            
		  *            This method will Verify BSE value displayed red color has down arrow
		 *               and  value green color in up arrow or not.
		  * 
		 * Created By: Mohd Suhail
		 * Created Date: 20-08-2014
		 * */
		 public Boolean VerifyBSEArrowColorTextVal()
		   {
			 
			 
			 boolean result = false ;
			 List<WebElement> colorTextBse=we_ColorTextBse;
			 List<WebElement> colorArrowImage=we_ColorImageArrowBse;
			 for(int i=0;i<colorTextBse.size();i++)
		        {
		          
		                String colorArrowImagepos=colorArrowImage.get(i).getAttribute("src");
		                String colorTextNseval=colorTextBse.get(i).getAttribute("style");
		                  try{  
		                if(colorArrowImagepos!=null && colorTextNseval!=null)
		                {
		                     if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
		                     {
		                     	
		                    	 LoggerInstance.logger.info("Bse Data is green in color and image is up arrow");
		                     }
		                     
		                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
		                    		 {
		                    	 LoggerInstance.logger.info("Bse Data is red in color and image is down arrow");
		                     }   
		                     
		                     
		                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
		            		 {
		                    	 LoggerInstance.logger.info("Bse Data is green in color and image is down arrow");
		             } 
		                     else if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
		            		 {
		                    	 LoggerInstance.logger.info("Bse Data is red in color and image is up arrow");
		             } 
		                   
		              
		                     
		              }
		              
		             
		                  }catch(Exception e)
		                  {
		                	  LoggerInstance.logger.info("BSE column does not contain ant data");
		                  
		                  }
		              
		        }
			return result;
		        
		       }	
	 
	 
		 
		 /* Method Name: 
			 * Description: Function to Verify Image is displayed to left
			 *               of company name
			 *                            
			  *            This method will Verify Image is displayed to left
			 *               of company name or not.
			  * 
			 * Created By: Mohd Suhail
			 * Created Date: 22-08-2014
			 * */
		 
	 public Boolean verifyImageLeftTextIsDisplayed()
	 {
		 boolean result = false ;
		 List<WebElement> leftimage=we_LeftImgBegng;
		    for(int i=0;i<leftimage.size();i++)
		    {
		    	
		    	
		    	try
		    {
		      
		            String     colortextaleftimagesrcval=leftimage.get(i).getAttribute("src");
		           
		            if(result!=colortextaleftimagesrcval.contains("star-4.png")|| result!=colortextaleftimagesrcval.contains("CID") || result!=colortextaleftimagesrcval.contains("NoSparkline_N.jpg"))
		            {
		            	
		            	 LoggerInstance.logger.info("Image is displayed in left of text");
		            	
		            }
		            else
		            {
		            	 LoggerInstance.logger.info("Image is  not displayed in left of text");
		            }
		            }catch (Exception e) {
		            	 LoggerInstance.logger.info("Image is   null");
		            	 
					}
		            
		    }
			return result;
		            
		            
	  
		    }
	 
	 
	 
	 /* Method Name: 
		 * Description: Function to Verify Image is displayed to Right
		 *               of company name
		 *                            
		  *            This method will Verify Image is displayed to Right
		 *               of company name or not.
		  * 
		 * Created By: Mohd Suhail
		 * Created Date: 22-08-2014
		 * */
		    
		    public Boolean verifyImageRightTextIsDisplayed()
			 {
		    	boolean result = false ;
				 List<WebElement> Rightimage=we_RigtImg;
				    for(int i=0;i<Rightimage.size();i++)
				    {
				    	
				    	
				    	try
				    {
				      
				            String     colortextaleftimagesrcval=Rightimage.get(i).getAttribute("src");
				           
				            if(result!=colortextaleftimagesrcval.contains("II_Trans_Graph.GIF") )
				            {
				            	
				            	 LoggerInstance.logger.info("Image is displayed in Right of text");
				            }
				            else
				            {
				            	 LoggerInstance.logger.info("Image is  not displayed in Right of text");
				            }
				            }catch (Exception e) {
				            	 LoggerInstance.logger.info("Image is   null");
							}
				            
				    	
				            
				            
				    
				    }
					return result;
	 }
	 
	 
		    
		    
		    
		    /* Method Name: 
			 * Description: Function to Verify Pagination is displayed 
			 *                            
			  *            This method will Verify Pagination is displayed 
			 *               or not.
			  * 
			 * Created By: Mohd Suhail
			 * Created Date: 22-08-2014
			 * */
		    
		public Boolean verifyPaginationdisplayed()
		{
			boolean result= false;
			try{
			 result=we_PaginationIsdisplayed.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Pagination  is displayed");
			 return result;
				}
			catch (Exception e) 
				{
				LoggerInstance.logger.info("Pagination is not displayed");
				return result;
				}
		}
		
		

	    /* Method Name: 
		 * Description: Function to Verify Next Page then results of next page is displayed 
		 *               and when user click on Previous page then
		 *               results of Previous page is displayed
		  *            
		  * 
		 * Created By: Mohd Suhail
		 * Created Date: 23-08-2014
		 * */
		public Boolean verifyClickingNextPreviousDislayedPage()
		{
			
			boolean result= false;
			try{
			List<WebElement> elmnt=we_Paginationval;
			List<WebElement> elmnt1=we_Paginationflicker;
			
			for(int i=0;i<elmnt.size();i++)
			{
				
				
				String Previousbtn=elmnt1.get(i).getAttribute("class");
				
				if(result=Previousbtn.equalsIgnoreCase("previous-off"))
				{
					LoggerInstance.logger.info("Page One  is displayed");
					
					we_PaginationflickerNextBtn.click();
					LoggerInstance.logger.info("Clicking On Next Button");
					LoggerInstance.logger.info("Page two is  displayed");
					WebElement PreviousBtnEnabled=we_PaginationflickerPreviousBtn;
					if(result=PreviousBtnEnabled.isEnabled())
					{
						PreviousBtnEnabled.click();
						LoggerInstance.logger.info("Clicking on Previous Button is  displayed");
						LoggerInstance.logger.info("Page one is  displayed");
						
					}
				}
				}
			}catch(Exception e)
			{
				LoggerInstance.logger.info("Previous Button and Next Button is not enabled");
			}
			return result;
			}
			
			
		
		/* Method Name: 
		 * Description: Function to Verify Company Name  ToolTip Industry Value 
		 *              and Industry  column value is matching . 
		 *                            
		  *            This Function to Verify Company Name  ToolTip Industry Value 
		 *              and Industry  column value is matching  or not.
		  * 
		 * Created By: Mohd Suhail
		 * Created Date: 23-08-2014
		 * */
		public  boolean VerifyToolTipCompanyValIndustryColumnValMatches() throws InterruptedException
		{
			
			
			boolean result= false;
			try{
			
			List<WebElement>  Companynameval=we_ToolTipColumnval;
            List<WebElement> ColumnIndustryname=we_ToolTipColumnval2;
			for(int i=0;i<Companynameval.size();i++)
			{
			    String text=Companynameval.get(i).getText();
						WebDriverWait wait = new WebDriverWait(driver, 80); 
			

			WebElement cmpnyName = driver.findElement(By.linkText(text));

			Actions act = new Actions(driver);
			 			
			   act.moveToElement(cmpnyName).build().perform(); 
			   			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css_toolTipTextIndustryName))); 
			   WebElement toolTipTextIndustryName  = we_toolTipTextIndustryName; 
			    
			   Thread.sleep(2000); 
			 
			String popmsg1=toolTipTextIndustryName.getText();
			   
			   
			   for(int j=0;j< ColumnIndustryname.size();j++)
			   {
				   String ColumnTextValue=ColumnIndustryname.get(i).getText();
				   if (result=popmsg1.equalsIgnoreCase(ColumnTextValue))
				   {
				   LoggerInstance.logger.info("Tool Tip Text Company Name" +" "+ popmsg1 +" "+ " equals Industry name" +" "+ColumnTextValue);
				   break;
				  
				   }
				   else{
					   LoggerInstance.logger.info("Tool Tip Text Company Name" +" "+popmsg1 +" "+"not equals Industry name"+" " +ColumnTextValue);
			   
					   break;
				   }
			  
			   }
			} }catch (Exception e) {
           	 LoggerInstance.logger.info("Tool tip is not exist");
           	 return result;
			}   
	return result;
			
			
		}






			
		}
			
	
		


	
	 
	 
	 



