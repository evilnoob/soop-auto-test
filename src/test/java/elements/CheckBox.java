package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox{

    public static WebElement checkBoxFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findCheckBox(name)));
    }

    public static WebElement checkBoxFromExtComp(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findExtCompFromTitle(blockName) + Locator.findCheckBox(name)));
    }

    public static WebElement checkBoxFromWindow(WebDriver driver,String windowName,String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findCheckBox(name)));
    }

    public static WebElement checkBoxFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findCheckBox(name)));
    }

    public static WebElement checkBoxBodyFromInput(WebDriver driver,String id){
        return driver.findElement(By.xpath(".//*[@id='" + id + "']/ancestor::div[starts-with(@id,'checkbox-') and string-length(@id)=13]"));
    }
}
