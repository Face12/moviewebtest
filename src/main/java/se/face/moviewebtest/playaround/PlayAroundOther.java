/**
 * 
 */
package se.face.moviewebtest.playaround;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Samuel
 *
 */
public class PlayAroundOther {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
//		System.setProperty("webdriver.ie.driver.host","127.0.0.1");
		// The Firefox driver supports javascript 
		WebDriver driver = new InternetExplorerDriver();

		// Go to the Google Suggest home page
		driver.get("http://www.whatsmyuseragent.com");

		// Enter the query string "Cheese"
//		WebElement query = driver.findElement(By.name("q"));
//		query.sendKeys("Cheese");

//		// Sleep until the div we want is visible or 5 seconds is over
//		long end = System.currentTimeMillis() + 5000;
//		while (System.currentTimeMillis() < end) {
//			WebElement resultsDiv = driver.findElement(By.className("sbdd_b"));
//
//			// If results have been returned, the results are displayed in a drop down.
//			if (resultsDiv.isDisplayed()) {
//				break;
//			}
//		}
		Thread.sleep(10000);
		// And now list the suggestions
		List<WebElement> allSuggestions = driver.findElements(By.xpath("//h2[@class='info']"));

		for (WebElement suggestion : allSuggestions) {
			System.out.println(suggestion.getText());
		}

		driver.quit();
	}

}
