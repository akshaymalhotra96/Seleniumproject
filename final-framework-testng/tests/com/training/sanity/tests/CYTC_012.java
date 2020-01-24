package com.training.sanity.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordChangePOM;
import com.training.pom.memberHomePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_012 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private memberHomePOM memberPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
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
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException  {
		loginPOM.sendUserName("akshay");
		driver.findElement(By.xpath("//input[9]")).click();
		driver.findElement(By.xpath("//input[6]")).click();
		driver.findElement(By.xpath("//input[7]")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//input[6]")).click();
		driver.findElement(By.xpath("//input[8]")).click();
		driver.findElement(By.xpath("//input[6]")).click();
		loginPOM.clickLoginBtn(); 
		memberPOM.logout();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		String expected=driver.findElement(By.xpath("//div[contains(text(),'Login')]")).getText();
		String actual="Login";
		Assert.assertEquals(actual, expected);
		//Thread.sleep(3000);
		screenShot.captureScreenShot();
		
	}
}
