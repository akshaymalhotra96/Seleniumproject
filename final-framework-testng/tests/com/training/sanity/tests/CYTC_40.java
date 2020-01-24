package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Ct_40POM;
import com.training.pom.LoginPOM;
import com.training.pom.memberHomePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_40 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private memberHomePOM memberPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Ct_40POM messagePOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		memberPOM=new memberHomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		messagePOM=new Ct_40POM(driver);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException  {
		loginPOM.sendUserName("admin");
		messagePOM.password();
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);
		messagePOM.message();
		Thread.sleep(3000);
		messagePOM.clickmesssage();
		Thread.sleep(3000);
		messagePOM.category();
		Thread.sleep(3000);
		messagePOM.newclick();
		Thread.sleep(3000);
		messagePOM.inputMessage("aksh");
		//messagePOM.inputmemlog("AKSHAY MALHOTRA");
		Thread.sleep(3000);
		messagePOM.inputSubject("hello");
		Thread.sleep(3000);
		messagePOM.inputDes("Welcome");
		messagePOM.clickDes();
		Alert alert1=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert1.accept();
		Thread.sleep(3000);
		messagePOM.clickLogout();
		Alert alert2=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert2.accept();
		loginPOM.sendUserName("akshay");
		messagePOM.password();
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		messagePOM.clickPersonal();
		Thread.sleep(3000);
		messagePOM.clickms();
		
		messagePOM.clickmessagelink();
		
		String expected="Inbox";
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Inbox')]")).getText();
		Assert.assertEquals(actual, expected);
}
}