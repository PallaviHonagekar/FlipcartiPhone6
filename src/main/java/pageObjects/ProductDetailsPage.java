package pageObjects;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.PageBase;

public class ProductDetailsPage extends PageBase{
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCartButton;
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public void addProductToCart(Set<String> allWindowHandles, String parentWindowHandle) {
		for(String handle : allWindowHandles)
		{
			if(handle.equals(parentWindowHandle)) {
				System.out.println("Hello");
			}
			else {
				System.out.println("Switching to window - > " + handle);
				driver.switchTo().window(handle); 
				waitAndClick(addToCartButton);
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}

}
