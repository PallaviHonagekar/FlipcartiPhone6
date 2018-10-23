package util;

import java.util.Set;
import org.openqa.selenium.WebDriver;
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
