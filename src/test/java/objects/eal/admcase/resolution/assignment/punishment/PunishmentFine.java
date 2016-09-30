package objects.eal.admcase.resolution.assignment.punishment;

import elements.*;
import objects.eal.admcase.all.Employees;
import objects.eal.admcase.resolution.assignment.ResolutionPunishment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import utils.TestEngine;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PunishmentFine extends ResolutionPunishment {

    public PunishmentFine(WebDriver driver) {
        super(driver);
    }

    public WebElement fineSum = InputField.inputFieldFromGradientBlock(driver, "Наказание", "Сумма, рублей");
    public WebElement payBefore = BoundList.inputFieldFromGradientBlock(driver, "Наказание", "Оплатить до");
    public WebElement uinButton = Button.buttonFromGradientBlock(driver, "Наказание", "УИН");
    public WebElement printReceipt = Button.buttonFromGradientBlock(driver, "Наказание", "Печать квитанции");
    public WebElement openFine = Button.buttonFromGradientBlock(driver, "Наказание", "Открыть информацию по штрафу");
    public WebElement uin = InputField.inputFieldFromGradientBlock(driver, "Наказание", "УИН");

    @Step("Заполнение поля \"Сумма, рублей\" значением {0}.")
    public void fineSumInput(String data){
        fineSum.clear();
        fineSum.sendKeys(data);
    }

    @Step("Заполнение поля \"Оплатить до\"  значением {0}.")
    public void payBeforeInput(String data){
        payBefore.clear();
        payBefore.sendKeys(data);
    }

    @Step("Заполнение поля \"Оплатить до\"  значением системной даты +3 дня.")
    public void payBeforeSetSystem() throws InterruptedException {
        payBefore.clear();
        Calendar cal = Calendar.getInstance();
        java.util.Date date = new java.util.Date();
        cal.setTime(date);
        cal.add(Calendar.DATE, 3);
        date = cal.getTime();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String dateString=sysDate.format(date);
        payBefore.sendKeys(dateString);
       // Thread.currentThread().sleep(5000);
    }

    @Step("Нажатие кнопки \"УИН\".")
    public void UINInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        uinButton.click();
        TestEngine.executeTestFromData(driver, FineUIN.class, "data\\eal\\admcase\\UIN.xlsx", "FineUIN", data);
    }

    @Step("Нажатие кнопки \"Печать квитанции\".")
    public void printReceipt(){
        printReceipt.click();
    }

    @Step("Нажатие кнопки \"Открыть информацию по штрафу\".")
    public void openFine(){
        openFine.click();
    }

}
