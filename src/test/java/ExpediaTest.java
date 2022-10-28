import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpediaTest {
    static {
        WebDriverManager.chromedriver ().setup ();
    }

    private WebDriver driver;

    @Test
    public void testExpedia() throws InterruptedException {
        driver.get ("https://www.expedia.com/");
        Thread.sleep (1000);
        driver.findElement (By.xpath ("//span[text()='Flights']")).click ();
        Thread.sleep (1000);
        driver.findElement (By.xpath ("//span[text()='One-way']")).click ();
        Thread.sleep (1000);
        driver.findElement (By.cssSelector ("button[aria-label='Leaving from']")).click ();
        Thread.sleep (1000);
        driver.findElement (By.id ("location-field-leg1-origin")).sendKeys ("CLT");
        Thread.sleep (1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//div[normalize-space()='North Carolina, United " +
                "States']")));
        driver.findElement (By.xpath ("(//button[@aria-label='Charlotte (CLT - Charlotte-Douglas Intl.) North Carolina, United States'])[1]")).click ();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit ();
    }
}

//*[@id="app-layer-origin-flight"]/div[2]/div/div[2]/div[1]/ul/li[4]/button/div/span