package com.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.generic.Pojo_BookMyShow;

import junit.framework.Assert;

public class BookMyShow {

	Pojo_BookMyShow objPojo_BookMyShow;

	By popUp= By.xpath("//div[@class='wzrk-button-container']//child::button[@class='No thanks']");
	By lnkMovies= By.xpath("//a[text()='Movies']");
	By city = By.xpath("//ul[@class='sc-iybRtq fYDbAn']//child::li");
	By language= By.xpath("//div[@class='style__StyledText-tgsgks-0 cAIFpf']");
	By movie =By.xpath("//div[@class='style__StyledText-tgsgks-0 gbzvvd']");
	By cast= By.xpath("//h4[text()='Cast']/parent::div/parent::div/following-sibling::div//div//a");
	By btnBookTickets =By.xpath("//div[@class='styles__CtaWrapper-sc-16qvuq-8 goFMPV']/div");
	By day= By.xpath("//div[@class='date-day']");
	By movieTitle = By.xpath("//h1//div//a");
	By Timing = By.xpath("//a[@class='showtime-pill']");
	By seat = By.xpath("//div[@id='dTktQtySelVehiclesIcons']");
	By popup = By.xpath("//div[@class='styles__BottomSheetContainer-xr4gt6-0 gSpSqW']");
	By clkOption2D = By.xpath("(//div//span[text()='2D'])[1]");
	By format= By.xpath("//div[text()='Format']");
	By twoDimentional= By.xpath("(//div[contains(text(),'2D')])[2]");
	By btnPopUpOk = By.xpath("//a[@id='btnPopupOK']");
	By btnAccept = By.xpath("//a[@id='btnPopupAccept']");
	By Btn2D=By.xpath("(//div[@class='styles__DimensionComponent-sc-1efo077-3 ifVrUL'])[1]");
	By selSeat = By.xpath("//ul[@id='popQty']//li");
	By btnSeats= By.xpath("//div[@id='proceed-Qty']");
	By getNumberSeat = By.xpath("//span[@id='intQty']");
	By SeatNumberSelect = By.xpath("//a[@class='_available']");
	By btnPayRs = By.xpath("(//a[@id='btmcntbook'])[1]");
	By rbMTicket = By.xpath("//label[@for='mticket']");
	By btnProceed = By.xpath("//a[@id='prePay']");
	By btnAcceptProceed= By.xpath("//a[@id='btnAduPopupAccept']");

	private String selMovie;
	private String selLanguage;

	public BookMyShow(Pojo_BookMyShow objPojo_Book)
	{
		this.objPojo_BookMyShow=objPojo_Book;
	}

	//Handle Pop Up window
	public void popUpHandle() {
		objPojo_BookMyShow.getDriver().findElement(popUp).click();
		System.out.println("Click on Pop up");	
		System.out.println("--------------------------------------------------------");
	}
	//Select random City
	public void selectPopCity() {
		objPojo_BookMyShow.getWrapper().waitForElemenClickable(city);
		String selCity = objPojo_BookMyShow.getWrapper().generateRandomAndClick(city);		
		System.out.println("Select City: "+selCity);
		if (selCity.equalsIgnoreCase("Kochi")) {
			objPojo_BookMyShow.getDriver().findElement(By.xpath("//span[contains(text(),'Kochi')]")).click();
			objPojo_BookMyShow.getWrapper().waitForElemenClickable(city);
			String selCity1 = objPojo_BookMyShow.getWrapper().generateRandomAndClick(city);
			System.out.println("Select city:"+selCity1 );
		}
		System.out.println("--------------------------------------------------------");
	}

	//Click On Movies
	public void clickOnMovies() {
		objPojo_BookMyShow.getWrapper().waitForElemenClickable(lnkMovies);
		objPojo_BookMyShow.getDriver().findElement(lnkMovies).click();
		System.out.println("Click on Movies Tab");
		System.out.println("--------------------------------------------------------");
	}

	//Select random Language
	public void selectLanguage() {
		objPojo_BookMyShow.getWrapper().scrollDown();
		objPojo_BookMyShow.getWrapper().waitForElemenClickable(language);
		selLanguage = objPojo_BookMyShow.getWrapper().generateRandomAndClick(language);
		System.out.println("Select Language:"+selLanguage);
		System.out.println("--------------------------------------------------------");
	}

	//Select format
	public void selFormat() {
		objPojo_BookMyShow.getWrapper().scrollDown();
		objPojo_BookMyShow.getWrapper().waitForElemenClickable(format);
		objPojo_BookMyShow.getWrapper().clickLocator(format);
		System.out.println("Click on format");

		objPojo_BookMyShow.getWrapper().waitForElemenClickable(twoDimentional);
		objPojo_BookMyShow.getWrapper().clickLocator(twoDimentional);
		System.out.println("Click on 2D");
		System.out.println("--------------------------------------------------------");
	}

	//Select Random Movie
	public void selectMovie() {
		objPojo_BookMyShow.getWrapper().scrollDown();
		objPojo_BookMyShow.getWrapper().waitForElemenClickable(movie);
		selMovie = objPojo_BookMyShow.getWrapper().generateRandomAndClick(movie);
		System.out.println("Select Movie: "+selMovie);
		System.out.println("--------------------------------------------------------");
	}

	//Get cast names
	public void GetCastName() throws IOException{
		FileWriter fw = null;
		List<WebElement> locator = objPojo_BookMyShow.getDriver().findElements(cast);
		for (int i = 0; i < locator.size(); i++) {
			String castName = locator.get(i).getText();
			System.out.println(castName);
			fw =new FileWriter("./target/Data.txt",true);    
			fw.write(castName+"\n");      
		}
	}

	//Click on Book Ticket
	public void clickOnBookTicket() {
		objPojo_BookMyShow.getDriver().findElement(btnBookTickets).click();
		System.out.println("Click on Book Tickets");
		System.out.println("--------------------------------------------------------");
		try {
			objPojo_BookMyShow.getDriver().findElement(clkOption2D).click();
			System.out.println("Select 2D option from Select language and format");
			System.out.println("--------------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Select language and format pop up is not displayed");
			System.out.println("--------------------------------------------------------");
		}

	}

	//Get movie title 
	public void getMovieTitle() {
		String title = objPojo_BookMyShow.getDriver().findElement(movieTitle).getText();
		String actualTitle = title.trim();
		System.out.println("Page Title: "+actualTitle);
		if (actualTitle.contains(selMovie)) {
			Assert.assertTrue(true);	
		}else{
			Assert.assertTrue(false);
		}
		System.out.println("--------------------------------------------------------");
	}

	//Click on random timing
	public void clickOnTiming() {
		String selTiming = objPojo_BookMyShow.getWrapper().generateRandomAndClick(Timing);
		System.out.println("Select Timing: "+selTiming);	
		System.out.println("--------------------------------------------------------");
	}

	//Click on terms and conditions
	public void clickOnAcceptOrOk()
	{
		try {

			boolean flag1 = objPojo_BookMyShow.getDriver().findElement(btnPopUpOk).isDisplayed();
			System.out.println("Flag set to " +flag1);
			if(flag1==true)
			{
				objPojo_BookMyShow.getWrapper().commonClick(btnPopUpOk);
				System.out.println("Click on button Popup OK");
				System.out.println("--------------------------------------------------------");
			}
			else
			{
				objPojo_BookMyShow.getWrapper().commonClick(btnAccept);
				System.out.println("Click on button popup Accept");
				System.out.println("--------------------------------------------------------");
			}
		} catch (Exception e) {
			boolean flag1 = objPojo_BookMyShow.getDriver().findElement(btnAccept).isDisplayed();
			System.out.println("Flag set to " +flag1);
			if(flag1==true)
			{
				objPojo_BookMyShow.getWrapper().commonClick(btnAccept);
			}
			else
			{
				objPojo_BookMyShow.getWrapper().commonClick(btnAccept);
			}
		}
		finally {
			System.out.println("Accept or ok button is not displayed");
			System.out.println("--------------------------------------------------------");
		}
	}

	//Select dimension and click on day
	public void SelectRandomDate()
	{    
		try{
			WebElement page2D = objPojo_BookMyShow.getDriver().findElement(Btn2D);

			if(page2D.isDisplayed())
			{
				objPojo_BookMyShow.getWrapper().clickLocator(clkOption2D);
			}
		}
		catch(Exception e)
		{
			objPojo_BookMyShow.getWrapper().waitForvisibilityOfAllElementsLocated(day);
			String date = objPojo_BookMyShow.getWrapper().generateRandomAndClick(day);
			System.out.println("Date Selected: "+date);
			System.out.println("--------------------------------------------------------");

		}
	}

	//Select random seat
	public void selectSeat() {	
		objPojo_BookMyShow.getWrapper().waitForvisibilityOfAllElementsLocated(seat);
		int pNo=objPojo_BookMyShow.getWrapper().getPrimeNo();
		WebElement element = objPojo_BookMyShow.getDriver().findElement(By.xpath("//li[@id='pop_"+pNo+"']"));
		objPojo_BookMyShow.getWrapper().clickElement(element);
		String seatNo = element.getText();		
		System.out.println("Select seat count: "+seatNo);
		objPojo_BookMyShow.getWrapper().clickLocator(btnSeats);
		System.out.println("Click on Select seats");
		System.out.println("--------------------------------------------------------");
		String s = objPojo_BookMyShow.getDriver().findElement(getNumberSeat).getText();
		int num = Integer.parseInt(s);
		for(int i=0;i<=num-1;i++)
		{          
			objPojo_BookMyShow.getDriver().findElement(SeatNumberSelect).click();
			boolean flag = objPojo_BookMyShow.getDriver().findElement(btnPayRs).isDisplayed();
			if (flag==true)
			{        
				objPojo_BookMyShow.getWrapper().clickLocator(btnPayRs);
				String payRS = objPojo_BookMyShow.getDriver().findElement(btnPayRs).getText();
				System.out.println("Total amount: "+payRS);
				System.out.println("flag:"+flag);
				System.out.println("--------------------------------------------------------");
			}          
		}
	}

	//Click on M Tickets
	public void clickOnMTicketsAndProceed() {
		boolean flag = objPojo_BookMyShow.getDriver().findElement(rbMTicket).isDisplayed();
		System.out.println("MTicket Displayed: "+flag);
		if(flag==true){
			objPojo_BookMyShow.getWrapper().clickLocator(rbMTicket);
			System.out.println("Click on M Ticket checkbox");
			System.out.println("--------------------------------------------------------");
			objPojo_BookMyShow.getWrapper().clickLocator(btnProceed);
			System.out.println("Click on Proceed");
			System.out.println("--------------------------------------------------------");
		}else{
			objPojo_BookMyShow.getWrapper().clickLocator(btnProceed);
			System.out.println("Click on Proceed");
			System.out.println("--------------------------------------------------------");
		}
	}
	
	public void acceptOrReject(){	
	try {
		objPojo_BookMyShow.getWrapper().clickLocator(btnAcceptProceed);
		System.out.println("Click on Accept proceed button");
		System.out.println("--------------------------------------------------------");
	} catch (Exception e) {
		System.out.println("Terms and conditions pop up is not displayed");
		System.out.println("--------------------------------------------------------");
	}
}	
}

