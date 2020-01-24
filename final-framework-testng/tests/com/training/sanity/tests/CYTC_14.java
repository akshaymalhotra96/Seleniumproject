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
import com.training.pom.AdvertisementPOM;
import com.training.pom.LoginPOM;
import com.training.pom.memberLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_14 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	//private memberHomePOM memberPOM;
	private memberLoginPOM memberLogin;
	private AdvertisementPOM adverPOM;
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
		memberLogin=new memberLoginPOM(driver);
		adverPOM=new AdvertisementPOM(driver);
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
		loginPOM.sendUserName("admin");
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		adverPOM.memberSear("akshay");
		Thread.sleep(3000);
		adverPOM.manageAdver();
		Thread.sleep(3000);
		adverPOM.newAdver();
		Thread.sleep(3000);
		adverPOM.title("New Offer");
		adverPOM.categorySelect();
		Thread.sleep(3000);
		adverPOM.price("7");
		adverPOM.expirable();
		adverPOM.description("new offer for member");
		Thread.sleep(3000);
		adverPOM.sumbitAdver();
		Thread.sleep(3000);
		Alert alert1=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert1.accept();
		adverPOM.back();
		String actual="Advertisements of AKSHAY MALHOTRA";
		String expected=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
}
}
