package objects.eal.admcase.all.offender;

import elements.Button;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class OffenderDocumentAdd extends Page {

    public OffenderDocumentAdd(WebDriver driver) {
        super(driver);
    }

    public WebElement type = InputField.inputFieldFromWindow(driver, "Добавление документа", "Вид документа");
    public WebElement series = InputField.inputFieldFromWindow(driver, "Добавление документа", "Серия");
    public WebElement number = InputField.inputFieldFromWindow(driver, "Добавление документа", "Номер");
    public WebElement issuer = InputField.inputFieldFromWindow(driver, "Добавление документа", "Кем выдан");
    public WebElement issueDate = InputField.inputFieldFromWindow(driver, "Добавление документа", "Дата выдачи");
    public WebElement code = InputField.inputFieldFromWindow(driver, "Добавление документа", "Код органа");
    public WebElement saveButton = Button.buttonFromWindow(driver, "Добавление документа", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Добавление документа", "Отменить");

    @Step("Заполнение поля \"Тип документа\" значением {0}.")
    public void typeInput(String data) {
        type.sendKeys(data);
    }

    @Step("Заполнение поля \"Серия\" значением {0}.")
    public void seriesInput(String data) {
        series.sendKeys(data);
    }

    @Step("Заполнение поля \"Номер\" значением {0}.")
    public void numberInput(String data) {
        number.sendKeys(data);
    }

    @Step("Заполнение поля \"Кем выдан\" значением {0}.")
    public void issuerInput(String data) {
        issuer.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата выдачи\" значением {0}.")
    public void issueDateInput(String data) {
        issueDate.clear();
        issueDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Код органа\" значением {0}.")
    public void codeInput(String data) {
        code.sendKeys(data);
        type.click();
    }

    @Step("Нажатие кнопки \"Сохранить\".")
    public void saveButtonClick() {
        saveButton.click();
    }

    @Step("Нажатие кнопки \"Отменить\".")
    public void cancelButtonClick() {
        cancelButton.click();
    }

}
