package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Button{

    public static WebElement logoutButton(WebDriver driver){
        return driver.findElement(By.xpath(Locator.findLogoutButton()));
    }

    public static WebElement switchModuleButton(WebDriver driver){
        return driver.findElement(By.xpath(Locator.findSwitchModuleButton()));
    }

    public static WebElement button(WebDriver driver,String name){
        return driver.findElement(By.xpath(Locator.findButton(name)));
    }

    public static WebElement numberedButtonFromGradientBlock(WebDriver driver,String blockName,String position){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName)+".//a[string-length(@id)=11 and starts-with(@id,'button-') and position()="+position+"]"));
        //List<WebElement> el = driver.findElements(By.xpath(Locator.findGradientBlock("Нарушитель")+".//a[string-length(@id)=11 and starts-with(@id,'button-')]"));
        //return(el.get(Integer.parseInt(position)-1));
    }

    public static WebElement numberedButtonFromExtComp(WebDriver driver,String blockName,String position){
        List<WebElement> el = driver.findElements(By.xpath(Locator.findExtCompFromTitle("Нарушитель")+".//a[string-length(@id)=11 and starts-with(@id,'button-')]"));
        return(el.get(Integer.parseInt(position)-1));
    }

    public static WebElement buttonFromBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findBlock(blockName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromSearchGrid(WebDriver driver,String name){
        return driver.findElement(By.xpath(".//div[string-length(@id)=15 and starts-with(@id,'searchgrid-')]/" + Locator.findButton(name)));
    }

    public static WebElement buttonFromExtComp(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findExtCompFromTitle(blockName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromWindow(WebDriver driver,String windowName,String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromFieldset(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findFieldsetInWindow(blockName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromMessageBox(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findMessageBox(blockName) + Locator.findButton(name)));
    }

    public static WebElement buttonFromUnknownContainer(WebDriver driver,String name) {
        return driver.findElement(By.xpath(Locator.findUnknownContainer+Locator.findButton(name)));
    }

    public static WebElement buttonWithDataQtip(WebDriver driver,String name) {
        return driver.findElement(By.xpath(Locator.findButtonWithDataQtip(name)));
    }

}
