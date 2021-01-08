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

public class WrapperFunction {

		Pojo objPojo;
		String currentHandle;
		public WrapperFunction(Pojo objPojo_Movies)
		{
			this.objPojo=objPojo_Movies;
		}

		/*
		 * This is wrapper method for get the title of page
		 */
		public String getPageTitle() 
		{
			String title = objPojo.getDriver().getTitle();
			System.out.println("Title of the page: " +title);
			return title;
		}

		/*
		 * this is wrapper method for setText
		 */
		public void setText(By locator, String text)
		{
			WebElement element = objPojo.getDriver().findElement(locator);		
			this.waitForvisibilityOfAllElementsLocated(locator);
			element.clear();
			element.sendKeys(text);
		}

		/*
		 * this is wrapper method for getText
		 */
		public String getText(By locator)
		{
			WebElement element = objPojo.getDriver().findElement(locator);
			this.waitForvisibilityOfAllElementsLocated(locator);
			String val = element.getAttribute("value");
			return val;
		}

		/*
		 * all waiting methods 
		 */
		public void waitForElemenClickable(By locator)
		{
			WebDriverWait wait = new WebDriverWait(objPojo.getDriver(), 100);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		public void waitForvisibilityOfAllElementsLocated(By locator)
		{
			WebDriverWait wait = new WebDriverWait(objPojo.getDriver(),  100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		public void windowHnadling()
		{
			Set<String> handles= objPojo.getDriver().getWindowHandles();
			for(String actual: handles)
			{          

				if(!actual.equalsIgnoreCase(currentHandle))
				{
					//switching to the opened tab
					objPojo.getDriver().switchTo().window(actual);
				}
			}			        
		} 
		public void scrollDown()
		{
			//scroll down using javascript 
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			// This  will scroll down the page by  200 pixel vertical		
			js.executeScript("window.scrollBy(0,600)");
		}

		//select random value
		public String generateRandomAndClick(By locator){
			List<WebElement> path = objPojo.getDriver().findElements(locator);
			Random r = new Random();
			int num = r.nextInt(path.size());
			WebElement value = path.get(num);
			String str = value.getText();
			value.click();
			return str;	
		}
		
		//Generate random Integer
		public int generateRandomInteger(int i){
			Random r = new Random();
			int num = r.nextInt(i);
			return num;		
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
			objPojo.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(objPojo.getDriver(), 100);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			try{
				element.click();
			}catch(Exception e){
				try{
					Actions actions = new Actions(objPojo.getDriver());
					actions.moveToElement(element).click().build().perform();
				}catch(Exception e1){
					JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
					// This  will scroll down the page by  200 pixel vertical		
					js.executeScript("window.scrollBy(0,600)");
					clickElement(element);
				}
			}
		}

		//Click on locator 
		public void clickLocator(By locator) {
			objPojo.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			this.waitForElemenClickable(locator);
			try{
				objPojo.getDriver().findElement(locator).click();;
			}catch(Exception e){
				try{
					WebElement element = objPojo.getDriver().findElement(locator);
					Actions actions = new Actions(objPojo.getDriver());
					actions.moveToElement(element).click().build().perform();
				}catch(Exception e1){
					JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
					// This  will scroll down the page by  200 pixel vertical		
					js.executeScript("window.scrollBy(0,600)");
					clickLocator(locator);
				}
			}
		}
}
