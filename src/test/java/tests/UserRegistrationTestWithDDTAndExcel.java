package tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void UserCanRegisterSuccssfully(String firstname , String lastname , String email , String password) 
	{
		homeObject = new HomePage(driver); 
		homeObject.OpenRegisterPage();;
		registerObject = new UserRegistrationPage(driver); 
		registerObject.UserRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMassage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.OpenLoginrPage();;
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}

}
