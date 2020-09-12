package com.ActiTime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ActiTimeLoginPage 
{
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	public WebElement getUserName()
	{
		return username;
	}

	public WebElement getPassword() 
	{
		return password;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	public void login_ActiTime(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}

	

}
