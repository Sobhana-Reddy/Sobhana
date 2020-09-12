package TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ActiTime.ObjectRepository.ActiTimeLoginPage;

import Genericlibraray.BaseClass;
import Genericlibraray.ScreenShotClass;
import Genericlibraray.WebDriverCommonUtils;

public class Test_ActiTimeCheckTitle extends BaseClass
{
	@Test
	public void LoginToAppCheckTitle() throws IOException, InterruptedException
	{		
		System.out.println("----------------------");
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		String expTitle="Login";
		
		WebDriverCommonUtils wcwait=new WebDriverCommonUtils();
		wcwait.waitForElement(driver, expTitle);
		
		if(expTitle.equals(actualTitle))
		{
			System.out.println("Successfully login");
		}
		else
		{
			System.out.println("invalid credential");	
			ScreenShotClass ss=new ScreenShotClass();
			Thread.sleep(2000);
			ss.Errorscreenshot(driver);
		}
		
	}

}
