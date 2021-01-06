package com.generic;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassBook extends Pojo_BookMyShow implements BookMyShow_Interface {
Pojo_BookMyShow objPojo_Book;
	
	public void initializeEnvoirment()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objWrapperFunction = new WrapperFunction_BookMyShow(this);
	
}

}
