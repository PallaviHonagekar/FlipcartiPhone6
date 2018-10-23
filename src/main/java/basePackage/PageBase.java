package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageBase(WebDriver driver){ 
	    this.driver = driver; 
	    wait = new WebDriverWait(driver,60);
	} 
	
	public void waitAndType(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void hoverOnElement(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}
	
	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void waitForAllElementsToPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public String waitAndGetText(WebElement  element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
}
