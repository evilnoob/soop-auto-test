package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ElementsGrid{

    public static List<WebElement> elementsGridFromWindow(WebDriver driver, String windowName){
        return driver.findElements(By.xpath(Locator.findWindow(windowName)+Locator.findGridElements()));
    }

    public static WebElement elementGridfromWindow(WebDriver driver, String windowName){
        return driver.findElement(By.xpath(Locator.findWindow(windowName)+Locator.findGridElements()));
    }

    public static List<WebElement> elementsSearchGridFromWindow(WebDriver driver, String windowName){
        return driver.findElements(By.xpath(Locator.findWindow(windowName)+Locator.findSearchGridElements));
    }

    public static WebElement elementSearchGridFromWindow(WebDriver driver, String windowName){
        return driver.findElement(By.xpath(Locator.findWindow(windowName)+Locator.findSearchGridElements));
    }

    public static List<WebElement> elementsSearchGridFromCase(WebDriver driver, String documentTypeName){
        return driver.findElements(By.xpath(Locator.findSearchGrid(documentTypeName)+Locator.findSearchGridElements));
    }

    public static List<WebElement> elementsSearchGridFromJournal(WebDriver driver, String blockName){
        return driver.findElements(By.xpath(Locator.findExtCompFromH1(blockName)+Locator.findSearchGridElements));
    }

}
