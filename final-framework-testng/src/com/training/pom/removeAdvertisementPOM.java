package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class removeAdvertisementPOM 
{
	private WebDriver driver; 
	
	 public removeAdvertisementPOM(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy(xpath="//body[@class='main']//tr//tr[2]//td[6]//img[2]")
		private WebElement removeMember;
	 
	 public void remove() 
		{
			//this.memberSearch.clear();
			this.removeMember.click();
		}
}
