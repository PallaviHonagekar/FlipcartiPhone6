package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import basePackage.PageBase;

public class ViewCartPage extends PageBase{
	@FindBy(xpath = "//span[text()='Cart'])")
	private WebElement cartButton;
	
	@FindBy(xpath = "//span[contains(text(),'My Cart')]")
	private WebElement myCartLabel;
	
	@FindBy(xpath = "//div[@class='hJYgKM'][contains(text(),'Price')]")
	private WebElement totalProductCount;
	
	@FindBy(xpath = "//div[@class='hJYgKM']/span")
	private WebElement totalProductCost;
	
	public ViewCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void viewMyCart() {
		waitAndClick(cartButton);
		Actions action = new Actions(driver);
		action.moveToElement(myCartLabel);
	}
	
	public int getTotalProductCount() {
		String count = waitAndGetText(totalProductCount);
		return count.charAt(7);
	}
	
	public int getTotalProductCost() {
		String totalCost = waitAndGetText(totalProductCost);
		return processPriceString(totalCost);
	}
	
	public int processPriceString(String number) {
	      String removedPriceSymbolString = number.substring(1);
	      String removedCommaString = removedPriceSymbolString.replaceAll("[,]", "");
		  int integerNumber = Integer.parseInt(removedCommaString);
		  return integerNumber;
	}
}
