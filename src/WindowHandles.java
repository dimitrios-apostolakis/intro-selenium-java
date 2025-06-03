import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("//*[contains(text(), 'Free Access')]")).click();
        Set<String> windows = driver.getWindowHandles();    //[parentid, childid]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText();
        emailId = emailId.split("@")[0].split(" ")[emailId.split("@")[0].split(" ").length - 1]+ "@" + emailId.split("@")[1].split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);

    }
}
