/**
 * 
 */
package se.face.moviewebtest.movie;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Samuel
 *
 */
public class MovieTest {
	@Test
	public void runTest(){
		// The Firefox driver supports javascript 
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/movieweb/movie/start");

		WebElement query = driver.findElement(By.id("searchfield"));
		query.sendKeys("Terminator 2");

		driver.findElement(By.id("searchbutton")).click();
		
		List<WebElement> allTitles = lookForElements(driver, By.xpath("//li"), 5000);
		
		assertFalse("No search results", allTitles.isEmpty());

		allTitles.get(0).click();
		
		List<WebElement> roles = lookForElements(driver, By.xpath("//th[text()='Role']"), 5000);
		
		assertEquals("Expected One \"Role\" header", 1, roles.size());
		
		driver.quit();
	}

	private List<WebElement> lookForElements(WebDriver driver, By by, long timeout) {
		List<WebElement> elements;
		long time = System.currentTimeMillis()+timeout;		
		do{
			elements = driver.findElements(by);
		} while(elements.isEmpty() && System.currentTimeMillis() < time);
		return elements;
	}
}
