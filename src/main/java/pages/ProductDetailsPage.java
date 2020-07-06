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
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishListBtn ;
	
	@FindBy(xpath="//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]/input")
	WebElement addToCompareBtn ;
	
	@FindBy(xpath=" //*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[9]/div[2]/input")
	WebElement addToCompareBtn2 ;
	
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(AddReviewLink);
	}
	
	public void AddProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void AddProductToCompare()
	{
		clickButton(addToCompareBtn);
	}
	public void AddProductToCompare2()
	{
		clickButton(addToCompareBtn2);
	}
	

}
