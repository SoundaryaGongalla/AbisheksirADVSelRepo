package vTigerObjjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnisationNewPage {

	
	@FindBy(name = "accountname")
	private WebElement organisationTextBox;
	
	
	@FindBy(name="website")
	private WebElement webSiteTextBox;
	
	
	@FindBy(id = "tickersymbol")
	private WebElement tickerSymbolTextBox;
	
	
	@FindBy(name="phone")
	private WebElement phoneTextField;
	
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveButton;
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement memPLusIMG;
	
	
	

	public WebElement getMemPLusIMG() {
		return memPLusIMG;
	}

	public WebElement getOrganisationTextBox() {
		return organisationTextBox;
	}

	public WebElement getWebSiteTextBox() {
		return webSiteTextBox;
	}

	public WebElement getTickerSymbolTextBox() {
		return tickerSymbolTextBox;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	@FindBy(css = "input[title='Cancel [Alt+X]']")
	private WebElement  cancelButton;
	
	public CreateOrgnisationNewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
}
