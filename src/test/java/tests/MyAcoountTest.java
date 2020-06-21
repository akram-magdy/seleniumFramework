package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.UserRegistrationPage;

public class MyAcoountTest extends TestBase {
	
	HomePage homeObject;
	LoginPage loginObject ;
	UserRegistrationPage registerObject ;
	MyAccount MyAccoutntObject ;
	String oldPassword = "123456789";
	String Email = "zamalek6@gmail.com";
	String NewPassword = "akram123" ;
	
@Test(priority=1)
	
	public void UseCanRegisterSuccssfully () {  
		
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("akram", "magdy", Email, oldPassword);
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
	}


@Test(priority=2)

public void RegisteredUserCanChangePassword() {
	MyAccoutntObject = new MyAccount(driver);
	registerObject.OpenMyAccountPage();
	MyAccoutntObject.openChangePasswordPage();
	MyAccoutntObject.ChangePassword(NewPassword, oldPassword);
	Assert.assertTrue(MyAccoutntObject.resultlbl.getText().contains("Password was changed"));
}

@Test(priority=3)
public void RegisteredUserCanLogout() 
{
	registerObject.userLogout();
}

@Test(priority=4)
public void RegisteredUserCanLogin() 
{
	homeObject.OpenLoginrPage();
	loginObject = new LoginPage(driver);
	loginObject.UserLogin(Email, NewPassword);
	Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
}
}
