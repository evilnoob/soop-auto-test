package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label{

    public static WebElement label(WebDriver driver,String input){
        return driver.findElement(By.xpath(Locator.findLabel(input)));
        //return driver.findElement(By.xpath(".//label[contains(text(),'"+input+"')]"));
    }

    public static WebElement labelFromWindowFromTextfield(WebDriver driver,String windowName){
        //return driver.findElement(By.xpath(Locator.findWindow(windowName)+".//label[not(contains(@class,'x-unselectable'))]/descendant::span"));
        //System.out.println(driver.findElement(By.xpath(Locator.findWindow(windowName)+"self::*")).getAttribute("id"));
        //System.out.println(driver.findElement(By.xpath(Locator.findWindow(windowName)+"self::*")).getText());
        //System.out.println(driver.findElement(By.xpath(Locator.findWindow(windowName)+"descendant::span")).getText());
        //for (WebElement l:driver.findElements(By.xpath(Locator.findWindow(windowName)+"descendant::span"))){
        //    System.out.println(l.getAttribute("class")+" "+l.getText());
        //}
        //System.out.println(driver.findElement(By.xpath(Locator.findWindow(windowName)+"descendant::span")).getAttribute("value"));
        //return driver.findElement(By.xpath(Locator.findWindow(windowName)+"self::*"));
        return driver.findElement(By.xpath(Locator.findWindow(windowName)+".//span[contains(text(),'Для')]"));
       // return driver.findElement(By.xpath(Locator.findWindow(windowName)+".//label[not(contains(@class,'x-unselectable'))]"));
    }
}
