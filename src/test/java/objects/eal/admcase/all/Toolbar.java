package objects.eal.admcase.all;

import elements.Button;
import elements.Locator;
import objects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import utils.TestEngine;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class Toolbar extends Page {

    public Toolbar(WebDriver driver) {
        super(driver);
    }

    public WebElement saveButton = Button.button(driver, "Сохранить");
    public WebElement closeButton = Button.buttonFromUnknownContainer(driver, "Закрыть без сохранения");

    @Step("Нажатие кнопки \"Сохранить\".")
    public void saveButtonClick() throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Thread.sleep(200);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", saveButton);
        saveButton.click();
       // System.out.println(descendingStatus+" 1");
        //if (descendingStatus==true) {
        //    TestEngine.executeTestFromData(driver, DepartmentSelect.class, "data\\eal\\admcase\\DepartmentSelect.xlsx", "DepartmentSelect", currentDepartment);
        //   descendingStatus=false;
       // }

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        try{
            if (isElementPresent(driver, By.xpath(Locator.findWindow("Выберите тер. орган дела")+"self::*"))) {
            TestEngine.executeTestFromData(driver, DepartmentSelect.class, "data\\eal\\admcase\\DepartmentSelect.xlsx", "DepartmentSelect", currentDepartment);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

       // System.out.println(descendingStatus+" 2");
        //chromeClick(driver,saveButton);
       // findLoadmask(driver,"Сохранение");
        Thread.sleep(100);
    }

    @Step("Нажатие кнопки \"Закрыть без сохранения\".")
    public void closeButtonClick(){
        closeButton.click();
    }
}