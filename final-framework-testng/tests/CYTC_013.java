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
import com.training.pom.LoginPOM;
import com.training.pom.memberHomePOM;
import com.training.pom.memberLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_013
{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	//private memberHomePOM memberPOM;
	private memberLoginPOM memberLogin;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		
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
		memberLogin.searchMember("akshay");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("akshay");
		//driver.findElement(By.xpath("//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		memberLogin.manageLogin();
		Thread.sleep(3000);
		memberLogin.newPassword("9671222686");
		memberLogin.newConfPass("9671222686");
		memberLogin.forceTick();
		Thread.sleep(3000);
		memberLogin.submitReset();
		Alert alert1=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert1.accept();
		Alert alert2=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert1.accept();
		memberLogin.backButton();
		driver.findElement(By.xpath("//input[@id='modifyButton']")).click();
		memberLogin.subButton();
		Alert alert3=driver.switchTo().alert();
		//String alrt=driver.switchTo().alert().getText();
		//System.out.println(alrt);
		alert1.accept();
		String expected="Profile of AKSHAY MALHOTRA";
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Profile of AKSHAY MALHOTRA')]")).getText();
		Assert.assertEquals(actual, expected);
		
		
		
		Thread.sleep(3000);
		//String expected=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		//String actual="Change my login password";
		//Assert.assertEquals(actual, expected);
		//Thread.sleep(3000);
		screenShot.captureScreenShot("First");
	}
}