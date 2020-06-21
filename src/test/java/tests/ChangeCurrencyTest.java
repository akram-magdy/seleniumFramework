package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	
	HomePage homeObject ;
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=1)
	
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	@Test(priority=2)
public void userCanSearchForProduct() {
		searchObject = new SearchPage(driver);
		detailsObject= new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		System.out.println(detailsObject.productPriceLbl.getText());
		//Assert.assertTrue(detailsObject.productPriceLbl.getText().contains(" â‚¬"));
	}
}
