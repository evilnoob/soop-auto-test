package objects.eal.admcase.all.offender;

import elements.BoundList;
import elements.Button;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class OffenderPhoneAdd extends Page {

    public OffenderPhoneAdd(WebDriver driver) {
        super(driver);
    }

    public WebElement type = BoundList.inputFieldFromWindow(driver, "Добавить телефон", "Тип телефона");
    public WebElement phoneNumber = InputField.inputFieldFromWindow(driver, "Добавить телефон", "Номер телефона");
    public WebElement saveButton = Button.buttonFromWindow(driver, "Добавить телефон", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Добавить телефон", "Отменить");

    @Step("Заполнение поля \"Тип телефона\" значением {0}.")
    public void typeInput(String data) {
        typeAndClick(type,data);
    }

    @Step("Заполнение поля \"Номер телефона\" значением {0}.")
    public void phoneNumberInput(String data) throws InterruptedException {
        phoneNumber.sendKeys(data);
        Thread.sleep(500);
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
