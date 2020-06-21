package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	
	
	
	@DataProvider(name="testData")
	
	public static Object [] [] userData()
	{
		return  new Object [] [] 
				{
			{"akram","magdy","akramma@gmail.com","123456"},
			{"ahmed","shwaku","shawku@gmail.com","123456"}
				};
	}
	
	
	@Test(priority=1, dataProvider="testData")
	
	public void UseCanRegisterSuccssfully (String fName , String lNAme , String Email , String password) {  
		
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration(fName, lNAme, Email, password);
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.OpenLoginrPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(Email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
