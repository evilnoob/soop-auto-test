package objects.eal.admcase.resolution.assignment;

import elements.AddressField;
import elements.BoundList;
import elements.InputField;
import objects.eal.admcase.all.offence.Offence;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;

public class AssignmentOffence extends Offence {

    public AssignmentOffence(WebDriver driver) {
        super(driver);
    }

    public WebElement crimeAddress = AddressField.inputFieldFromGradientBlock(driver, "Нарушение", "Адрес совершения");
    public WebElement crimeFlat = InputField.inputFieldFromGradientBlock(driver, "Нарушение", "Кв.");
    public WebElement crimeDate = InputField.inputFieldFromGradientBlock(driver, "Нарушение", "Дата совершения");
    public WebElement crimeTime = InputField.inputFieldFromGradientBlock(driver, "Нарушение", "Время совершения");
    public WebElement crimePlace = BoundList.inputFieldFromGradientBlock(driver, "Нарушение", "Место совершения");

    @Step("Заполнение поля \"Адрес совершения\" значением {0}.")
    public void crimeAddressInput(String data) throws InterruptedException {
        typeAddress(crimeAddress, data);
    }

    @Step("Заполнение поля \"Кв.\" значением {0}.")
    public void crimeFlatInput(String data){
        crimeFlat.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата совершения\" значением {0}.")
    public void crimeDateInput(String data){
        crimeDate.clear();
        crimeDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата совершения\" значением системной даты.")
    public void crimeDateSetSystem(){
        crimeDate.clear();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        crimeDate.sendKeys(date);
    }

    @Step("Заполнение поля \"Время совершения\" значением {0}.")
    public void crimeTimeInput(String data) {
        crimeTime.clear();
        crimeTime.sendKeys(data);
    }

    @Step("Заполнение поля \"Место совершения\" значением {0}.")
    public void crimePlaceInput(String data){
        typeAndClick(crimePlace, data);
    }

}
