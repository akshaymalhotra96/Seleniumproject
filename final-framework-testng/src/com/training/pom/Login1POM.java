package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class  Login1POM
{
	private static WebDriver driver; 
	
	public Login1POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public static void openBrowser()
	{ 
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares Required For Testing Batch\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	 public static void Input_Username()
	 {
		 driver.findElement(By.id("cyclosUsername")).sendKeys("akshay");
	 }
	 public static void Input_password()
	 {
		 driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
	 }
	 public static void click_login()
	 {
		 driver.findElement(By.xpath("//div[@id='virtualKeyboard']//div//input[@class='button']")).click();
		 }
}
