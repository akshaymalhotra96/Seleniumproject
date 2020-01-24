package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertisementPOM 
{
	private WebDriver driver; 
	
	 public AdvertisementPOM(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement memberSearch;
	
	@FindBy(xpath="//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement searchAdver;
	
	@FindBy(xpath="//input[@id='newButton']")
	private WebElement newAds;
	
	@FindBy(xpath="//input[@name='ad(title)']")
	private WebElement titleAd;
	
	@FindBy(xpath="//option[contains(text(),'Example ad category')]")
	private WebElement category;
	
	@FindBy(xpath="//input[@name='ad(price)']")
	private WebElement cost;
	
	@FindBy(xpath="//input[@id='notExpirableCheck']")
	private WebElement expirabletick;
	
	@FindBy(xpath="//td[@id='cke_contents_descriptionText']//iframe")
	private WebElement descr;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement submitAdvFinal;
	
	@FindBy(xpath="//input[@id='backButton']")
	private WebElement backButton;
	
	public void memberSear(String userName) 
	{
		//this.memberSearch.clear();
		this.memberSearch.sendKeys(userName);
	}
	
	public void manageAdver()
	{
		//this.memberSearch.clear();
		this.searchAdver.click();
	}
	
	public void newAdver() 
	{
		//this.memberSearch.clear();
		this.newAds.click();
	}
	
	public void title(String title) 
	{
		//this.memberSearch.clear();
		this.titleAd.sendKeys(title);
	}
	
	public void categorySelect() 
	{
		//this.memberSearch.clear();
		this.category.click();
	}
	
	public void price(String title) 
	{
		//this.memberSearch.clear();
		this.cost.sendKeys(title);
	}
	

	public void expirable() 
	{
		//this.memberSearch.clear();
		this.expirabletick.click();
	}
	

	public void description(String des) 
	{
		//this.memberSearch.clear();
		this.descr.sendKeys(des);;
	}
	

	public void sumbitAdver() 
	{
		//this.memberSearch.clear();
		this.submitAdvFinal.click();
	}
	
	public void back() 
	{
		//this.memberSearch.clear();
		this.backButton.click();
	}
	
}
