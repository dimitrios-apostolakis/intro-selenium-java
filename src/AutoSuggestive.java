import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutoSuggestive {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
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
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        List<WebElement> optionsCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertEquals(optionsCheckboxes.size(),6);

        driver.quit();
    }
}
