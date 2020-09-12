package Genericlibraray;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass 
{

	public void Errorscreenshot( WebDriver driver) throws IOException
	{
	TakesScreenshot shots=(TakesScreenshot) driver;
	File src=shots.getScreenshotAs(OutputType.FILE);
	File desc=new File("./screenShot/home.png");
	FileUtils.copyFile(src,desc);
	}

}
