package soundarya;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

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
@Listeners(vtigergenericUtilities.Listners.class)
public class CreateOrganisationWithNameTest extends BaseClass {
WebDriverutils wutil=new WebDriverutils();
JavaFileutility jutil=new JavaFileutility();

	@Test
	public void createOrgWithName() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
	LoginPage lp=new LoginPage(driver);
	OrganisationPage op=new OrganisationPage(driver);
	Assert.fail();
	op.getOrganisationLoolUpIMg().click();
	CreateOrgnisationNewPage cnew= new CreateOrgnisationNewPage(driver);
	op.getOrganisationLoolUpIMg();
	op.getOrganisationLoolUpIMg().click();
	ExcelUtility eutil=new ExcelUtility();
	String ORGNAME=eutil.fetchSingledata("testCases", 1, 3)+jutil.random();
	cnew.getOrganisationTextBox().sendKeys(ORGNAME);
		cnew.getSaveButton().click();
		Thread.sleep(3000);
		//validate
		OrganisationInfoPage ovp=new OrganisationInfoPage(driver);
	String header=	ovp.getOrgHeader().getText();
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
