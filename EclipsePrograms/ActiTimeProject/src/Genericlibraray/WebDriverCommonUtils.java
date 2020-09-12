package Genericlibraray;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtils
{
	
	public void waitforPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(CommonData.wait, TimeUnit.SECONDS);
	}

	public void waitForElement(WebDriver driver,String data)
	{
		WebDriverWait ex = new WebDriverWait(driver,CommonData.wait);
		ex.until(ExpectedConditions.titleContains(data));
		
	}
}
