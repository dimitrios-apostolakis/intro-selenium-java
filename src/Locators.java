import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.time.Duration;

public class Locators {

    public static void main(String[] args) {
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


        driver.quit();
    }
}
