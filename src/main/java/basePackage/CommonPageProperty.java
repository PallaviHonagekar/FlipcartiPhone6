package basePackage;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import basePackage.PageBase;

public class CommonPageProperty extends PageBase{
	
	
	public CommonPageProperty(WebDriver driver) {
		super(driver);
	}
	
	public int processPriceString(String number) {
	      String removedPriceSymbolString = number.substring(1);
	      String removedCommaString = removedPriceSymbolString.replaceAll("[,]", "");
		  int integerNumber = Integer.parseInt(removedCommaString);
		  return integerNumber;
	}
	
	public Set<String> getAllWindowHandles(){
		Set<String> allWindowHandles = driver.getWindowHandles();
		return allWindowHandles;
	}
	
	public String getHomePageWindowHandle() {
		String homePageWindowHandle = null; 
		for(String windowHandle : getAllWindowHandles()) {
			homePageWindowHandle = windowHandle;
			break;
		}
		return homePageWindowHandle;
	}
	
}
