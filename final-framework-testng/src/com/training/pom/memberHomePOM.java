package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class memberHomePOM 
{	
private WebDriver driver; 
	
	public memberHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement clickLogout; 
	
	public void logout() throws InterruptedException 
	{
		this.clickLogout.click(); 
		Thread.sleep(3000);
		
	}
	

}
