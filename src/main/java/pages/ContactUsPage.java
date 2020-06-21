package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="FullName")
	WebElement fullNameTxt ;
	
	@FindBy(id="Email")
	WebElement emailTxt ;

	@FindBy(id="Enquiry")
	WebElement enquiryTxt ;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	 public WebElement succesmassage;
	
	public void ContactUs( String fullName , String Email , String enquiry)
	{
		setTextElementText(fullNameTxt, fullName);
		setTextElementText(emailTxt, Email);
		setTextElementText(enquiryTxt, enquiry);
		clickButton(submitBtn);
	}
	

	
	
}
