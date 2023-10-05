package vTigerObjjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement organisationLoolUpIMg;

	public WebElement getOrganisationLoolUpIMg() {
		return organisationLoolUpIMg;
	}
	
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
}
