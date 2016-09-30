package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton{

    public static WebElement radioButtonFromGradientBlock(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findGradientBlock(blockName) + Locator.findRadioButton(name)));
    }

    public static WebElement radioButtonFromContainer(WebDriver driver,String blockName,String name){
        return driver.findElement(By.xpath(Locator.findContainer(blockName) + Locator.findRadioButton(name)));
    }

    public static WebElement radioButtonFromWindow(WebDriver driver,String windowName,String name){
        return driver.findElement(By.xpath(Locator.findWindow(windowName) + Locator.findRadioButton(name)));
    }

}
