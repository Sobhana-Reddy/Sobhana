package Genericlibraray;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ActiTime.ObjectRepository.ActiTimeLogOutPage;
import com.ActiTime.ObjectRepository.ActiTimeLoginPage;

public class BaseClass 
{
	public WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void selectBrowser(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", CommonData.chromeexePath);
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", CommonData.firefoxexePath);
			driver=new FirefoxDriver();
		}
		else
			System.out.println("invalid");
	}
	@BeforeClass
	public void launchBrowser()
	{
				
		WebDriverCommonUtils wdwait = new WebDriverCommonUtils();
		wdwait.waitforPageLoad(driver);
		
		driver.get(CommonData.URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void loginActTime() throws EncryptedDocumentException, IOException
	{
				
		ActiTimeLoginPage loginpage = PageFactory.initElements(driver, ActiTimeLoginPage.class);
		
		FileUtils flib=new FileUtils();
		String UN = flib.getExcelData(CommonData.excelPath, CommonData.sheeetname, 1, 0);
		String password = flib.getExcelData(CommonData.excelPath, CommonData.sheeetname, 1, 1);
		loginpage.login_ActiTime(UN,password);
		
	}
	@AfterMethod
	public void logoutActiTime()
	{
		ActiTimeLogOutPage logoutpage=PageFactory.initElements(driver, ActiTimeLogOutPage.class);
		logoutpage.logOut();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	

}
