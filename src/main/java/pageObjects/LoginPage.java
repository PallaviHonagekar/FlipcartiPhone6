package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.PageBase;

public class LoginPage extends PageBase{
	
	@FindBy(xpath = "//span[contains(@class,'_1hgiYz')]")
	private WebElement loginText;
	
	@FindBy(xpath = "//input[@class='_2zrpKA']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String emailIdValue, String passwordValue){
		waitForElementToBeVisible(loginText);
		waitAndType(emailTextBox, emailIdValue);
		waitAndType(passwordTextBox, passwordValue);
		waitAndClick(loginButton);
	}
}
