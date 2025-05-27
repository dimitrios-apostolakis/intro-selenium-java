import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AutoSuggestive {

    public static void main(String[] args) throws InterruptedException {

        Point location = MouseInfo.getPointerInfo().getLocation();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=" + location.x + "," + (location.y -= 400));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000L);
        List<WebElement> optionsAS = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : optionsAS){
            if (option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        List<WebElement> optionsCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(optionsCheckboxes.size());
    }
}
