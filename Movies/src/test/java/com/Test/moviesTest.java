package com.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.generic.BaseClass;
import com.pages.moviesPage;

public class moviesTest extends BaseClass{
	moviesPage objMoviesPage = new moviesPage(this);
	
	@BeforeClass
	public void setUp() {
		initializeEnvoirment();
	}	
	
	@Test
	public void searchMovies() throws Exception{
		objMoviesPage.readMovieName();
		objMoviesPage.searchMovieName();
		objMoviesPage.clickOnWekipedia();
		objMoviesPage.getDirectorOnWiki();
		objMoviesPage.clickOnIMDBLink();
		objMoviesPage.getDirectorOnIMDB();
		objMoviesPage.writeDataInWord();
	}
	
	@AfterClass
	public void tearDown(){
		   driver.close();
	}

}
