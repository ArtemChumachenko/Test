import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GHTest {
    static {
        WebDriverManager.chromedriver ().setup ();
    }
    private WebDriver driver;

    @Test
    public void testName() throws InterruptedException {
        driver.get ("https://www.grubhub.com/");
        driver.findElement (By.xpath ("(//a[@href='/login'])[1]")).click ();
        driver.findElement (By.cssSelector (".ghs-goToCreateAccount")).click ();
        driver.findElement (By.id ("firstName")).sendKeys ("Ivan");
        driver.findElement (By.id ("lastName")).sendKeys ("Petrov");
        driver.findElement (By.id ("email")).sendKeys ("godexiw554@adroh.com");
        driver.findElement (By.id ("password")).sendKeys ("Artem240880");
        driver.findElement (By.cssSelector ("button[type='submit']")).click ();
        Thread.sleep (1000);
        Assert.assertEquals (driver.findElement (By.xpath ("//h1")).getText (),"Access to this page has been blocked");


    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit ();
//    }
    @Test
    public void testNameWrong() throws InterruptedException {
        driver.get ("https://www.grubhub.com/");
        driver.findElement (By.xpath ("(//a[@href='/login'])[1]")).click ();
        driver.findElement (By.cssSelector (".ghs-goToCreateAccount")).click ();
        driver.findElement (By.id ("firstName")).sendKeys ("\n");
        driver.findElement (By.id ("lastName")).sendKeys ("Petrov");
        Assert.assertEquals (driver.findElement (By.id ("firstName_error")).getText (),"First name must contain only alphabetic characters and - , .'");
    }




}
