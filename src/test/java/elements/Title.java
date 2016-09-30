package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Title{

    public static WebElement title(WebDriver driver, String name){
        return driver.findElement(By.xpath(Locator.findTitle(name)));
    }
}
