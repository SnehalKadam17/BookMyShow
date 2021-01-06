package com.generic;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WrapperFunction_BookMyShow {

	Pojo_BookMyShow objPojo_WrapperBookMyShow;
	String currentHandle;
	public WrapperFunction_BookMyShow(Pojo_BookMyShow objPojo_BookMyShow)
	{
		this.objPojo_WrapperBookMyShow=objPojo_BookMyShow;
	}

	/*
	 * This is wrapper method for get the title of page
	 */
	public String getPageTitle() 
	{
		String title = objPojo_WrapperBookMyShow.getDriver().getTitle();
		System.out.println("Title of the page: " +title);
		return title;
	}

	/*
	 * this is wrapper method for commonclick   
	 */
	public void commonClick(By locator)
	{		
		objPojo_WrapperBookMyShow.getDriver().findElement(locator).click();
	}

	/*
	 * this is wrapper method for setText
	 */
	public void setText(By locator, String text)
	{
		WebElement element = objPojo_WrapperBookMyShow.getDriver().findElement(locator);		
		this.waitForvisibilityOfAllElementsLocated(locator);
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * this is wrapper method for getText
	 */
	public String getText(By locator)
	{
		WebElement element = objPojo_WrapperBookMyShow.getDriver().findElement(locator);
		this.waitForvisibilityOfAllElementsLocated(locator);
		String val = element.getAttribute("value");
		return val;
	}

	/*
	 * all waiting methods 
	 */
	public void waitForElemenClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(objPojo_WrapperBookMyShow.getDriver(), 100);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForvisibilityOfAllElementsLocated(By locator)
	{
		WebDriverWait wait = new WebDriverWait(objPojo_WrapperBookMyShow.getDriver(),  100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void windowHnadling()
	{
		//					String MainWindow=objPojo_Flipcart.getDriver().getWindowHandle();
		//					//System.out.println(MainWindow+"-------------------------------------------------------------------");
		//			 		
		//			        // To handle all new opened window.				
		//			        Set<String> s1=objPojo_Flipcart.getDriver().getWindowHandles();		
		//			        Iterator<String> i1=s1.iterator();				
		//			        		
		//			        while(i1.hasNext())			
		//			        {		
		//			            String ChildWindow=i1.next();		
		//			            		
		//			            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		//			            {    		
		//			                 
		//			                    // Switching to Child window
		//			            	objPojo_Flipcart.getDriver().switchTo().window(ChildWindow);
		//			            	//System.out.println(ChildWindow+"+++++++++++++++++++++++++++++++++++++++++++++++");
		//			                 	
		//			            }
		//			        }

		Set<String> handles= objPojo_WrapperBookMyShow.getDriver().getWindowHandles();
		for(String actual: handles)
		{          

			if(!actual.equalsIgnoreCase(currentHandle))
			{
				//switching to the opened tab
				objPojo_WrapperBookMyShow.getDriver().switchTo().window(actual);
			}
		}
		//			        
	} 
	public void scrollDown()
	{
		//scroll down using javascript 
		JavascriptExecutor js = (JavascriptExecutor) objPojo_WrapperBookMyShow.getDriver();
		// This  will scroll down the page by  200 pixel vertical		
		js.executeScript("window.scrollBy(0,600)");
	}

	//select random value
	public String generateRandomAndClick(By locator){
		List<WebElement> path = objPojo_WrapperBookMyShow.getDriver().findElements(locator);
		Random r = new Random();
		int num = r.nextInt(path.size());
		WebElement value = path.get(num);
		String str = value.getText();
		value.click();
		return str;	
	}

	//Find prime no
	public int getPrimeNo(){
		int a[]={2, 3, 5, 7};
		Random r=new Random();
		int num=0;
		int rNo= r.nextInt(a.length-1);
		for (int i = 0; i < a.length; i++) {
			num=a[rNo];
		}
		return num;
	}

	//Click on element
	public void clickElement(WebElement element) {
		objPojo_WrapperBookMyShow.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(objPojo_WrapperBookMyShow.getDriver(), 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try{
			element.click();
		}catch(Exception e){
			try{
				Actions actions = new Actions(objPojo_WrapperBookMyShow.getDriver());
				actions.moveToElement(element).click().build().perform();
			}catch(Exception e1){
				JavascriptExecutor js = (JavascriptExecutor) objPojo_WrapperBookMyShow.getDriver();
				// This  will scroll down the page by  200 pixel vertical		
				js.executeScript("window.scrollBy(0,600)");
				clickElement(element);
			}
		}
	}

	//Click on locator 
	public void clickLocator(By locator) {
		objPojo_WrapperBookMyShow.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.waitForElemenClickable(locator);
		try{
			objPojo_WrapperBookMyShow.getDriver().findElement(locator).click();;
		}catch(Exception e){
			try{
				WebElement element = objPojo_WrapperBookMyShow.getDriver().findElement(locator);
				Actions actions = new Actions(objPojo_WrapperBookMyShow.getDriver());
				actions.moveToElement(element).click().build().perform();
			}catch(Exception e1){
				JavascriptExecutor js = (JavascriptExecutor) objPojo_WrapperBookMyShow.getDriver();
				// This  will scroll down the page by  200 pixel vertical		
				js.executeScript("window.scrollBy(0,600)");
				clickLocator(locator);
			}
		}
	}



}




