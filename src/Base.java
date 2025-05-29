import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;

public class Base {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(BrowserUtils.getPositionedChromeOptions(500));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] items = {"Cucumber", "Brocolli"};

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
