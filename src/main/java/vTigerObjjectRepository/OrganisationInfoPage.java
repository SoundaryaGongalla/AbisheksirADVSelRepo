package vTigerObjjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeader;

	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeader() {
		return orgHeader;
	}
	
	
	
	
}
