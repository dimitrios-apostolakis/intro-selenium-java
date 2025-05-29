import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;

public class BrowserUtils {

    /**
     * Creates ChromeOptions with window position set relative to current mouse position
     * @param yOffset Vertical offset from mouse position (negative moves up)
     * @return ChromeOptions with position arguments set
     * Optionally set window size
     * options.addArguments("--window-size=1200,800");
     */
    public static ChromeOptions getPositionedChromeOptions(int yOffset) {
        Point location = MouseInfo.getPointerInfo().getLocation();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=" + location.x + "," + (location.y - yOffset));
        return options;
    }

}
