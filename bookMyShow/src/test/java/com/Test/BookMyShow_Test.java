package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageFactory.BookMyShow;
import com.generic.BaseClassBook;
import com.generic.WrapperFunction_BookMyShow;


public class BookMyShow_Test extends BaseClassBook{
	BookMyShow objBookMyShow = new BookMyShow(this);
	WrapperFunction_BookMyShow objPojo_WrapperBookMyShow= new WrapperFunction_BookMyShow(this);
	
	@BeforeClass
	public void setUp() {
		this.initializeEnvoirment();
	}
	
	@Test
	public void selectCity() throws IOException{
		objBookMyShow.popUpHandle();
		objBookMyShow.selectPopCity();
		objBookMyShow.clickOnMovies();
		objBookMyShow.selectLanguage();
		objBookMyShow.selFormat();
		objBookMyShow.selectMovie();
		objBookMyShow.GetCastName();
		objBookMyShow.clickOnBookTicket();
		objBookMyShow.SelectRandomDate();
		objBookMyShow.getMovieTitle();
		objBookMyShow.clickOnTiming();	
		objBookMyShow.clickOnAcceptOrOk();
		objBookMyShow.selectSeat();
		objBookMyShow.clickOnMTicketsAndProceed();
		objBookMyShow.acceptOrReject();
	}
	

	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
