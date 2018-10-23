package test;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.TestBase;
import constants.Constant;
import dataProvider.ProductData;
import pageObjects.ViewCartPage;

public class SearchiPhoneTest extends TestBase{
	
	@Test(dataProvider = Constant.TEST_PRODUCT_DATA_PROVIDER, dataProviderClass = ProductData.class)
	 public void testWishListItems(String userName, String password, String productName) {
		 loginPage.login(userName, password);
		 homePage.searchAProduct(productName);
		 String parentWindowHandle = homePage.getParentWindowHandle();
		 Set<String> allWindowHandles = window.getAllWindowHandles();
		 System.out.println(allWindowHandles.size());
		 productDetailsPage.addProductToCart(allWindowHandles, parentWindowHandle);
		 viewCartPage.viewMyCart();
		 Assert.assertEquals(viewCartPage.getTotalProductCount() ,homePage.getProductCount());
		 Assert.assertEquals(viewCartPage.getTotalProductCost() ,homePage.getTotalProductCost());
	}
}
