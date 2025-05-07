import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("dimitri");
        driver.findElement(By.name("inputPassword")).sendKeys("abc123");
        driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector(".signInBtn")).click();
        driver.quit();
    }
}
