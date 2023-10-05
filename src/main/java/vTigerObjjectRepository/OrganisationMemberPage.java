package vTigerObjjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationMemberPage {

	@FindBy(id = "search_txt") private WebElement searchBox;
	@FindBy(name = "search")
private WebElement searchButton;
	@FindBy(xpath = "//div[@style='overflow:auto;height:348px;']/table/tbody/tr[2]/td/a")
	private WebElement orgmemName;
	public OrganisationMemberPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getOrgmemName() {
		return orgmemName;
	}
	
}
