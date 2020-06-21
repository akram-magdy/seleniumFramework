package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(xpath="//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	WebElement emailFriendBtn ;
	
	
	@FindBy(css="span.price-value-4")
	 public WebElement productPriceLbl;
	
	@FindBy(linkText="Add your review")
	WebElement AddReviewLink ;
	
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(AddReviewLink);
	}

}
