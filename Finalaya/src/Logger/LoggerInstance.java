package Logger;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerInstance {
	
	public static Logger logger;
	File directory = new File ("");
	String absolutepath	=	directory.getAbsolutePath();
	//This is to get location for creating log file. This value is comming from build.xml 
	String str_logFilePath = absolutepath+File.separator+"log";
	
	
	public LoggerInstance() throws IOException
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		String current_dateTime = dateFormat.format(date);
		System.out.println(current_dateTime);
		current_dateTime = current_dateTime.replace("-", "_");
		current_dateTime = current_dateTime.replace(" ", "_") ;
		current_dateTime = current_dateTime.replace(":", "_") ;
		
		File f1 = new File(str_logFilePath) ; 
		if(!f1.exists()){
			f1.mkdir();
		}
		//System.out.println("00 " + str_logFilePath);
		
		String str_logFilePath1 = str_logFilePath+File.separator+"AutomationLogFile_"+current_dateTime+".log";
		//System.out.println("11 " + str_logFilePath1);
	
		File f2 =  new File(str_logFilePath1);
		f2.createNewFile();
		
		
	if(logger==null)
		{
		try{
			logger = Logger.getLogger("Finalaya");
			FileAppender apndr = new FileAppender(new PatternLayout("%p %t %c - %m%n"),str_logFilePath1,true);
			//apndr.setAppend(true);
			logger.addAppender(apndr);
		}
		catch(Exception e)
		{
			System.out.println("Log file is not initialized");
		}
		}
	}
}