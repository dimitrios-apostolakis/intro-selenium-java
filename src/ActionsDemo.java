import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com/");
        Actions a = new Actions(driver);
        driver.findElement(By.cssSelector("input[data-action-type='DISMISS']")).click();
        WebElement move = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        a.moveToElement(move).contextClick().build().perform();
    }
}
