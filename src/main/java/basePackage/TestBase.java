package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import constants.Constant;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ViewCartPage;
import pageObjects.WindowsPage;

public class TestBase {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected WindowsPage window;
	protected ProductDetailsPage productDetailsPage;
	protected ViewCartPage viewCartPage;
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		driver = new FirefoxDriver();
		driver.get(Constant.URL_FLIPKART);
		driver.manage().window().maximize();	
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		window = PageFactory.initElements(driver, WindowsPage.class);
		productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
		viewCartPage = PageFactory.initElements(driver, ViewCartPage.class);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
