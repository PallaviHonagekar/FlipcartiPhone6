package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.PageBase;

public class WindowsPage extends PageBase{
	
	
	public WindowsPage(WebDriver driver) {
		super(driver);
	}
	
	public Set<String> getAllWindowHandles(){
		Set<String> allWindowHandles = driver.getWindowHandles();
		return allWindowHandles;
	}
	
}
