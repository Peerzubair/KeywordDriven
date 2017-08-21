package sa.keyDriven;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Action {

	public static WebDriver driver;
	public static void initDriver()
	{
		System.setProperty("webdriver.gecko.driver", "C:/Users/Hvuser/Downloads/geckodriver-v0.18.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.adactin.com/HotelApp/");
	}
	

	public static void select(String Locator, String value)
	{
		new Select(driver.findElement(By.id(Locator))).selectByVisibleText(value);
	}

    public static void assertVerify(String locator, String value)
    {
    	//System.out.println(driver.findElement(By.id(locator)).getAttribute("value"));
    	Assert.assertEquals(driver.findElement(By.id(locator)).getAttribute("value"),value);
    }

	public static void enterText(String locatorType, String locator, String value) {
		// TODO Auto-generated method stub
		driver.findElement(By.id(locator)).clear();
		driver.findElement(By.id(locator)).sendKeys(value);
	}
	
	public static void click(String locatorType, String locator) {
		// TODO Auto-generated method stub
		driver.findElement(By.id(locator)).click();
		
	}
	
	public static boolean isExist(String inputId){
		try{
			WebElement element = driver.findElement(By.id(inputId));
			return true;
			} catch (NoSuchElementException e){
				return false;
			}
	}

}
