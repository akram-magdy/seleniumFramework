package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	HomePage homeObject ;
	ComparePage compareObject ;
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";

	@Test
	public void UserCanCompareProduct() throws InterruptedException 
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();
		
		Thread.sleep(5000);
		
		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		compareObject = new ComparePage(driver);
		detailsObject.AddProductToCompare2();
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
	}
	
	@Test(priority=2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
