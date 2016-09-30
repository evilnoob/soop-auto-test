package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea{

    public static WebElement textAreaFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findTextAreaInBlock(name)));
    }
    public static WebElement textAreaUnnamedFromBlock(WebDriver driver,String blockName) {
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + "/descendant::textarea"));
    }

    public static WebElement textAreaFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findTextAreaInBlock(name)));
    }
}
