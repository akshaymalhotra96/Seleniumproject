package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ct_40POM 
{
private WebDriver driver; 
	
	public Ct_40POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Messages')]")
	private WebElement mess; 
	
	
	@FindBy(id="cyclosPassword")
	private WebElement pass; 
	
	@FindBy(xpath="//li[@id='submenu8.0']")
	private WebElement clickmess; 
	
	@FindBy(xpath="//input[@id='newButton']")
	private WebElement newclick; 
	
	@FindBy(id="memberUsername")
	private WebElement inputMember; 
	
	@FindBy(xpath="//option[contains(text(),'Loan')]")
	private WebElement cat; 
	
	@FindBy(xpath="//input[@id='subjectText']")
	private WebElement sub; 
	
	@FindBy(xpath="//td[@id='cke_contents_bodyText']//iframe")
	private WebElement des; 
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submitdes; 
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout; 
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement persnal;
	
	@FindBy(xpath="//span[contains(text(),'Messages')]")
	private WebElement persnalmess;
	
	@FindBy(xpath="//a[contains(text(),'hello')]")
	private WebElement messagelink;
	
	public void password() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		
	}
	
	public void message() throws InterruptedException 
	{
		this.mess.click(); 
		
	}
	
	public void clickmesssage() throws InterruptedException 
	{
		this.clickmess.click();
		
	}
	
	public void newclick() throws InterruptedException 
	{
		this.newclick.click(); 
		
	}
	public void category()
	{
		this.cat.click();
		
	}
	
	public void inputmemlog(String str) throws InterruptedException 
	{
		this.newclick.click(); 
		
	}
	
	public void inputMessage(String str)
	{
		this.inputMember.sendKeys(str);
		
	}
	
	public void inputSubject(String str)
	{
		this.sub.sendKeys(str);
		
	}
	
	public void clickDes()
	{
		this.submitdes.click();
		
	}
	
	public void clickLogout()
	{
		this.logout.click();
		
	}
	
	public void inputDes(String str)
	{
		this.des.sendKeys(str);
		
	}
	

	public void clickPersonal()
	{
		this.persnal.click();;
		
	}
	

	public void clickms()
	{
		this.persnalmess.click();
		
	}
	
	public void clickmessagelink()
	{
		this.messagelink.click();
		
	}
}
