package soundarya;

import org.testng.annotations.Test;
import java.util.Set;

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

public class TC_11CreateOrgansiationWithMemberTest  extends BaseClass{
	
	@Test
	public void createOrgWithType() throws Throwable
	{
	HomePage hp=new HomePage(driver);
	hp.getOrganisationLink().click();
LoginPage lp=new LoginPage(driver);
OrganisationPage op=new OrganisationPage(driver);

op.getOrganisationLoolUpIMg().click();
CreateOrgnisationNewPage cnew= new CreateOrgnisationNewPage(driver);
op.getOrganisationLoolUpIMg();
op.getOrganisationLoolUpIMg().click();
ExcelUtility eutil=new ExcelUtility();
JavaFileutility jutil=new JavaFileutility();
String ORGNAME=eutil.fetchSingledata("testCases", 1, 3)+jutil.random();
cnew.getOrganisationTextBox().sendKeys(ORGNAME);
	
	cnew.getMemPLusIMG().click();
	WebDriverutils wutil=new WebDriverutils();
	///wutil.handletabs(driver, "Organizations");
	Set<String> allids=driver.getWindowHandles();
	for(String i:allids)
	{
	String t=driver.switchTo().window(i).getTitle();
	if(t.contains(ORGNAME))
	{
		break;
	}
	}
	OrganisationMemberPage om=new OrganisationMemberPage(driver);
	om.getSearchBox().sendKeys("pizza");
	Thread.sleep(3000);
	om.getSearchButton().click();
	Thread.sleep(2000);
	om.getOrgmemName().click();
	//wutil.alertPOPupAccept(driver);
//wutil.switchToDefaultContent(driver);
	Thread.sleep(2000);
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
}
