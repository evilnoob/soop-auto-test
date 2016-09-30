package elements;

import org.openqa.selenium.*;


public class InputField{

    public static WebElement inputField(WebDriver driver,String name){
        return driver.findElement(By.xpath(Locator.findInputInBlock(name)));
    }

    public static WebElement inputFieldFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputNextFieldFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findNextInputInBlock(name)));
    }

    public static WebElement inputPreviousFieldFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findPreviousInputInBlock(name)));
    }

    public static WebElement inputFieldFromFieldsetFromWindow(WebDriver driver,String windowName, String blockName, String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findFieldsetInWindow(blockName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputFieldFromFieldset(WebDriver driver,String blockName, String name){
        return driver.findElement(By.xpath(Locator.findFieldsetInWindow(blockName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputPreviousFieldFromFieldset(WebDriver driver,String blockName, String name){
        return driver.findElement(By.xpath(Locator.findFieldsetInWindow(blockName) + Locator.findPreviousInputInBlock(name)));
    }

    public static WebElement inputNextFieldFromFieldset(WebDriver driver,String blockName, String name){
        return driver.findElement(By.xpath(Locator.findFieldsetInWindow(blockName) + Locator.findNextInputInBlock(name)));
    }

    public static WebElement inputFieldFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputNextFieldFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findNextInputInBlock(name)));
    }

    public static WebElement inputFieldFromExtComp(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findExtCompFromTitle(blockName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputFieldFromSearchForm(WebDriver driver,String windowName, String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName)+Locator.findInputInSearchForm(name)));
    }

    public static WebElement inputFieldFromWindow(WebDriver driver,String windowName,String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findInputInBlock(name)));
    }

    public static WebElement inputFieldInFilterFromWindow(WebDriver driver,String windowName,String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findInputInFilter(name)));
    }

    public static WebElement inputFieldInFilterFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findInputInFilter(name)));
    }

    public static WebElement inputFieldFromForm(WebDriver driver,String formName,String name){
        return driver.findElement(By.xpath(Locator.findForm(formName) + Locator.findInputInBlock(name)));
    }
}
