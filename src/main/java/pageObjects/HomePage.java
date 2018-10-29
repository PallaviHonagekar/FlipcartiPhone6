package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.CommonPageProperty;
import basePackage.PageBase;
import constants.Constant;

public class HomePage extends CommonPageProperty{
	@FindBy(xpath = "//input[contains(@title,'Search')]")
	private WebElement searchTextBox;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[contains(text(),'Low to High')]")
	private WebElement lowToHighLable;
	
	By productNameLocator = By.xpath("//div[contains(@class,'_3wU53n')]");
	By productPriceListLocator = By.xpath("//div[contains(@class,'_1vC4OE _2rQ-NK')]");
	
	@FindBy(xpath="//div[contains(@class,'_1vC4OE _2rQ-NK')]")
	private List<WebElement> productPriceList;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void searchProductInRange(String productName) {
		waitAndType(searchTextBox, productName);
		waitAndClick(searchButton);
		
		try {
			waitAndClick(lowToHighLable);
			waitForAllElementsToPresent(productPriceListLocator);
			System.out.println(driver.getWindowHandle());
			for(WebElement price : productPriceList) {
				int currentProductPrice = processPriceString(waitAndGetText(price));
				if(currentProductPrice > Constant.MINIMUM_PRICE && currentProductPrice < Constant.MAXIMUM_PRICE) {
					waitAndClick(price);		
				}
				else {
					break;
				}
			}
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, HomePage.class);
		}
	}	
}