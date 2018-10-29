package pageObjects;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.CommonPageProperty;

public class ProductDetailsPage extends CommonPageProperty{
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//h1/span")
	private WebElement productName;
	
	@FindBy(xpath = "//div[contains(@class,'_3iZgFn')]//div[contains(@class,'_1vC4OE')]")
	private WebElement productPrice;
	
	private int totalProductsCount = 0;
	private int totalProductsCost = 0;
	HashMap<String, String> productsInRange = new HashMap<String, String>();  
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public void addProductToCart() {
		String homePageHandle = getHomePageWindowHandle();
		totalProductsCount = (getAllWindowHandles().size()) - 1;
		for(String handle : getAllWindowHandles())
		{
			//waitForElementToBeVisible(productName);
			if(!handle.equals(homePageHandle)) {
				driver.switchTo().window(handle); 
				productsInRange.put(waitAndGetText(productName), waitAndGetText(productPrice));
				int thisProductPrize = processPriceString(waitAndGetText(productPrice));
				totalProductsCost = totalProductsCost + thisProductPrize;
				waitAndClick(addToCartButton);
				//driver.close();
			}
			System.out.println(handle);
		}
		driver.switchTo().window(homePageHandle);
	}
	
	public int getTotalProductsCount() {
		return totalProductsCount;
	}
	
	public int getTotalProductsCost() {
		return totalProductsCost;
	}
	
	public HashMap<String, String> getAllProductsInCart(){
		return productsInRange;
	}

}
