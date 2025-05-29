import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Base {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] items = {"Cucumber", "Brocolli"};
        addItems(driver, items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
        //explicit wait is added to implicit wait seconds
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'applied')]")).isDisplayed());
        //fluent wait alternative
        Wait<WebDriver> fw = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement foo = fw.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("span.promoInfo")).isDisplayed()){
                    return driver.findElement(By.cssSelector("span.promoInfo"));
                } else {
                    return null;
                }
            }
        });

        driver.quit();
    }

    public static void addItems(WebDriver driver, String[] items){
        List<WebElement> products = driver.findElements(By.className("product-name"));
        int count = 0;
        for (int i=0; i< products.size(); i++){
            String name = products.get(i).getText();
            name = name.split("-")[0].trim();
            if (Arrays.asList(items).contains(name)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
//                driver.findElements(By.xpath("//button[text()='ADD TO CART' or text()='✔ ADDED']")).get(i).click();
                count++;
                if (count == items.length) break;
            }
        }
    }
}
