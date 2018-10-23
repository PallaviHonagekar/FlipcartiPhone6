package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.PageBase;

public class HomePage extends PageBase{
	@FindBy(xpath = "//input[contains(@title,'Search')]")
	private WebElement searchTextBox;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[contains(text(),'Low to High')]")
	private WebElement lowToHighLable;
	
	By productNameLocator = By.xpath("//div[contains(@class,'_3wU53n')]");
	
	@FindBy(xpath="//div[contains(@class,'_1vC4OE _2rQ-NK')]")
	private List<WebElement> productPriceList;
	
	//private List<WebElement> productsInRangeList;
	private int productCount = 0;
	private int totalProductsCost = 0;
	private List<String> individualProductList;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void searchAProduct(String productName) {
		waitAndType(searchTextBox, productName);
		waitAndClick(searchButton);
		waitAndClick(lowToHighLable);
		try {
			for(WebElement price : productPriceList) {
				int currentProductPrice = processPriceString(waitAndGetText(price));
				if(currentProductPrice > 1000 && currentProductPrice < 30000) {
					productCount += 1;
					totalProductsCost += currentProductPrice;
					//individualProductList.add(waitAndGetText(price));
					waitAndClick(price);
					
				}
			}
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, HomePage.class);
		}
	}
	
	public String getParentWindowHandle() {
		String parentWindowHandle = driver.getWindowHandle();
		return parentWindowHandle;
	}
	
	public int getTotalProductCost() {
		return totalProductsCost;
	}
	
	public int getProductCount() {
		return productCount;
	}
	
	public List<String> getIndividualProductPrice(){
		return individualProductList;
	}
	
	public int processPriceString(String number) {
      String removedPriceSymbolString = number.substring(1);
      String removedCommaString = removedPriceSymbolString.replaceAll("[,]", "");
	  int integerNumber = Integer.parseInt(removedCommaString);
	  return integerNumber;
	}
}

//div[contains(@class,'_1vC4OE _2rQ-NK')]//parent::div//parent::div//parent::div//preceding-sibling::div/div

//div[contains(@class,'_1vC4OE _2rQ-NK')]/ancestor::div[@class='col col-5-12 _2o7WAb']/preceding-sibling::div/div[@class='_3wU53n']}