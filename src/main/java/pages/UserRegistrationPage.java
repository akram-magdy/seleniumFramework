package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement GenderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement repasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement successMassage;
	
	@FindBy(linkText="Log out")
	 public WebElement logoutLink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink ;
	

	public void UserRegistration(String firstName, String lastName, String email,  String password) {

		clickButton(GenderRdoBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(repasswordTxtBox, password);
		clickButton(registerBtn);

	}
	
	public void userLogout()
	{
		clickButton(logoutLink);
	}
	
	
	public void OpenMyAccountPage()
	{
		clickButton(myAccountLink);
	}
}
