package soundarya;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vTigerObjjectRepository.CreateOrgnisationNewPage;
import vTigerObjjectRepository.HomePage;
import vTigerObjjectRepository.LoginPage;
import vTigerObjjectRepository.OrganisationInfoPage;
import vTigerObjjectRepository.OrganisationMemberPage;
import vTigerObjjectRepository.OrganisationPage;
import vtigergenericUtilities.BaseClass;
import vtigergenericUtilities.ExcelUtility;
import vtigergenericUtilities.JavaFileutility;
import vtigergenericUtilities.WebDriverutils;

public class TC_05CreateOrganisationWithType extends BaseClass {
	public void createOrWithType() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
	LoginPage lp=new LoginPage(driver);
	OrganisationPage op=new OrganisationPage(driver);

	op.getOrganisationLoolUpIMg().click();
	CreateOrgnisationNewPage cnew= new CreateOrgnisationNewPage(driver);

	ExcelUtility eutil=new ExcelUtility();
	JavaFileutility jutil=new JavaFileutility();
	String ORGNAME=eutil.fetchSingledata("testCases", 16, 3)+jutil.random();
	System.out.println(ORGNAME);
	String TYPE=eutil.fetchSingledata("testCases", 16, 4);
	cnew.getOrganisationTextBox().sendKeys(ORGNAME);
	WebDriverutils wutil=new WebDriverutils();
	WebElement ele=driver.findElement(By.name("accounttype"));
	wutil.handleDropDown(ele, TYPE);
	}
}
	

	
	