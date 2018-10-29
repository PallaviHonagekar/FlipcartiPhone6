package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import basePackage.TestBase;
import constants.Constant;
import dataProvider.ProductData;

public class SearchiPhoneTest extends TestBase{
	
	@Test(dataProvider = Constant.TEST_PRODUCT_DATA_PROVIDER, dataProviderClass = ProductData.class)
	 public void testMyCart(String userName, String password, String productName) {
		 loginPage.login(userName, password);
		 homePage.searchProductInRange(productName);
		 productDetailsPage.addProductToCart();
		 viewCartPage.viewMyCart();
		 Assert.assertEquals(viewCartPage.getTotalProductsCount(), productDetailsPage.getTotalProductsCount());
		 Assert.assertEquals(viewCartPage.getTotalProductsCost(), productDetailsPage.getTotalProductsCost());
		 Assert.assertTrue(viewCartPage.getAllProductsInCart().equals(productDetailsPage.getAllProductsInCart()));
	}
}
