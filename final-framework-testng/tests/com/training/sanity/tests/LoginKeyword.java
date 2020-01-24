package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginKeyword 
{
		private WebDriver driver;
		private String baseUrl;
	//	private LoginPOM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;
	//	private PasswordChangePOM changePassword;
		private Login1POM log;
		

		@BeforeClass
		public static void setUpBeforeClass() throws IOException
		{
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}
		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			//loginPOM = new LoginPOM(driver); 
		//	changePassword=new PasswordChangePOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			log= new Login1POM(driver);
			// open the browser 
			driver.get(baseUrl);
		}
		public void validLoginTest() throws Exception
		{
			 String sPath = "D:\\New java project\\SeleniumProject1\\KeywordDrivenProject\\src\\dataEngine\\DataDriven.xlsx";
			ReadExcel ex=new ReadExcel();
			ex.setExcelFile(sPath, "Test Steps");
			
			 for (int iRow=2;iRow<=6;iRow++){
			     //Storing the value of excel cell in sActionKeyword string variable
			     String sActionKeyword = ex.getCellData(iRow, 3);
			 
			     //Comparing the value of Excel cell with all the project keywords
			                        //This will execute if the excel cell value is 'openBrowser'
			     //Action Keyword is called here to perform action
			    
			     if(sActionKeyword.equals("Input_password")){
			     log.Input_password();}
			     else if(sActionKeyword.equals("click_login")){
			     log.click_login();}
			     }
			
	}
}

