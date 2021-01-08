package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.generic.Pojo;

import junit.framework.Assert;

public class moviesPage {
	Pojo objMoviesPage;

	By google=By.xpath("//input[@name='q']");
	By wiki = By.xpath("//h3//span[contains(text(),'Wikipedia')]");
	By director= By.xpath("//th[text()='Directed by']/following-sibling::td//a");
	By imdb =By.xpath("//li//a[text()='IMDb']/preceding::a[contains(@href,'imdb')]");
	By directorIMDB = By.xpath("//h4[text()='Director:']/following-sibling::a");

	private String movieName;

	private String wikiDirectorName;

	private String ImdbDirectorName;


	public moviesPage(Pojo objMovies_Page)
	{
		this.objMoviesPage=objMovies_Page;
	}

	public void readMovieName() throws Exception{	
		File Name = new File("D:\\Movies\\MoviesNames.xlsx");
		FileInputStream src=new FileInputStream(Name);
		XSSFWorkbook wb= new XSSFWorkbook(src);
		XSSFSheet Sheet1 = wb.getSheetAt(0);
		int num = objMoviesPage.getWrapper().generateRandomInteger(Sheet1.getLastRowNum());
		movieName = Sheet1.getRow(num).getCell(0).getStringCellValue();
		System.out.println("Movie Name from Excel: "+movieName);
		System.out.println("---------------------------------------------");
		wb.close();
	}

	public void searchMovieName() throws Exception{
			objMoviesPage.getWrapper().setText(google, movieName);
			System.out.println("Enter movie name into search text: "+movieName);
			objMoviesPage.driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			System.out.println("Click on search");
			System.out.println("---------------------------------------------");
	}

	public void clickOnWekipedia() {
		objMoviesPage.getWrapper().clickLocator(wiki);
		System.out.println("Click on Wikipedia");
		System.out.println("---------------------------------------------");
	}

	public void getDirectorOnWiki() {
		wikiDirectorName = objMoviesPage.getDriver().findElement(director).getText();	
		System.out.println("Director Name on Wikipedia: "+wikiDirectorName);
		System.out.println("---------------------------------------------");
	}

	public void clickOnIMDBLink() {
		objMoviesPage.getWrapper().clickLocator(imdb);
		System.out.println("Click on IMDB link on movie");
		System.out.println("---------------------------------------------");
	}

	public void getDirectorOnIMDB() {
		ImdbDirectorName = objMoviesPage.getDriver().findElement(directorIMDB).getText();
		System.out.println("Director name on IMDB: "+ImdbDirectorName);
		System.out.println("---------------------------------------------");
		Assert.assertEquals(wikiDirectorName, ImdbDirectorName);
		System.out.println("Both Director names are same");
		System.out.println("---------------------------------------------");
	}
	
	public void writeDataInWord() throws IOException {
		File Name = new File("D:/Selenium/Movies/testdat/MoviesNames.xlsx");
		FileInputStream src=new FileInputStream(Name);
		XSSFWorkbook wb= new XSSFWorkbook(src);
		XSSFCell cell = wb.getSheet("Sheet2").getRow(1).getCell(1);	
		cell.setCellValue(wikiDirectorName);	
		FileOutputStream src1=new FileOutputStream(Name);
		wb.write(src1);
		src1.close();
		wb.close();
		src.close();
		System.out.println("Write data in excel");
		System.out.println("---------------------------------------------");
	}
	
}
