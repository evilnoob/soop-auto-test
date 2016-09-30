package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DisplayField {

    public static WebElement displayField(WebDriver driver,String name){
        return driver.findElement(By.xpath(Locator.findDisplayField(name)));
    }

}
