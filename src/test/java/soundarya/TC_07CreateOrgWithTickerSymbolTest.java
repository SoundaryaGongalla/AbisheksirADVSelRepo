package soundarya;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
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
//@Listeners(vtigergenericUtilities.ListnersImplementation.class)
public class TC_07CreateOrgWithTickerSymbolTest extends BaseClass
{
	@Test
	public void createOrgWithTickerSymbol() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
	LoginPage lp=new LoginPage(driver);
	OrganisationPage op=new OrganisationPage(driver);
	CreateOrgnisationNewPage cnew= new CreateOrgnisationNewPage(driver);

	op.getOrganisationLoolUpIMg().click();
	op.getOrganisationLoolUpIMg();
	op.getOrganisationLoolUpIMg().click();
	ExcelUtility eutil=new ExcelUtility();
	JavaFileutility jutil=new JavaFileutility();
	String ORGNAME=eutil.fetchSingledata("testCases", 19, 3)+jutil.random();

	String TICKERSYMBOL=eutil.fetchSingledata("testCases", 19, 4);
	System.out.println(ORGNAME);
	

	System.out.println(TICKERSYMBOL);
	cnew.getOrganisationTextBox().sendKeys(ORGNAME);
		cnew.getSaveButton().click();
		Thread.sleep(2000);
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
