package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
	
	
	public EmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
    private WebElement emailFriendTxt;

    @FindBy(id = "PersonalMessage")
    private WebElement personalMessageTxt;
    
    @FindBy(id="YourEmailAddress")
    WebElement MyEmail;

    @FindBy(name = "send-email")
    private WebElement sendEmailBtn;
    
    @FindBy(css = "div.result")
    public WebElement messageNotification;
    
    public void SendEmailToFriend(String friendEmail, String personalMessage , String YourEmailAddress) {
        setTextElementText(emailFriendTxt, friendEmail);
        setTextElementText(personalMessageTxt, personalMessage);
        setTextElementText(MyEmail, YourEmailAddress);
        clickButton(sendEmailBtn);
    }

}
