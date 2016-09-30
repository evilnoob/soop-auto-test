package objects.eal.admcase.all;

import elements.*;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class CreateEmployee extends Page {

    public CreateEmployee(WebDriver driver) {
        super(driver);
    }


    public WebElement surname = InputField.inputFieldFromForm(driver, "Добавить нового сотрудника", "Фамилия");
    public WebElement name = InputField.inputFieldFromForm(driver, "Добавить нового сотрудника", "Имя");
    public WebElement patronymic = InputField.inputFieldFromForm(driver, "Добавить нового сотрудника", "Отчество");
    public WebElement birthDate = InputField.inputFieldFromForm(driver, "Добавить нового сотрудника", "Дата рождения");
    public WebElement department = InputField.inputFieldFromForm(driver, "Добавить нового сотрудника", "Тер. орган");
    public WebElement unit = BoundList.inputFieldFromForm(driver, "Добавить нового сотрудника", "Служба");
    public WebElement position = BoundList.inputFieldFromForm(driver, "Добавить нового сотрудника", "Должность");
    public WebElement rank= BoundList.inputFieldFromForm(driver, "Добавить нового сотрудника", "Звание");
    public WebElement saveButton = Button.buttonFromWindow(driver,"Сотрудники","Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver,"Сотрудники","Отмена");
    //public WebElement saveButton = Button.buttonFromWindow(driver,"Добавить нового сотрудника","Сохранить");
    //public WebElement cancelButton = Button.buttonFromWindow(driver,"Добавить нового сотрудника","Отмена");


    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void surnameInput(String data) {
        surname.sendKeys(data);
    }

    @Step("Заполнение поля \"Имя\" значением {0}.")
    public void nameInput(String data) {
        name.sendKeys(data);
    }

    @Step("Заполнение поля \"Отчество\" значением {0}.")
    public void patronymicInput(String data) {
        patronymic.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата рождения\" значением {0}.")
    public void birthDateInput(String data) {
        birthDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Служба\" значением {0}.")
    public void unitInput(String data){
        typeAndClick(unit, data);
    }

    @Step("Заполнение поля \"Должность\" значением {0}.")
    public void positionInput(String data){
        typeAndClick(position, data);
    }

    @Step("Заполнение поля \"Звание\" значением {0}.")
    public void rankInput(String data){
        typeAndClick(rank, data);
        surname.click();
    }

    @Step("Нажатие кнопки \"Сохранить\".")
     public void saveButtonClick() throws InterruptedException {
        Thread.sleep(100);
        saveButton.click();
    }

    @Step("Нажатие кнопки \"Отмена\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }
}
