import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.awt.*;
import java.util.Objects;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {
        Point location = MouseInfo.getPointerInfo().getLocation();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=" + location.x + "," + (location.y -= 400));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000L);
        int i=0;
        while (i<2){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();


        Assert.assertTrue(Objects.requireNonNull(driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style")).contains("0.5"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Assert.assertTrue(Objects.requireNonNull(driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style")).contains("1"));

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();



//        driver.quit();
    }
}
