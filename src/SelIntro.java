import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntro {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dimit\\git\\personal-projects\\selenium-java\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
