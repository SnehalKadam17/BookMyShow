package com.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {
	public WebDriver driver;
	WrapperFunction objWrapperFunction;
	
	//Getter method for driver
	public WebDriver getDriver()
	{
		return driver;
	}
	
	//setter method for driver
	public void setDriver(WebDriver driver)
	{
		driver = this.getDriver();
	}
	
	public WrapperFunction getWrapper() {
		return objWrapperFunction;

}
	

}
