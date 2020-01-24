package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class memberLoginPOM 
{
private WebDriver driver; 
	
	 public memberLoginPOM(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement memberSearch;
	
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement manageSearch;
	
	@FindBy(xpath="//input[@name='newPassword']")
	private WebElement newPassword;
	
	@FindBy(xpath="//input[@name='newPasswordConfirmation']")
	private WebElement newCnfPassword;
	
	@FindBy(xpath="//input[@name='forceChange']")
	private WebElement tick;
	
	@FindBy(xpath="//input[@id='resetAndSendButton']")
	private WebElement submitreset;
	
	@FindBy(xpath="//input[@id='backButton']")
	private WebElement backSubmit;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement subButt;
	
	public void searchMember(String userName) {
		this.memberSearch.clear();
		this.memberSearch.sendKeys(userName);
	}
	
	public void manageLogin() {
		//this.memberSearch.clear();
		this.manageSearch.click();
	}
	
	public void newPassword(String userName) {
		//this.memberSearch.clear();
		this.newPassword.sendKeys(userName);
	}
	
	public void newConfPass(String userName) {
		//this.memberSearch.clear();
		this.newCnfPassword.sendKeys(userName);
	}
	
	public void forceTick() {
		//this.memberSearch.clear();
		this.tick.click();
	}
	
	public void submitReset() {
		//this.memberSearch.clear();
		this.submitreset.click();
	}
	
	public void backButton() {
		//this.memberSearch.clear();
		this.backSubmit.click();
	}
	
	public void subButton() {
		//this.memberSearch.clear();
		this.subButt.click();
	}
	
}
