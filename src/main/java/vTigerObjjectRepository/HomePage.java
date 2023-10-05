package vTigerObjjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath = "//a[text()='Organizations']")
private WebElement organisationLink;

@FindBy(xpath = "//a[text()='Contacts']")
private WebElement contactsLink;	
	
@FindBy(xpath = "//a[text()='Leads']")
private WebElement leadsLink;	
	
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorIMG;	
	

@FindBy(xpath = "//a[text()='Sign Out']")
private WebElement signOutButton;	
	
	
public WebElement getOrganisationLink() {
	return organisationLink;
}


public WebElement getContactsLink() {
	return contactsLink;
}


public WebElement getLeadsLink() {
	return leadsLink;
}


public WebElement getAdministratorIMG() {
	return administratorIMG;
}


public WebElement getSignOutButton() {
	return signOutButton;
}


public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
	
	
	
	
	
}
