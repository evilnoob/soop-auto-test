package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolButton{

    public static WebElement toolButtonFromWindow(WebDriver driver,String windowName) {
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findToolButtonInWindow));
    }
}