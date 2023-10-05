package vtigergenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjjectRepository.LoginPage;

public class BaseClass {
public static WebDriver driver=null;
public static WebDriver sdriver;


PropertyFileUtility putil=new PropertyFileUtility();
String BROWSER=putil.readDataFromPropertyFile("browser");

String USERAME=putil.readDataFromPropertyFile("username");
String PASSWORD =putil.readDataFromPropertyFile("password");

	@BeforeSuite
	public void bs()
	{
		System.out.println("------data base connected---");
	}
	@BeforeClass
	public void openApp()
	{
	
if(BROWSER.contains("Chrome"))
{
	WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
String URL=putil.readDataFromPropertyFile("url");
driver.get(URL);
sdriver=driver;

System.out.println("-------browser lauched  app opened--------");
}
	}
	
	@BeforeMethod
	public void login() throws Throwable
	{
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(USERAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		WebDriverutils wutil=new WebDriverutils();
	//	wutil.implicitwait(driver, 3000);
		Thread.sleep(3000);
		System.out.println("----------login done   sucessfully----------");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("-----logout-----------done------");
	}
	@AfterClass
	public void closeApp()
	{
		System.out.println("-----app closed------");
	}
	
	@AfterSuite
	public void as()
	{
		
	}
	
}
