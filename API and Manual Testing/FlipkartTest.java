import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipkartTest {
    public static void main(String[] args) {
        // Set path to chromedriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  // Provide full path here

        // Initialize WebDriver with Chrome Options
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the Flipkart website
            driver.get("https://www.flipkart.com");

            // Close the login popup (if appears)
            WebElement closeButton = driver.findElement(By.xpath("//button[text()='✕']"));
            closeButton.click();

            // Find the search bar and search for a product (e.g., "laptop")
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("laptop");

            // Find and click the search button
            WebElement searchButton = driver.findElement(By.className("L0Z3Pu"));
            searchButton.click();

            // Wait for results to load
            Thread.sleep(5000);

            // Get the name of the first product and print
            WebElement firstProduct = driver.findElement(By.xpath("//a[contains(@class, 'IRpwTa')]"));
            System.out.println("First Product: " + firstProduct.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
