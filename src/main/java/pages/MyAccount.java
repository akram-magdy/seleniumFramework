package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends PageBase {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css="input.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy(css="div.result")
	 public WebElement resultlbl;
	
	
	
	public void openChangePasswordPage() 
	{
		clickButton(changePasswordLink);
	}
	
	public void ChangePassword ( String NewPassword , String OldPassword) {
		
		clickButton(changePasswordLink);
		setTextElementText(oldPasswordTxt, OldPassword);
		setTextElementText(newPasswordTxt, NewPassword);
		setTextElementText(confirmPasswordTxt, NewPassword);
		clickButton(ChangePasswordBtn);
		
	}
	
}
