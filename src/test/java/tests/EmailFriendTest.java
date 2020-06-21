package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	UserRegistrationPage registerObject;
	HomePage homeObject;
	LoginPage loginObject;
	SearchPage searchObject;
	EmailPage emailObject;
	String email = "zamalek6@gmail.com";
	String password = "akram123";
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	String friendEmail = "akrm201090@gmail.com";
	String personalMessage = "Hi my friend";
	String YourEmailAddress = "akramibrahim@gmail.com";

	// Register
	@Test(priority=1)
	public void UseCanRegisterSuccssfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("akram", "magdy", "akramibrahim@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
	}

	// search product
	@Test(priority=2)
	public void userCanSearchForProduct() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}

	// sendEmail
	@Test(priority=4)
	public void SendEmail() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend(friendEmail, personalMessage, YourEmailAddress);
	}
}