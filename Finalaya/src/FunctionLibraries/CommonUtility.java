package FunctionLibraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

import Logger.LoggerInstance;


public class CommonUtility {
	
	/* Method Name: getHeaderListOfTable
     * Description: 
      *            function to get all List of the table Header by passing Xpath of the table header to it.
     * Parameters: 
      *            1. xpath of table header and driver
     * Created By: Rohit Miglani
     * Created Date: 08-08-2014
     * */
	  public static List<String> getHeaderListOfTable(WebDriver driver, String xpathOfTableHeader)
	  {
		  	List<String> List_HeaderOfTable = null;
	    	List<WebElement> List_TableHeaderFields=null;
	    	try
	    	{
	    		
	    		List_TableHeaderFields= driver.findElements(By.xpath(xpathOfTableHeader));
	    		int size= List_TableHeaderFields.size();
	    		for (int i=0; i<size; i++)
	    		{
	    			List_HeaderOfTable.add(List_TableHeaderFields.get(i).getText());
	    		}
	    		LoggerInstance.logger.info("Return List");
	    	    return List_HeaderOfTable;
	    	}
	    	
	    	catch (Exception ex)
	    	{
				LoggerInstance.logger.info("Can not able to Return List of table header");
			    return List_HeaderOfTable;
		    }   	
	    	
	 }	//End of Function
	  
	  /* Method Name: getHeaderListOfTable
	     * Description: 
	      *            function to get all value of the table column by passing Xpath of the table and index of that column.
	     * Parameters: 
	      *            1. xpath of table and driver
	      *            2. index of column
	     * Created By: Rohit Miglani
	     * Created Date: 08-11-2014
	     * */
	
	  public static List<String> getListOfElementForColumn(WebDriver driver, String xpathOfTable, Integer indexOfColumn)
	  {
	    	List<String> List_AllRowsForColumn=null;
	    	List<WebElement> List_ColumnOfTable=null;
	    	try
	    	{
	    		String xpathOFColumn=xpathOfTable+"//tr/td["+indexOfColumn+"]";
	    		List_ColumnOfTable= driver.findElements(By.xpath(xpathOFColumn));
	    		int size= List_ColumnOfTable.size();
	    		for (int i=0; i<size; i++)
	    		{
	    		  		List_AllRowsForColumn.add(List_ColumnOfTable.get(i).getText());
		    	}
	    		LoggerInstance.logger.info("Return List of all the rows for particulat column");
	    		return List_AllRowsForColumn;
	    	}
	    	
	    	catch (Exception ex)
	    	{
				LoggerInstance.logger.info("Can not able to Return List of all the rows for particulat column");
			    return List_AllRowsForColumn;
		    }   	
	    	
	 }	//End of Function
	  
	  
}


