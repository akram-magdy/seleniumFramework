package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage  extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver ;
		action = new Actions(driver); 
	}
	
	@FindBy(linkText="Register")
	WebElement RegisterLink;
	
	@FindBy(linkText="Log in")
	 WebElement loginLink ;
	
	@FindBy(linkText="Contact us")
	WebElement ContactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencydr1 ;
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu; 
	
	
	public void OpenRegisterPage() {
		
		clickButton(RegisterLink);
	}
	

	public void OpenLoginrPage() {
		
		clickButton(loginLink);
	}
 public void OpenContactUs() 
 {
	 scrollToBottom();
	 clickButton(ContactUsLink);
 }
 
 public void changeCurrency()
 {
	 select = new Select(currencydr1);
	 select.selectByVisibleText("Euro");
 }
 
 public void selectNotebooksMenu() 
 {
	 action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
 }
 
}
