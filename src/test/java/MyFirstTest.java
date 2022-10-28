import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyFirstTest {

    static {
//        System.setProperty ("webdriver.chrome.driver","/Users/artemchumachenko/IdeaProjects/chromedriver");
        WebDriverManager.safaridriver ().setup();
    }

    private WebDriver driver;

    @Test
    public void testFirst() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement text = driver.findElement (By.id ("my-text-id"));
        Thread.sleep (3000);
        text.sendKeys ("Testing Chrome");
        Thread.sleep (2000);
        driver.findElement (By.xpath ("//button")).click ();
        String actualText = driver.findElement (By.xpath ("//h1")).getText ();
        Thread.sleep (3000);
        Assert.assertEquals (actualText, "Form submitted");
        Thread.sleep (6000);

    }

    @BeforeMethod
    public void setUp() {

         driver = new SafariDriver ();
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }





}
