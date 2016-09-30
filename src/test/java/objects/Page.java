package objects;

import elements.Locator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public abstract class Page{

    protected WebDriver driver;
    protected String dictionarySeries="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    protected String dictionaryNumber="1234567890";
    public static String currentRegionCode="00";
    public static String protocolNumber="";
    public static String resolutionNumber="";
    public static String currentDepartment="";
    public static boolean descendingStatus=false;

    public Page(WebDriver driver){
       this.driver = driver;
   }

    public void typeAndClick(WebElement element,String name){
        element.sendKeys(name);
        explicitWaitElement(driver, driver.findElement(By.xpath(Locator.findBoundList(name))));
        driver.findElement(By.xpath(Locator.findBoundList(name))).click();
    }

    public void scrollIntoElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAndPick(WebElement element,String name) throws InterruptedException {
        scrollIntoElement(element);
        //System.out.println(element.getAttribute("id"));
        element.click();
       // Thread.sleep(10000);
        explicitWaitElement(driver, driver.findElement(By.xpath(Locator.findBoundList(name))));
        driver.findElement(By.xpath(Locator.findBoundList(name))).click();
    }

    public void clickAndPickNoScroll(WebElement element,String name) throws InterruptedException {
        //scrollIntoElement(element);
        //System.out.println(element.getAttribute("id"));
        element.click();
        // Thread.sleep(10000);
        explicitWaitElement(driver, driver.findElement(By.xpath(Locator.findBoundList(name))));
        driver.findElement(By.xpath(Locator.findBoundList(name))).click();
    }

    public void doubleClick (WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void chromeClick (WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void typeAddress(WebElement element,String data) throws InterruptedException {
        String[] addressArr = data.split(",");
        element.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(100);
        //System.out.println(data);
        //System.out.println(addressarr);
        ArrayList<String> address = new ArrayList<String>(Arrays.asList(addressArr));
        //System.out.println(address);
        for (String temp:address) {
            element.sendKeys(temp);
            Thread.sleep(700);
            WebElement tempElement=driver.findElement(By.xpath(Locator.findBoundListInstance(temp)));
            //driver.findElement(By.xpath(Locator.findBoundList(temp))).click();
            String instanceId=tempElement.getAttribute("id");
            explicitWaitElement(driver, driver.findElement(By.xpath(".//*[@id='" + instanceId + "']/" + Locator.findBoundListForClick(temp))));
            driver.findElement(By.xpath(".//*[@id='" + instanceId + "']/" + Locator.findBoundListForClick(temp))).click();
        }
       // String temp = utils.ExcelRead.extract(address);
        //element.sendKeys(temp);
       // Thread.sleep(500);
        //explicitWaitElement(driver, driver.findElement(By.xpath(Locator.findBoundList(temp))));
      //  WebElement tempElement=driver.findElement(By.xpath(Locator.findBoundListInstance(temp)));
      //  driver.findElement(By.xpath(Locator.findBoundList(temp))).click();
      //  String instanceId=tempElement.getAttribute("id");
     //   while (!address.isEmpty()) {
     //       temp = utils.ExcelRead.extract(address);
    //        element.sendKeys(temp);
    //        //System.out.println(instanceId);
     //       explicitWaitElement(driver, driver.findElement(By.xpath(".//*[@id='" + instanceId + "']/" + Locator.findBoundListForClick(temp))));
     //       driver.findElement(By.xpath(".//*[@id='" + instanceId + "']/" + Locator.findBoundListForClick(temp))).click();
        //}
    }

    public void explicitWaitElement (WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWaitTextPresent (WebDriver driver, WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public String generateNumber()
    {
        return currentRegionCode+" "+randomFromDictionary(2,dictionarySeries)+" "+randomFromDictionary(6,dictionaryNumber);
    }

    public String randomFromDictionary(int length, String dictionary){
        Random rand = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = dictionary.charAt(rand.nextInt(dictionary.length()));
        }
        return new String(text);
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void findLoadmask (WebDriver driver, String text){
        WebElement loadmask = driver.findElement(By.xpath(".//div[string-length(@id)=13 and starts-with(@id,'loadmask-')]"));
        //driver.findElement(By.xpath(".//div[string-length(@id)=13 and starts-with(@id,'loadmask-') and not(contains(@style,'display: none'))]"));
        //WebElement loadmask = driver.findElement(By.xpath(".//div[string-length(@id)=13 and starts-with(@id,'loadmask-')]/descendant::*[contains(text(),'"+text+"']"));
       // WebElement loadmask = driver.findElement(By.xpath(".//div[string-length(@id)=13 and starts-with(@id,'loadmask-') and not(contains(@style,'display: none'))]/descendant::*[contains(text(),'"+text+"']"));
    }

   // public static void assertToast(string)

}
