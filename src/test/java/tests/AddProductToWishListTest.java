package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	
	
	HomePage homeObj;
	SearchPage searchObj;
	ProductDetailsPage productDetails;
	WishListPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest()
	{
		searchObj = new SearchPage(driver);
		searchObj.ProductSearch(productName);
		productDetails = new ProductDetailsPage(driver);
		productDetails.AddProductToWishList();	
	}
	@Test(priority=2)
	public void UserCanAddProductToWishlist()
	{
		productDetails = new ProductDetailsPage(driver);
		productDetails.AddProductToWishList();
		wishlistObject = new WishListPage(driver);
		driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));		
	}
	
	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
	}
}
