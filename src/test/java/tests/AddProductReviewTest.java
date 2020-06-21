package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject ;
	SearchPage searchObject ;
	ProductDetailsPage detailsObject;
	ProductReviewPage  productReviewObject;
	String email = "zamalek6@gmail.com";
	String password = "akram123" ;
	String productName = "Apple MacBook Pro 13-inch";
	String reviewTitle ="good";
	String reviewMassage ="good";
	
	@Test (priority=1)
public void UseCanRegisterSuccssfully () {  
		
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("akram", "magdy", "testttt56@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void userCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		detailsObject= new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		detailsObject.openAddReviewPage();
	}
	@Test(priority=3)
	public void userCanAddReview()
	{
		productReviewObject = new ProductReviewPage(driver);
		productReviewObject.AddProductReview(reviewTitle, reviewMassage);
		Assert.assertTrue(productReviewObject.reviewNoti.getText().contains("Product review is successfully added"));
		
	}
	

}
