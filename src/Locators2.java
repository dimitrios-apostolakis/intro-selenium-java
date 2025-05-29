import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.xml.sax.ext.Locator2;

import java.awt.*;
import java.time.Duration;

public class Locators2 {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/"); //fully loaded
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");   //not fully loaded
        driver.navigate().back();
        driver.navigate().forward();

        String name = "dimitri";
        String password = getPassword(driver);
        Assert.assertEquals(password, "rahulshettyacademy");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);


        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();


        driver.quit();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        return driver.findElement(By.cssSelector("form p")).getText().split("'")[1];
    }
}
