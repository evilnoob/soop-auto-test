package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoundList extends InputField{

    public static WebElement boundList(WebDriver driver,String name){
        return driver.findElement(By.xpath(Locator.findBoundList(name)));
    }

    public static WebElement inputFieldTriggerFromExtComp(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findExtCompFromTitle(blockName) + Locator.findInputInBlock(name) + Locator.findTrigger));
    }

    public static WebElement inputFieldTriggerFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findInputInBlock(name) + Locator.findTrigger));
    }

    public static WebElement inputFieldTrigger(WebDriver driver,String name){
        return driver.findElement(By.xpath(Locator.findInputInBlock(name) + Locator.findTrigger));
    }
}
