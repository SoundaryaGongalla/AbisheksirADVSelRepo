package vtigergenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverutils  {
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This ,method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/**
	 * This  method will handle dropdown using visibletext
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}

/**
 * this method will scroll up to the web element
 * @param driver
 * @param element
 */
public void scrollACtion(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("arguments[0].ScrollIntoview;",element);

}
	
	
	
	/**
	 * This method will switch to default page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}

	/**
	 * this method will perform move cursor to 
	 * Web element element 
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will perform right click anywhere in the web page
	 * @param driver
	 */
	
	
	public void rightClickMouseOver(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on particular Web element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickMouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method perform right click on webpage
	 * @param driver
	 */
	
public void doubleclick(WebDriver driver) {
	
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
	
/**
 * this method will perform double click on WebElement
 * @param driver
 * @param element
 */
public void doubleclick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}

/**
 * this method will perform dragand drop  frm src to dest
 * @param driver
 * @param src
 * @param dest
 */

public void draganddrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, dest).perform();
}

/**
 * this method will move the cursor  offset and click
 * @param driver
 * @param x
 * @param y
 */
public void draganddrop(WebDriver driver,WebElement element,int x,int y)
{
	Actions act=new Actions(driver);
	act.dragAndDropBy(element, x, y).perform();
}

	// screenshot
	
	public void takesSceenShot(WebDriver driver,String filepath) throws IOException

	{
TakesScreenshot sh=(TakesScreenshot)driver; 
File src=sh.getScreenshotAs(OutputType.FILE);
File dest=new File(filepath);

Files.copy(src, dest);	
	}

		
	public void handletabs(WebDriver driver,String  title)
	{
	
		
		Set<String> allids=driver.getWindowHandles();
		for(String id:allids)
		{
		String  titleid=	driver.switchTo().window(id).getTitle();
			
		if(titleid.contains(title))
		{
			break;
		}
		
		
		}
	}
	public void switchToDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
//  alert pop up 4 methods
public void alertPOPupAccept(WebDriver driver)
{
	Alert alt=driver.switchTo().alert();
	alt.accept();
	
}
public void alertPOPup(WebDriver driver)
{
	Alert alt=driver.switchTo().alert();
	alt.dismiss();


}
public void alertPOPupGetText(WebDriver driver)
{
	Alert alt=driver.switchTo().alert();
	alt.getText();
	
}	
public void alertPOPupSendData(WebDriver driver,String data)
{
	Alert alt=driver.switchTo().alert();
	alt.sendKeys(data);
	
}	
	
// frame 4 methods
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	
	public void implicitwait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public void explicit(WebDriver driver,int t,String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(t));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
		
	}
	
	
}

