package com.ActiTime.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiTimeLogOutPage 
{
	@FindBy(id="logoutLink")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() 
	{
		return logoutBtn;
	}

	public void logOut()
	{
		logoutBtn.click();
	}

}
