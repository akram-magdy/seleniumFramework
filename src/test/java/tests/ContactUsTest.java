package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest  extends TestBase{
	
	
	
	HomePage homeObject;
	ContactUsPage contactObject;
	String fullName = "akram";
	String Email = "zamalek01@gmail.com";
	String enquiry = " hi ";
	
	@Test
	
	public void UserCanUseContactsUS() 
	{
		homeObject = new HomePage(driver);
		homeObject.OpenContactUs();
		contactObject = new ContactUsPage(driver);
		contactObject.ContactUs(fullName, Email, enquiry);
		Assert.assertTrue(contactObject.succesmassage.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}

}
