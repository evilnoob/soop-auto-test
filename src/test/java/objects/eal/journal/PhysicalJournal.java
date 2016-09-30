package objects.eal.journal;

import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class PhysicalJournal extends EalJournal {

    public PhysicalJournal(WebDriver driver) {
        super(driver);
    }

    public WebElement surnameFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Фамилия");
    public WebElement nameFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Имя");
    public WebElement patronymicFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Отчество");
    //public WebElement birthDateFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Дата рожд");
    public WebElement articleFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Статья");
    public WebElement mainPunishmentFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Осн. нак.");
    public WebElement additionalPunishmentFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Осн. нак.");
    public WebElement protocolNumberFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "№ пр");
    public WebElement departmentFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Тер. орган");
    public WebElement chargeStatusFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Статус");
    public WebElement IBDRStatusFilter = InputField.inputFieldInFilterFromBlock(driver, "Редактировать", "Статус");

    @Step("Поиск по фамилии  нарушителя {0}.")
    public void surnameFilterInput(String data) throws InterruptedException {
        surnameFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по имени нарушителя {0}.")
    public void nameFilterInput(String data) throws InterruptedException {
        nameFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по отчеству нарушителя {0}.")
    public void patronymicFilterInput(String data) throws InterruptedException {
        patronymicFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по статье {0}.")
    public void articleFilterInput(String data) throws InterruptedException {
        articleFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по основному наказанию {0}.")
    public void mainPunishmentFilterInput(String data) throws InterruptedException {
        mainPunishmentFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по дополнительному наказанию {0}.")
    public void additionalPunishmentFilterInput(String data) throws InterruptedException {
        additionalPunishmentFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по номеру протокола{0}.")
    public void protocolNumberFilterInput(String data) throws InterruptedException {
        //System.out.println(protocolNumber);
        if (data.equals("Текущий")){
            protocolNumberFilter.sendKeys(protocolNumber);
        } else {
            protocolNumberFilter.sendKeys(data);
        }
        Thread.sleep(1000);
        selectIfPresent();
    }

    @Step("Поиск по территориальному органу {0}.")
    public void departmentFilterInput(String data) throws InterruptedException {
        departmentFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по статусу оплаты {0}.")
    public void chargeStatusFilterInput(String data) throws InterruptedException {
        chargeStatusFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск по статусу отправки в ИБД-Р {0}.")
    public void IBDRStatusFilterInput(String data) throws InterruptedException {
        IBDRStatusFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }


}
