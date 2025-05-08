import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {
        // Get the location of your currently active window (IntelliJ)
        Point location = MouseInfo.getPointerInfo().getLocation();
        // Set up Chrome options with position
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=" + location.x + "," + (location.y-=400));
        // Optionally set window size
//        options.addArguments("--window-size=1200,800");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("dimitri");
        driver.findElement(By.name("inputPassword")).sendKeys("abc123");
        driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector(".signInBtn")).click();
        System.out.println(driver.findElement(By.className("error")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); //not good practice, will be replaced with explicit waits
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Dimitri");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("dimitris@apostolakis.com");
//        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
//        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
//        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("dimitris@apostolakis.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000); //not good practice, will be replaced with explicit waits
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


//        driver.quit();
    }
}
