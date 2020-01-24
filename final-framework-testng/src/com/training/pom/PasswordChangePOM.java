package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordChangePOM 
{
private WebDriver driver; 
	
	public PasswordChangePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Change password')]")
	private WebElement changePassword; 
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement clickPersonal; 
	
	
	@FindBy(name="oldPassword")
	private WebElement enterPre; 
	

	@FindBy(name="newPassword")
	private WebElement enterNew; 
	
	@FindBy(name="newPasswordConfirmation")
	private WebElement enterConfNew; 
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement submitPass; 
	
	public void personal() throws InterruptedException 
	{
		this.clickPersonal.click(); 
		Thread.sleep(3000);
		
	}
	
	public void clickPassBtn() throws InterruptedException 
	{
		this.changePassword.click();
		Thread.sleep(3000);
		
	}
	
	public void enterPrevious(String old) 
	{
		this.enterPre.clear();
		this.enterPre.sendKeys(old);
		
	}
	
	public void enterNew(String newPass) 
	{
		this.enterNew.sendKeys(newPass);
		
	}
	
	public void enterConNew(String newConfm) 
	{
		this.enterConfNew.sendKeys(newConfm);
		
	}
	public void submit()
	{
		this.submitPass.click();
	}
}
