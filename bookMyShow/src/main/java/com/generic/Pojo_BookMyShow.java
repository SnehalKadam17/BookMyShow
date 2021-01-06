package com.generic;

import org.openqa.selenium.WebDriver;



public class Pojo_BookMyShow {
	public WebDriver driver;
	WrapperFunction_BookMyShow objWrapperFunction;
	
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
	
	public WrapperFunction_BookMyShow getWrapper() {
		return objWrapperFunction;

}

}
