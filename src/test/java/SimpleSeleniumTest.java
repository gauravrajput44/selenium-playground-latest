import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleSeleniumTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchGoogle() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find search box and enter text
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // Submit search
        searchBox.submit();

        // Wait for results (implicit wait)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
