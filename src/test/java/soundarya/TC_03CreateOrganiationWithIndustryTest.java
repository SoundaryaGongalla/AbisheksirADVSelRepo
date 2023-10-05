package soundarya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vTigerObjjectRepository.CreateOrgnisationNewPage;
import vTigerObjjectRepository.HomePage;
import vTigerObjjectRepository.LoginPage;
import vTigerObjjectRepository.OrganisationInfoPage;
import vTigerObjjectRepository.OrganisationPage;
import vtigergenericUtilities.BaseClass;
import vtigergenericUtilities.ExcelUtility;
import vtigergenericUtilities.JavaFileutility;
import vtigergenericUtilities.WebDriverutils;

public class TC_03CreateOrganiationWithIndustryTest extends BaseClass {
	@Test
	public void createOrgWithindustry() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
	LoginPage lp=new LoginPage(driver);
	OrganisationPage op=new OrganisationPage(driver);

	op.getOrganisationLoolUpIMg().click();
	CreateOrgnisationNewPage cnew= new CreateOrgnisationNewPage(driver);
	
	ExcelUtility eutil=new ExcelUtility();
JavaFileutility jutil=new JavaFileutility();
	String ORGNAME=eutil.fetchSingledata("testCases", 7, 3)+jutil.random();
System.out.println(ORGNAME);
String INDUSTRYTYPE=eutil.fetchSingledata("testCases", 7, 4);
cnew.getOrganisationTextBox().sendKeys(ORGNAME);
	WebDriverutils wutil=new WebDriverutils();
	WebElement ele=driver.findElement(By.name("industry"));
	wutil.handleDropDown(ele, INDUSTRYTYPE);
	
	
	cnew.getSaveButton().click();
	Thread.sleep(3000);
	//validate
	OrganisationInfoPage o=new OrganisationInfoPage(driver);
	String header=o.getOrgHeader().getText();
//String header=	ovp.getOrgHeader().getText();
//System.out.println(header);
	if(header.contains(ORGNAME))
	{
		System.out.println("Pass"+header);
	}
	else
	{
		System.out.println("Fail"+header);
	}
	
}
