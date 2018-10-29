package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import basePackage.CommonPageProperty;
import constants.Constant;

public class ViewCartPage extends CommonPageProperty{
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cartButton;
	
	@FindBy(xpath = "//span[contains(text(),'My Cart')]")
	private WebElement myCartLabel;
	
	@FindBy(xpath = "//div[@class='hJYgKM' and contains(text(),'Price')]")
	private WebElement totalProductCount;
	
	@FindBy(xpath = "//div[@class='hJYgKM']/span")
	private WebElement totalProductCost;
	
	@FindBy(xpath = "//a[contains(@class,'_325-ji')]")
	private List<WebElement> productNamesList;
	
	@FindBy(xpath = "//span[contains(@class,'XU9vZa')]")
	private List<WebElement> productPriceList;
	
	HashMap<String, String> productsInCart = new HashMap<String, String>();
	
	public ViewCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void viewMyCart() {
		waitAndClick(cartButton);
		Actions action = new Actions(driver);
		action.moveToElement(myCartLabel);
	}
	
	public int getTotalProductsCount() {
		String productCountString = waitAndGetText(totalProductCount);
		char productCountCharacter = productCountString.charAt(Constant.PRODUCTS_COUNT_DIGIT_POSITION);
		int productCount = Character.getNumericValue(productCountCharacter);
		return productCount;
	}
	
	public int getTotalProductsCost() {
		String totalCost = waitAndGetText(totalProductCost);
		return processPriceString(totalCost);
	}
	
	public HashMap<String, String> getAllProductsInCart(){
		for(int i=productNamesList.size(); i>0; i--) {
			productsInCart.put(waitAndGetText(productNamesList.get(i)), waitAndGetText(productPriceList.get(i)));
		}
		return productsInCart;
	}
}
