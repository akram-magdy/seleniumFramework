package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	
	@Test(priority=1)
	
	public void UseCanRegisterSuccssfully () {  
		
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("aamss", "mayas", "testu1233@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods="UseCanRegisterSuccssfully")
	
	public void RegisterUserCanLogout() {
		
		registerObject.userLogout();
	}
	
	
	@Test(dependsOnMethods="RegisterUserCanLogout")
	public void RegisterUserCanLogin() {
		homeObject.OpenLoginrPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testttttu@gmail.com", "123456789");
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		
		
	}
}
