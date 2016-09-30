package objects.asv.asvcase;

import elements.BoundList;
import elements.Button;
import elements.ElementsGrid;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PhysicalCard extends Page{

    public PhysicalCard(WebDriver driver) {
        super(driver);
    }

    //public List<WebElement> offenderList = ElementsGrid.elementsGridFromWindow(driver, "Выбрать нарушителя");
    public WebElement surname = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "Фамилия");
    public WebElement name = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "Имя");
    public WebElement patronymic = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "Отчество");
    public WebElement birthDate = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "Дата рождения");
    public WebElement sex = BoundList.inputFieldFromWindow(driver, "Выбрать нарушителя", "Пол");
    public WebElement birthPlace = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "Место рождения");
    public WebElement citizenship = BoundList.inputFieldFromWindow(driver, "Выбрать нарушителя", "Гражданство");
    public WebElement saveButton = Button.buttonFromWindow(driver, "Выбрать нарушителя", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Выбрать нарушителя", "Отмена");

    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void surnameInput(String data){
        surname.sendKeys(data);
    }

    @Step("Заполнение поля \"Имя\" значением {0}.")
    public void nameInput(String data){
        name.sendKeys(data);
    }

    @Step("Заполнение поля \"Отчество\" значением {0}.")
    public void patronymicInput(String data){
        patronymic.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата рождения\" значением {0}.")
    public void birthDateInput(String data){
        birthDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Пол\" значением {0}.")
    public void sexInput(String data){
        typeAndClick(sex,data);
    }

    @Step("Заполнение поля \"Место рождения\" значением {0}.")
    public void birthPlaceInput(String data){
        birthPlace.sendKeys(data);
    }

    @Step("Заполнение поля \"Гражданство\" значением {0}.")
    public void citizenshipInput(String data){
        typeAndClick(citizenship, data);
    }

    @Step("Нажатие кнопки \"Сохранить\"")
    public void saveOrPickClick(){
        List<WebElement> offenderList = ElementsGrid.elementsSearchGridFromWindow(driver, "Выбрать нарушителя");
        if (offenderList.isEmpty()) {
            saveButton.click();
        }
        else doubleClick(driver, offenderList.get(0));
    }

    @Step("Нажатие кнопки \"Отмена\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }

    @Step("Выбор нарушителя.")
    public void chooseAndClick() throws InterruptedException {
        name.click();
        Thread.sleep(1000);
        //explicitWaitElement(driver,ElementsGrid.elementSearchGridFromWindow(driver, "Выбрать нарушителя"));
        List<WebElement> offenderList = ElementsGrid.elementsSearchGridFromWindow(driver, "Выбрать нарушителя");
        doubleClick(driver, offenderList.get(0));
    }
}
